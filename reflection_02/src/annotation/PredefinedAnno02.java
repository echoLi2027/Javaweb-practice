package annotation;


import java.util.Date;
//Even if there is error it wouldn't show
@SuppressWarnings("all")
public class PredefinedAnno02 {


    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
//        method with flaw but cannot delete directly maybe it has some relation with other part
    }

    public void show2(){
//        substitute for show1()
    }

    public void demo(){
        show1();
        Date data = new Date();
    }

}
