package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupParse02 {

    public static void main(String[] args) throws IOException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = JsoupParse02.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");

//        2.parse(String html): parse xml or html string
        String str = "<user id=\"1\">\n" +
                "        <name>Sheldon</name>\n" +
                "        <age>23</age>\n" +
                "        <gender>male</gender>\n" +
                "        <br/>\n" +
                "    </user>";

        Document document1 = Jsoup.parse(str);
        System.out.println(document1);

        System.out.println("-------------------------");
//        3.parse(URL url, int timeoutMillis): via website path to get appointed html or xml document
        URL url = new URL("https://www.google.com");
        Document document2 = Jsoup.parse(url, 10000);
        System.out.println(document2);


    }
}
