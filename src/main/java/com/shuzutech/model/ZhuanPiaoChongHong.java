package com.shuzutech.model;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class ZhuanPiaoChongHong {

    public static String getHzxxbsc(HashMap<String, String> map, int... groups) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id", "HZXXBSC");
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

    private static Element getFyxm(HashMap<String, String> map, int... groups) {
        Element fyxm = new Element("fyxm");
        if (groups.length == 0) {
            fyxm.setAttribute("count", "" + 1);
            Element group = getGroup(map);
            group.setAttribute("xh", "1");
            fyxm.addContent(group);
        } else {
            fyxm.setAttribute("count", "" + groups[0]);
            for (int i = 0; i < groups[0]; i++) {
                Element group = getGroup(map);
                group.setAttribute("xh", String.valueOf(i + 1));
                fyxm.addContent(group);
            }
        }
        return fyxm;
    }

    private static Element getGroup(HashMap<String, String> map) {
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
        if (map.containsKey("spmc")) spmc.setText(map.get("spmc"));
        if (map.containsKey("dw")) dw.setText(map.get("dw"));
        if (map.containsKey("ggxh")) ggxh.setText(map.get("ggxh"));
        if (map.containsKey("spsl")) spsl.setText(map.get("spsl"));
        if (map.containsKey("dj")) dj.setText(map.get("dj"));
        if (map.containsKey("je")) je.setText(map.get("je"));
        if (map.containsKey("sl")) sl.setText(map.get("sl"));
        if (map.containsKey("se")) se.setText(map.get("se"));
        if (map.containsKey("hsbz")) hsbz.setText(map.get("hsbz"));
        if (map.containsKey("spbm")) spbm.setText(map.get("spbm"));
        if (map.containsKey("zxbm")) zxbm.setText(map.get("zxbm"));
        if (map.containsKey("yhzcbs")) yhzcbs.setText(map.get("yhzcbs"));
        if (map.containsKey("lslbs")) lslbs.setText(map.get("lslbs"));
        if (map.containsKey("zzstsgl")) zzstsgl.setText(map.get("zzstsgl"));
        return group;
    }

    private static Element getInput(HashMap<String, String> map) {
        Element input = new Element("input");
        Element jsbh = new Element("jsbh");
        input.addContent(jsbh.setText("91320594346148467C~~537100951479"));
        if (map.containsKey("jsbh")) jsbh.setText(map.get("jsbh"));
        Element xxblx = new Element("xxblx");
        input.addContent(xxblx.setText("0"));
        if (map.containsKey("xxblx")) xxblx.setText(map.get("xxblx"));
        Element yfpdm = new Element("yfpdm");
        input.addContent(yfpdm.setText("3200193130"));
        if (map.containsKey("yfpdm")) yfpdm.setText(map.get("yfpdm"));
        Element yfphm = new Element("yfphm");
        input.addContent(yfphm.setText("40354746"));
        if (map.containsKey("yfphm")) yfphm.setText(map.get("yfphm"));
        Element szlb = new Element("szlb");
        input.addContent(szlb.setText("1"));
        if (map.containsKey("szlb")) szlb.setText(map.get("szlb"));
        Element dslbs = new Element("dslbs");
        input.addContent(dslbs.setText("0"));
        if (map.containsKey("dslbs")) dslbs.setText(map.get("dslbs"));
        Element tkrq = new Element("tkrq");
        input.addContent(tkrq.setText("2020-06-01"));
        if (map.containsKey("tkrq")) tkrq.setText(map.get("tkrq"));
        Element ghdwmc = new Element("ghdwmc");
        input.addContent(ghdwmc.setText("上海融族网络科技有限公司"));
        if (map.containsKey("ghdwmc")) ghdwmc.setText(map.get("ghdwmc"));
        Element ghdwdm = new Element("ghdwdm");
        input.addContent(ghdwdm.setText("91310114MA1GU3NU72"));
        if (map.containsKey("ghdwdm")) ghdwdm.setText(map.get("ghdwdm"));
        Element xhdwmc = new Element("xhdwmc");
        input.addContent(xhdwmc.setText("苏州喵呜信息技术有限公司"));
        if (map.containsKey("xhdwmc")) xhdwmc.setText(map.get("xhdwmc"));
        Element xhdwdm = new Element("xhdwdm");
        input.addContent(xhdwdm.setText("91320594346148467C"));
        if (map.containsKey("xhdwdm")) xhdwdm.setText(map.get("xhdwdm"));
        Element hjje = new Element("hjje");
        input.addContent(hjje.setText("-282.08"));
        if (map.containsKey("hjje")) hjje.setText(map.get("hjje"));
        Element zhsl = new Element("zhsl");
        input.addContent(zhsl.setText("0.06"));
        if (map.containsKey("zhsl")) zhsl.setText(map.get("zhsl"));
        Element hjse = new Element("hjse");
        input.addContent(hjse.setText("-16.92"));
        if (map.containsKey("hjse")) hjse.setText(map.get("hjse"));
        Element sqsm = new Element("sqsm");
        input.addContent(sqsm.setText("0000000100"));
        if (map.containsKey("sqsm")) sqsm.setText(map.get("sqsm"));
        Element sqly = new Element("sqly");
        input.addContent(sqly.setText("8"));
        if (map.containsKey("sqly")) sqly.setText(map.get("sqly"));
        Element lxdh = new Element("lxdh");
        input.addContent(lxdh.setText(""));
        if (map.containsKey("lxdh")) lxdh.setText(map.get("lxdh"));
        Element hsslbs = new Element("hsslbs");
        input.addContent(hsslbs.setText("0"));
        if (map.containsKey("hsslbs")) hsslbs.setText(map.get("hsslbs"));
        Element bmbbbh = new Element("bmbbbh");
        input.addContent(bmbbbh.setText(""));
        if (map.containsKey("bmbbbh")) bmbbbh.setText(map.get("bmbbbh"));
        Element kprq = new Element("kprq");
        input.addContent(kprq.setText("20200520"));
        if (map.containsKey("kprq")) kprq.setText(map.get("kprq"));
        return input;
    }
}
