package annotation;

import java.lang.annotation.*;

/*
*
* meta annotation: annotation that used to describe another annotation

     ElementType.TYPE: can be applied on class
     ElementType.FIELD: can be applied on member variables
     ElementType.METHOD: can be applied on methods
 *
 *
    @Retention(RetentionPolicy.RUNTIME): this annotation will keep in Class file and read by JVM.

    @Inherited: this annotation can be inherited by sub anno class(@interface)
 *
 *
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MetaAnno03 {



}
