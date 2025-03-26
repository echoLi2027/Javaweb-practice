package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XPathSelectorFunctions06 {

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
//        2. get document obj, according to xml document
//        2.1 get student.xml's path
        String path = XPathSelectorFunctions06.class.getClassLoader().getResource("selfdefinedXML01.xml").getPath();
//        2.2 parse xml document, loading file into memory, get dom tree--->document
        Document document = Jsoup.parse(new File(path), "UTF-8");

//        3. according to document obj create JXDocument obj
        JXDocument jxDocument = new JXDocument(document);

//        4.1search all user tag
        List<JXNode> jxNodes = jxDocument.selN("//user");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");

//        4.2 search user tag's subtag which has name tag
        List<JXNode> jxNodes1 = jxDocument.selN("//user/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");

//        4.3 search user tag's name subtag which has id attr
        List<JXNode> jxNodes2 = jxDocument.selN("//user/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");

//        4.4 search user tag's name subtag which has id attr and id value is CalTech01
        List<JXNode> jxNodes3 = jxDocument.selN("//user/name[@id='CalTech01']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");


    }
}
