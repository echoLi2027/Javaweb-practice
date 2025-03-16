package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetFieldsConstructorMethods02 {
/*    class对象功能：
            * 获取功能：
            1. 获取成员变量们
				* Field[] getFields() ：获取所有public修饰的成员变量
				* Field getField(String name)   获取指定名称的 public修饰的成员变量

				* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
				* Field getDeclaredField(String name)
			2. 获取构造方法们
				* Constructor<?>[] getConstructors()
				* Constructor<T> getConstructor(类<?>... parameterTypes)

				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
				* Constructor<?>[] getDeclaredConstructors()
			3. 获取成员方法们：
            * Method[] getMethods()
				* Method getMethod(String name, 类<?>... parameterTypes)

				* Method[] getDeclaredMethods()
				* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

			4. 获取全类名
				* String getName()*/
public static void main(String[] args) throws Exception{

//    0.get Person obj
    Class<Person> personClass = Person.class;

    Field[] fields = personClass.getFields();
    for (Field field : fields) {
        System.out.println(field);
    }

    System.out.println("===========");
    Field aField = personClass.getField("a");
//    get member variable a value
    Person person = new Person();
    Object value = aField.get(person);
    System.out.println(value);
    aField.set(person, "tester");
    System.out.println(person);


    System.out.println("===========");
    Field[] declaredFields = personClass.getDeclaredFields();
    for (Field declaredField : declaredFields) {
        System.out.println(declaredField);
    }

    System.out.println("===========");
    Field d = personClass.getDeclaredField("d");
    d.setAccessible(true);
    Object o = d.get(person);
    System.out.println(o);

    System.out.println("===========");
//    string and int are the input type of constructor
    Constructor constructor = personClass.getConstructor(String.class, int.class);
    Object Personobj = constructor.newInstance("testName", 23);
    System.out.println(Personobj);

    System.out.println("===========");
    Person instance = personClass.newInstance();
    System.out.println(instance);


    System.out.println("===========");
    Method eat = personClass.getMethod("eat");
    eat.invoke(personClass.newInstance());

    System.out.println("============");
    Method eat2 = personClass.getMethod("eat",String.class);
    eat2.invoke(personClass.newInstance(),"dumpling");

    System.out.println("============");
    Method[] methods = personClass.getMethods();
    for (Method method : methods) {
        System.out.println(method);
        System.out.println(method.getName());
    }

//    get class name
    System.out.println(personClass.getName());




}
}
