package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupElementFunctions04 {

    public static void main(String[] args) throws IOException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = JsoupElementFunctions04.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");

        /*
        Element：元素对象
				1. 获取子元素对象
					* getElementById(String id)：根据id属性值获取唯一的element对象
					* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合

				2. 获取属性值
					* String attr(String key)：根据属性名称获取属性值
				3. 获取文本内容
					* String text():获取所有字标签的纯文本内容
					* String html():获取标签体的所有内容(包括子标签的标签和文本内容)

         */
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("------------------------------------");

//        3. through Element obj get sub tag obj
        Element element = document.getElementsByTag("user").get(0);
        Elements elements_name = element.getElementsByTag("name");
        System.out.println(elements_name.size());
        System.out.println("------------------------------------");

//        get user obj's attribute value
        String number = element.attr("number");
        System.out.println(number);
        System.out.println("------------------------------------");

//        get text content
        String text = element.text();
        String html = element.html();
        System.out.println(text);
        System.out.println(html);


    }
}
