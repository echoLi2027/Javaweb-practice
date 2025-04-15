package proxy;


/**
 * real class that can be enhanced to particular method.
 */
public class Lenovo implements SaleComputer  {
    @Override
    public String sale(double money) {
        System.out.println("spend $"+money+" bought a computer.");
        return "Lenovo shop direct sale.";
    }

    @Override
    public void show() {
        System.out.println("show lenovo computer.");
    }
}
