package annotation.reflectByAnno;


import java.lang.reflect.Method;

@Pro(className = "annotation.reflectByAnno.TestDemo1", methodName = "add")
public class ReflectTest {


    public static void main(String[] args) throws Exception {

//        1. analyse annotation
//        1.1 get this class file obj
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
//        2.get the annotation of this class
        /*
        * the underlie fact is generating a implementation obj of this annotation interface in the memory
        *
        * public class ProImpl implements Pro{
        *   public String className(){
        *       return "annotation.reflectByAnno.TestDemo1";
        *   }
        *
        *   public String methodName(){
         *       return "add";
         *   }
        * }
        *
        * */
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
//        3.call abstract methods in the anno obj, and get return value
        String className = annotation.className();
        String methodName = annotation.methodName();

//        4.load the class into memory
        Class<?> demoObj = Class.forName(className);
//        5.create obj
        Object o = demoObj.newInstance();
//        6.call the method
        Method method = demoObj.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(o, 4, 5);
        System.out.println(result);


    }

}
