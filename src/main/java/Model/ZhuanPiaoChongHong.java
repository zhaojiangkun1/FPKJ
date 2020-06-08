package Model;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ZhuanPiaoChongHong {

    public static String getHzxxbsc(HashMap<String, String> map, int... groups) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id","HZXXBSC");
        Document doc = new Document(business);
        Element body = new Element("body");
        Element input = getInput(map);
        body.addContent(input);
        Element fyxm = getFyxm(map, groups);
        input.addContent(fyxm);
        business.addContent(body);
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(doc, byteRep);
        String strXml = byteRep.toString();
        return strXml;

    }

    public static Element getFyxm(HashMap<String, String> map, int... groups) {
        Element fyxm = new Element("fyxm");
        if (groups.length == 0) {
            fyxm.setAttribute("count", "" + 1);
            Element group = getGroup(map);
            group.setAttribute("xh","1");
            fyxm.addContent(group);
        } else {
            fyxm.setAttribute("count", "" + groups[0]);
            for (int i = 0; i < groups[0]; i++) {
                Element group = getGroup(map);
                group.setAttribute("xh",String.valueOf(i+1));
                fyxm.addContent(group);
            }
        }
        return fyxm;
    }

    public static Element getGroup(HashMap<String, String> map) {
        Element group = new Element("group");
        Element fphxz = new Element("fphxz");
        group.addContent(fphxz.setText("0"));
        Element spmc = new Element("spmc");
        group.addContent(spmc.setText("服务费"));
        Element spsm = new Element("spsm");
        group.addContent(spsm.setText(""));
        Element ggxh = new Element("ggxh");
        group.addContent(ggxh.setText(""));

        Element dw = new Element("dw");
        group.addContent(dw.setText(""));

        Element spsl = new Element("spsl");
        group.addContent(spsl.setText("1"));

        Element dj = new Element("dj");
        group.addContent(dj.setText("282.075472"));


        Element je = new Element("je");
        group.addContent(je.setText("282.08"));

        Element sl = new Element("sl");
        group.addContent(sl.setText("0.06"));

        Element se = new Element("se");
        group.addContent(se.setText("16.92"));

        Element hsbz = new Element("hsbz");
        group.addContent(hsbz.setText("N"));

        Element spbm = new Element("spbm");
        group.addContent(spbm.setText("3040201040000000000"));

        Element zxbm = new Element("zxbm");
        group.addContent(zxbm.setText(""));

        Element yhzcbs = new Element("yhzcbs");
        group.addContent(yhzcbs.setText("0"));

        Element lslbs = new Element("lslbs");
        group.addContent(lslbs.setText(""));

        Element zzstsgl = new Element("zzstsgl");
        group.addContent(zzstsgl.setText(""));

        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            String values = (String) entry.getValue();
            if (key == "spmc") {
                spmc.setText(values);
            }
            if (key == "ggxh") {
                ggxh.setText(values);
            }
            if (key == "dw") {
                dw.setText(values);
            }
            if (key == "spsl") {
                spsl.setText(values);
            }
            if (key == "dj"){
                dj.setText(values);
            }

            if (key == "je") {
                je.setText(values);
            }
            if (key == "sl") {
                sl.setText(values);
            }
            if (key == "se") {
                se.setText(values);
            }
            if (key == "spbm") {
                spbm.setText(values);
            }
            if (key == "zxbm") {
                zxbm.setText(values);
            }
            if (key == "yhzcbs") {
                yhzcbs.setText(values);
            }
            if (key == "lslbs") {
                lslbs.setText(values);
            }
            if (key == "zzstsgl") {
                zzstsgl.setText(values);
            }

        }
        return group;
    }

    public static Element getInput(HashMap<String,String> map){
        Element input = new Element("input");
        Element jsbh = new Element("jsbh");
        input.addContent(jsbh.setText("91320594346148467C~~537100951479"));
        Element xxblx = new Element("xxblx");
        input.addContent(xxblx.setText("0"));
        Element yfpdm = new Element("yfpdm");
        input.addContent(yfpdm.setText("3200193130"));
        Element yfphm = new Element("yfphm");
        input.addContent(yfphm.setText("40354746"));
        Element szlb = new Element("szlb");
        input.addContent(szlb.setText("1"));
        Element dslbs = new Element("dslbs");
        input.addContent(dslbs.setText("0"));
        Element tkrq = new Element("tkrq");
        input.addContent(tkrq.setText("2020-06-01"));
        Element ghdwmc = new Element("ghdwmc");
        input.addContent(ghdwmc.setText("上海融族网络科技有限公司"));
        Element ghdwdm = new Element("ghdwdm");
        input.addContent(ghdwdm.setText("91310114MA1GU3NU72"));
        Element xhdwmc = new Element("xhdwmc");
        input.addContent(xhdwmc.setText("苏州喵呜信息技术有限公司"));
        Element xhdwdm = new Element("xhdwdm");
        input.addContent(xhdwdm.setText("91320594346148467C"));
        Element hjje = new Element("hjje");
        input.addContent(hjje.setText("-299"));
        Element zhsl = new Element("zhsl");
        input.addContent(zhsl.setText("0.06"));
        Element hjse = new Element("hjse");
        input.addContent(hjse.setText("-16.92"));
        Element sqsm = new Element("sqsm");
        input.addContent(sqsm.setText("0000000100"));
        Element sqly = new Element("sqly");
        input.addContent(sqly.setText("8"));
        Element lxdh = new Element("lxdh");
        input.addContent(lxdh.setText(""));
        Element hsslbs = new Element("hsslbs");
        input.addContent(hsslbs.setText("0"));
        Element bmbbbh = new Element("bmbbbh");
        input.addContent(bmbbbh.setText(""));
        Element kprq = new Element("kprq");
        input.addContent(kprq.setText("20200520"));

        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            String values = (String) entry.getValue();
            if (input.getChildText(key)!=null){
                input.removeChild(key);
                input.addContent(new Element(key).setText(values));
            }
        }
        return input;
    }

}
