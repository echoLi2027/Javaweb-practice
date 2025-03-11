package annotation;

@AnnoReturnType04(value = 6, anno = @TestAnno, enu = TestEnum.ENUM1, age = 28, name = "tester")
@MetaAnno03
public class AnnoReturnTypeTest05 {

    @MetaAnno03
    public String name = "tester";

    @MetaAnno03
    public void test(){

    }


}
