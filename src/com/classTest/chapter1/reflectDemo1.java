package com.classTest.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName reflectDemo1
 * @Description 可以创建任意类的对象，可以执行任意方法
 * @Author 22936
 * @Date 2021/5/11 14:32
 * @Version 1.0
 */

public class reflectDemo1 {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        ClassLoader classLoader = reflectDemo1.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties"); // 在此类包下取资源，最终由classloader获取资源。
        props.load(is);


        String className = props.getProperty("className");
        String methodName = props.getProperty("methodName");


        Class cls = Class.forName(className);   //通过反射，将类加载进入内存
        Object obj = cls.newInstance();         //建立新的对象
        Method method = cls.getMethod(methodName); //获取指定的方法
        method.invoke(obj);         //执行方法
    }

}
