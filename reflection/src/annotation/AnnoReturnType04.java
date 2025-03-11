package annotation;

/*
*
* actually each attribute in annotation is like an abstract method
* just this method has 4 required return types.
*
* 1.basic data type: int, bool, double...
* 2.String
* 3.Enum
* 4.Annotation
*
*
*
* */

public @interface AnnoReturnType04 {

   int value();
   TestAnno anno();
   TestEnum enu();
   String[] strs() default {"str1", "str2", "str3"};
   String name() default "tester";

   int age();

}
