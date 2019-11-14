package Model;

import Config.UpdateFpqqlsh;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MultiLineGroup {

    public static String multiLineGroup(String fplx,int a) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id","FPKJ");
        Document document = new Document(business);
        Element body = new Element("body");
        Element input = new Element("input");
        body.addContent(input);
        Element fppqqlsh = new Element("fpqqlsh");
        input.addContent(fppqqlsh.setText(UpdateFpqqlsh.numbersLetters()));
        Element shnsrsbh = new Element("shnsrsbh");
        input.addContent(shnsrsbh.setText("110101201601010075"));
        Element jsbh = new Element("jsbh");
        input.addContent(jsbh.setText("110101201601010075~~499000153838"));

        Element kplx = new Element("kplx");
        input.addContent(kplx.setText("0"));
        Element yhlx = new Element("yhlx");
        input.addContent(yhlx.setText("0"));
        Element ghdwsbh = new Element("ghdwsbh");
        input.addContent(ghdwsbh.setText("91310114MA1GU3NU72"));
        Element ghdwmc = new Element("ghdwmc");
        input.addContent(ghdwmc.setText("上海融族网络科技有限公司"));
        Element ghdwdzdh = new Element("ghdwdzdh");
        input.addContent(ghdwdzdh.setText("上海市浦东新区康威路1500号3幢1层103室02158958286"));
        Element ghdwyhzh = new Element("ghdwyhzh");
        input.addContent(ghdwyhzh.setText("中国建设银行股份有限公司上海张江支行31050161393600001918"));

        Element fyxm = new Element("fyxm");
        Element fplxdm = new Element("fplxdm");
        if (fplx == "026" || fplx == "007" || fplx == "004"){
            input.addContent(fplxdm.setText(fplx));
            if (a > 0){
                fyxm.setAttribute("count",""+a);
                input.addContent(fyxm);
                if (fplx == "007" || fplx == "004"){
                    Element qdbz = new Element("qdbz");
                    if (a > 8){
                        input.addContent(qdbz.setText("1"));
                    }else
                        input.addContent(qdbz.setText("0"));
                }
                for (int i=1;i<=a;i++) {
                    Element group = new Element("group");
                    group.setAttribute("xh", ""+i);
                    fyxm.addContent(group);
                    Element fphxz = new Element("fphxz");
                    group.addContent(fphxz.setText("0"));
                    Element spmc = new Element("spmc");
                    group.addContent(spmc.setText("服务费"));
                    Element ggxh = new Element("ggxh");
                    group.addContent(ggxh.setText(""));
                    Element dw = new Element("dw");
                    group.addContent(dw.setText(""));
                    Element spsl = new Element("spsl");
                    group.addContent(spsl.setText("1"));
                    Element dj = new Element("dj");
                    group.addContent(dj.setText("32.6"));
                    Element je = new Element("je");
                    group.addContent(je.setText("32.6"));
                    Element sl = new Element("sl");
                    group.addContent(sl.setText("0.06"));
                    Element se = new Element("se");
                    group.addContent(se.setText("1.96"));
                    Element spbm = new Element("spbm");
                    group.addContent(spbm.setText("3040205000000000000"));
                    Element zxbm = new Element("zxbm");
                    group.addContent(zxbm.setText(""));
                    Element yhzcbs = new Element("yhzcbs");
                    group.addContent(yhzcbs.setText("0"));
                    Element lslbs = new Element("lslbs");
                    group.addContent(lslbs.setText(""));
                    Element zzstsgl = new Element("zzstsgl");
                    group.addContent(zzstsgl.setText(""));
                }
            }
        }
        if (fplx == "025"){
            input.addContent(fplxdm.setText(fplx));
            input.removeChild("gwdwdzdh");
            input.removeChild("ghdwyhzh");
            if (a > 0){
                fyxm.setAttribute("count",""+a);
                input.addContent(fyxm);
                for (int i=1;i<=a;i++) {
                    Element group = new Element("group");
                    group.setAttribute("xh", ""+i);
                    fyxm.addContent(group);
                    Element fphxz = new Element("fphxz");
                    group.addContent(fphxz.setText("0"));
                    Element spmc = new Element("spmc");
                    group.addContent(spmc.setText("服务费"));
                    Element ggxh = new Element("ggxh");
                    group.addContent(ggxh.setText(""));
                    Element dw = new Element("dw");
                    group.addContent(dw.setText(""));
                    Element spsl = new Element("spsl");
                    group.addContent(spsl.setText("1"));
                    Element hsdj = new Element("hsdj");
                    group.addContent(hsdj.setText("34.56"));
                    Element hsje = new Element("hsje");
                    group.addContent(hsje.setText("34.56"));
                    Element sl = new Element("sl");
                    group.addContent(sl.setText("0.06"));
                    Element se = new Element("se");
                    group.addContent(se.setText("1.96"));
                    Element spbm = new Element("spbm");
                    group.addContent(spbm.setText("3040205000000000000"));
                    Element zxbm = new Element("zxbm");
                    group.addContent(zxbm.setText(""));
                    Element yhzcbs = new Element("yhzcbs");
                    group.addContent(yhzcbs.setText("0"));
                    Element lslbs = new Element("lslbs");
                    group.addContent(lslbs.setText(""));
                    Element zzstsgl = new Element("zzstsgl");
                    group.addContent(zzstsgl.setText(""));
                }
            }
        }


        Element extParam = new Element("extParam");
        input.addContent(extParam.setText(""));
        Element readonly = new Element("readonly");
        input.addContent(readonly.setText(""));
        Element bz = new Element("bz");
        input.addContent(bz.setText(""));
        //收款人
        Element skr = new Element("skr");
        input.addContent(skr.setText(""));
        //复核人
        Element fhr = new Element("fhr");
        input.addContent(fhr.setText(""));
        //开票人
        Element kpr = new Element("kpr");
        input.addContent(kpr.setText("管理员"));
        if (fplx == "004"){
            Element tzdbh = new Element("tzdbh");
            input.addContent(tzdbh.setText(""));
        }
        //原发票代码
        Element yfpdm = new Element("yfpdm");
        input.addContent(yfpdm.setText(""));
        //原发票号码
        Element yfphm = new Element("yfphm");
        input.addContent(yfphm.setText(""));
        Element sprsjh = new Element("sprsjh");
        input.addContent(sprsjh.setText("dongfu@shuzutech.com"));

        business.addContent(body);
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(document,byteRep);
        String strXml = byteRep.toString();
        return strXml;
    }

}
