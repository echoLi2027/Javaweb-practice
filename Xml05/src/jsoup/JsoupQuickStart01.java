package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupQuickStart01 {

    public static void main(String[] args) throws IOException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = JsoupQuickStart01.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");
//        3. get element obj Element
        Elements users = document.getElementsByTag("user");

        System.out.println(users.size());
//        3.1 get 1st user's Element obj
        Element element = users.get(0);
//        3.2 get data
        String text = element.text();
        System.out.println(text);


    }
}
