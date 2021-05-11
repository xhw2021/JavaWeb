package com.classTest.chapter1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName CalculatorTest
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/11 14:53
 * @Version 1.0
 */

public class CalculatorTest {

    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();

        int num = 0;   //记录异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for(Method method:methods){
            if(method.isAnnotationPresent(Check.class)){
                try{
                    method.invoke(c);
                }catch(Exception e){
                    num ++ ;

                    bw.write(method.getName() + "方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称为："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因是："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现 "+num+" 次异常");
        bw.flush();
        bw.close();
    }

}
