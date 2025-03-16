package annotation.calculatorSummary;


import annotation.reflectByAnno.Pro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*
* simple test structure
*
* when main method executed, it'll automatically check methods with @CheckCalcu, check whether method has exception or not
* if there is exception, will log into file
* */
public class TestCheck {


    public static void main(String[] args) throws IOException {

//        1.create calculator obj
        Calculator calculator = new Calculator();
//        2.get class file
        Class<? extends Calculator> calculatorClass = calculator.getClass();
//        3.get all methods
        Method[] methods = calculatorClass.getMethods();

        int error_count = 0;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
//        4.check whether it has annotation
            if (method.isAnnotationPresent(CheckCalcu.class)){
//                5. execute if there is no exception
                try {
                    method.invoke(calculator);
                }catch (Exception e) {
//                    6. catch the exception
//                    log into file
                    error_count++;

                    bufferedWriter.write(method.getName()+" method has exception.");
                    bufferedWriter.newLine();
                    bufferedWriter.write("exception name:"+e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("exception reason:"+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("==========================");
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.write("this test cause "+error_count+" errors.");

        bufferedWriter.flush();
        bufferedWriter.close();


    }
}
