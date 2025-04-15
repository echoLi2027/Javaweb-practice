package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

//        1. create new real class
        Lenovo lenovo = new Lenovo();

//        2. using dynamic proxy to enhance lenovo obj
//        WARNING: all the params in proxy method is related to real obj(here is lenovo)
//         which means it can enhance the functionality of real obj not other obj.
        /**
         * this is quit fixed
         *
         * return type is the interface not the real obj type.
         *
         * Params:
         * loader – the class loader to define the proxy class
         * interfaces – the list of interfaces for the proxy class to implement
         * h – the invocation handler to dispatch method invocations to
         */
        SaleComputer lenovo_proxy = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("invoke lenovo proxy....");

//                enhance method
//                0. if it's assigned method
                if (method.getName().equals("sale")) {
//                    1. enhance params
                    double money = (double) args[0];
//                    the actual price I bought from lenovo company.
                    money = money * 0.8;

//                    2.1 enhance function body.
                    System.out.println("send a car to pick the customer.....");

//                    using real obj to call this method, using enhanced param
                    String obj = (String) method.invoke(lenovo, money);

//                    2.2 enhance function body.
                    System.out.println("drive the customer home.....");

//                    3. enhance return result
                    return obj + " plus a mouse and extended keyboard.";

                } else {
                    Object object = method.invoke(lenovo, args);
                    return object;
                }
            }
        });


//        call the method
        lenovo_proxy.sale(100000);

        lenovo_proxy.show();

    }
}
