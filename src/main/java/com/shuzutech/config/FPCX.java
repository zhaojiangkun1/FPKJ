package com.shuzutech.config;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FPCX {

    public static String fpcx(String sbbh,String fplxdm,String fpqqlsh) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id","FPCX");
        Document document = new Document(business);
        Element body = new Element("body");
        business.addContent(body);
        Element input = new Element("input");
        body.addContent(input);
        Element jsbh = new Element("jsbh");
        input.addContent(jsbh.setText(sbbh));
        Element nsrsbh = new Element("nsrsbh");
        input.addContent(nsrsbh.setText(""));
        Element fplx = new Element("fplxdm");
        input.addContent(fplx.setText(fplxdm));
        Element cxfs = new Element("cxfs");
        input.addContent(cxfs.setText("1"));
        Element cxtj = new Element("cxtj");
        input.addContent(cxtj.setText(fpqqlsh));
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(document, byteRep);
        String strXml = byteRep.toString();
        return strXml;
    }
}
