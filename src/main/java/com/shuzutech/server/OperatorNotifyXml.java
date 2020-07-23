package com.shuzutech.server;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class OperatorNotifyXml {

    public static void write(String result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\FPKJ\\src\\main\\resources\\fptz.xml"));
        bw.write(result);
        bw.newLine();
        bw.close();
        System.out.println("写入成功");
    }

    public static String readFile(String fileName) throws IOException{
        String s;
        String body = "";
        File file = new File(fileName);
        while (!file.exists()){
            System.out.println("文件不存在，请确认文件路径是否正确！！！");
            break;
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((s=bufferedReader.readLine())!=null){
            body = body + s;
        }
        bufferedReader.close();
        System.out.println("请求报文:"+body);
        return body;
    }

    public static boolean isXmlDocument(String rtnMsg) {

        boolean flag = true;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(rtnMsg)));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    public static String parseXml(String file, String nodeName) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Element root = document.getDocumentElement();
        NodeList inputlist = root.getElementsByTagName("body");
        Node item = inputlist.item(0);
        Element inputElement = (Element) item;
        NodeList nodeList = inputElement.getElementsByTagName(nodeName);
        return nodeList.item(0).getTextContent();

    }


    public static void main(String[] args){
        String file = "D:\\IdeaProjects\\FPKJ\\src\\main\\resources\\fptz.xml";
        String sFile = "";
        try {
            sFile = readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(isXmlDocument(sFile));
        try {
            parseXml(file, "returnmsg");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}
