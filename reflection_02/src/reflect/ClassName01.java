package reflect;

import domain.Person;
import domain.Student;

public class ClassName01 {

    public static void main(String[] args) throws Exception {

//        3 ways to load the class into memory
        Class<?> aClass = Class.forName("domain.Person");
        System.out.println(aClass);

        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        System.out.println(aClass1);

        System.out.println(aClass == personClass);
        System.out.println(personClass == aClass1);
        System.out.println(aClass == aClass1);

        Class studentClass = Student.class;
        System.out.println(studentClass == personClass);
    }
}
