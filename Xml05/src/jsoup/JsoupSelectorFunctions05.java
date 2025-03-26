package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupSelectorFunctions05 {

    public static void main(String[] args) throws IOException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = JsoupSelectorFunctions05.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");

//        3. search name tag
        Elements eles = document.select("name");
        System.out.println(eles);
        System.out.println("---------------");

//        4. search id=CalTech's elements
        Elements elements = document.select("#CalTech");
        System.out.println(elements);
        System.out.println("---------------");

//        5.get user tag and the number attr value is 1's age subtag
        Elements elements1 = document.select("user[number='1']");
        System.out.println(elements1);
        System.out.println("---------------");

        Elements elements2 = document.select("user[number='1'] > age");
        System.out.println(elements2);


    }
}
