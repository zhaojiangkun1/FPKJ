package Model;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Java2XML {

    @Test
    public static String BuildXMLDoc(HashMap<String,String> map) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id","FPKJ");
        Document doc = new Document(business);
        Element body = new Element("body");
        Element input = new Element("input");
        body.addContent(input);

        Element fppqqlsh = new Element("fpqqlsh");
        input.addContent(fppqqlsh.setText("11111111111111"));

        Element shnsrsbh = new Element("shnsrsbh");
        input.addContent(shnsrsbh.setText("110101201707010057"));

        Element jsbh = new Element("jsbh");
        input.addContent(jsbh.setText("110101201707010057~~499000152456"));

        Element fplxdm = new Element("fplxdm");
        input.addContent(fplxdm.setText("026"));

        Element kplx = new Element("kplx");
        input.addContent(kplx.setText("0"));

        Element yhlx = new Element("yhlx");
        input.addContent(yhlx.setText("0"));

        Element ghdwsbh = new Element("ghdwsbh");
        input.addContent(ghdwsbh.setText(""));

        Element ghdwmc = new Element("ghdwmc");
        input.addContent(ghdwmc.setText("个人"));

        Element ghdwdzdh = new Element("ghdwdzdh");
        input.addContent(ghdwdzdh.setText(""));

        Element ghdwyhzh = new Element("ghdwyhzh");
        input.addContent(ghdwyhzh.setText(""));

        Element fyxm = new Element("fyxm");
        fyxm.setAttribute("count","1");
        input.addContent(fyxm);
        Element group = new Element("group");
        group.setAttribute("xh","1");
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

        Element extParam = new Element("extParam");
        input.addContent(extParam.setText(""));

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
        //原发票代码
        Element yfpdm = new Element("yfpdm");
        input.addContent(yfpdm.setText(""));
        //原发票号码
        Element yfphm = new Element("yfphm");
        input.addContent(yfphm.setText(""));

        Element sprsjh = new Element("sprsjh");
        input.addContent(sprsjh.setText("zhaokun@shuzutech.com"));

        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            String values = (String) entry.getValue();
            if (key == "fpqqlsh"){
                fppqqlsh.setText(values);
            }
            if (key == "shnsrsbh"){
                shnsrsbh.setText(values);
            }
            if (key == "jsbh"){
                jsbh.setText(values);
            }
            if (key == "fplxdm"){
                fplxdm.setText(values);
            }
            if (key == "kplx"){
                kplx.setText(values);
            }
            if (key == "yhlx"){
                yhlx.setText(values);
            }
            if(key == "ghdwsbh"){
                ghdwsbh.setText(values);
            }
            if (key == "ghdwmc"){
                ghdwmc.setText(values);
            }
            if (key == "ghdwdzdh"){
                ghdwdzdh.setText(values);
            }
            if (key == "ghdwyhzh"){
                ghdwyhzh.setText(values);
            }
            if (key == "fphxz"){
                fphxz.setText(values);
            }
            if (key == "spmc"){
                spmc.setText(values);
            }
            if (key == "ggxh"){
                ggxh.setText(values);
            }
            if (key == "dw"){
                dw.setText(values);
            }
            if (key == "spsl"){
                spsl.setText(values);
            }
            if (key == "dj"){
                dj.setText(values);
            }
            if (key == "je"){
                je.setText(values);
            }
            if (key == "sl"){
                sl.setText(values);
            }
            if (key == "se"){
                se.setText(values);
            }
            if (key == "spbm"){
                spbm.setText(values);
            }
            if (key == "zxbm"){
                zxbm.setText(values);
            }
            if (key == "yhzcbs"){
                yhzcbs.setText(values);
            }
            if (key == "lslbs"){
                lslbs.setText(values);
            }
            if (key == "zzstsgl"){
                zzstsgl.setText(values);
            }
            if (key == "bz"){
                bz.setText(values);
            }
            if (key == "skr"){
                skr.setText(values);
            }
            if (key == "fhr"){
                fhr.setText(values);
            }
            if (key == "kpr"){
                kpr.setText(values);
            }
            if (key == "yfpdm"){
                yfpdm.setText(values);
            }
            if (key == "yfphm"){
                yfphm.setText(values);
            }
            if (key == "sprsjh"){
                sprsjh.setText(values);
            }

        }
        business.addContent(body);
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(doc,byteRep);
        String strXml = byteRep.toString();
        return strXml;
    }

}
