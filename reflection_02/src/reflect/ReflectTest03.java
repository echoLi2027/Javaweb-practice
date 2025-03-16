package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest03 {

    public static void main(String[] args) throws Exception {
//        1.load setting file
//        1.1 create properties obj
        Properties properties = new Properties();
//        1.2loading properties file, convert into a collection
//        1.2.1get class catalogue
        ClassLoader classLoader = ReflectTest03.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

//        2.get data from pro.properties
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

//        3.load this class into memory
        Class<?> person = Class.forName(className);
//        4.create object
        Object p1 = person.newInstance();
//        5.get object method
        Method method = person.getMethod(methodName);
//        6.execute method
        method.invoke(p1);


    }
}
