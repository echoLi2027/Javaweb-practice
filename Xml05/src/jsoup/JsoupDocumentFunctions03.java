package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDocumentFunctions03 {

    public static void main(String[] args) throws IOException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = JsoupDocumentFunctions03.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");

//        3. get element obj
//        3.1get all user obj
        Elements elements = document.getElementsByTag("user");
        System.out.println(elements);

        System.out.println("--------------");

//        3.2get element objs which attribute name is "id";
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id);
        System.out.println("------------");

//        3.2 get number=1's element obj
        Elements numbers = document.getElementsByAttributeValue("number", "1");
        System.out.println(numbers);
        System.out.println("------------");

//        3.3 get element objs which attribute has this value.
        Element num = document.getElementById("CalTech");
        System.out.println(num);


    }
}
