package annotation.calculatorSummary;


public class Calculator {

    @CheckCalcu
    public void add() {
        String str = null;
        str.toString();
        System.out.println("1 + 0 =" + (1 + 0));
    }

    @CheckCalcu
    public void sub() {
        System.out.println("1 - 0 =" + (1 - 0));
    }

    @CheckCalcu
    public void mul() {
        System.out.println("1 * 0 =" + (1 * 0));
    }

    @CheckCalcu
    public void div() {
        System.out.println("1 / 0 =" + (1 / 0));
    }

    @CheckCalcu
    public void show() {
        System.out.println("no annotation on top of this method.");
    }

}
