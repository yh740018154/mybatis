package cn.com.datu.mybatis.parse.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author yangheng
 * @Classname ParseXml
 * @Description TODO
 * @Date 2019/11/4 16:08
 * @group smart video north
 */
public class ParseXml {
    //获取mybatis的路径
    private static String PATH = Thread.currentThread().getContextClassLoader().getResource("mybatis.xml").getPath();

    public Document getDoc() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        return docBuilder.parse(PATH);
    }
}
