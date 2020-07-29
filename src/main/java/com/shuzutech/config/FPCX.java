package com.shuzutech.config;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class FPCX {

    public static String fpcx(HashMap<String,String> map) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id","FPCX");
        Document document = new Document(business);
        Element body = new Element("body");
        business.addContent(body);
        Element input = new Element("input");
        body.addContent(input);
        if (map.containsKey("jsbh")){
            Element jsbh = new Element("jsbh");
            input.addContent(jsbh.setText(map.get("jsbh")));
        }
        if (map.containsKey("kpzdbs")){
            Element kpzdbs = new Element("kpzdbs");
            input.addContent(kpzdbs.setText(map.get("kpzdbs")));
        }
        Element nsrsbh = new Element("nsrsbh");
        input.addContent(nsrsbh.setText(""));
        Element fplx = new Element("fplxdm");
        input.addContent(fplx.setText(map.get("fplxdm")));
        Element cxfs = new Element("cxfs");
        input.addContent(cxfs.setText("1"));
        Element cxtj = new Element("cxtj");
        input.addContent(cxtj.setText(map.get("fpqqlsh")));
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(document, byteRep);
        String strXml = byteRep.toString();
        return strXml;
    }
}
