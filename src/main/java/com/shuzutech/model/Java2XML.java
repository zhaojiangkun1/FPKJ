package com.shuzutech.model;

import com.shuzutech.config.UpdateFpqqlsh;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Java2XML {


    public static String BuildXMLDoc(HashMap<String, String> map, int... groups) throws IOException {
        Element business = new Element("business");
        Document doc = new Document(business);
        Element body = new Element("body");
        business.setAttribute("id", "FPKJ");
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

    public static String BuildXmlDoc(HashMap<String, String> map, ArrayList<GroupModel> groupModels) throws IOException {
        Element business = new Element("business");
        Document doc = new Document(business);
        Element body = new Element("body");
        business.setAttribute("id", "FPKJ");
        Element input = getInput(map);
        body.addContent(input);
        Element fyxm = discountFyxm(groupModels);
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
            group.setAttribute("xh", String.valueOf(1));
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

    public static Element getGroup(HashMap<String, String> map) {
        Element group = new Element("group");
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
        group.addContent(dj.setText("282.075472"));

        Element hsdj = new Element("hsdj");
        group.addContent(hsdj.setText("299"));

        Element je = new Element("je");
        group.addContent(je.setText("282.08"));

        Element hsje = new Element("hsje");
        group.addContent(hsje.setText("299"));

        Element sl = new Element("sl");
        group.addContent(sl.setText("0.06"));

        Element se = new Element("se");
        group.addContent(se.setText("16.92"));

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
        if (map.containsKey("ggxh")) ggxh.setText(map.get("ggxh"));
        if (map.containsKey("dw")) dw.setText(map.get("dw"));
        if (map.containsKey("spsl")) spsl.setText(map.get("spsl"));
        if (map.containsKey("dj")) dj.setText(map.get("dj"));
        if (map.containsKey("je")) je.setText(map.get("je"));
        if (map.containsKey("sl")) sl.setText(map.get("sl"));
        if (map.containsKey("se")) se.setText(map.get("se"));
        if (map.containsKey("spbm")) spbm.setText(map.get("spbm"));
        if (map.containsKey("zxbm")) zxbm.setText(map.get("zxbm"));
        if (map.containsKey("yhzcbs")) yhzcbs.setText(map.get("yhzcbs"));
        if (map.containsKey("lslbs")) lslbs.setText(map.get("lslbs"));
        if (map.containsKey("zzstsgl")) zzstsgl.setText(map.get("zzstsgl"));
        if (map.containsKey("hsbz")) {
            Element hsbz = new Element("hsbz");
            group.addContent(hsbz.setText(map.get("hsbz")));
        }
        if (map.containsKey("spsm")) {
            Element hsbz = new Element("spsm");
            group.addContent(hsbz.setText(map.get("spsm")));
        }
        if (map.containsKey("fplxdm")) {
            String values = (String) map.get("fplxdm");
            if (values == "025") {
                group.removeChild("je");
                group.removeChild("dj");
            }
            if (values == "026") {
                group.removeChild("hsje");
                group.removeChild("hsdj");
            }
            if (values == "007") {
                group.removeChild("hsje");
                group.removeChild("hsdj");
            }
            if (values == "004") {
                group.removeChild("hsje");
                group.removeChild("hsdj");
            }
        }

        return group;
    }

    public static Element getInput(HashMap<String, String> map) {
        Element input = new Element("input");
        Element fppqqlsh = new Element("fpqqlsh");
        input.addContent(fppqqlsh.setText(UpdateFpqqlsh.numbersLetters()));
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
        input.addContent(ghdwsbh.setText("91310114MA1GU3NU72"));
        Element ghdwmc = new Element("ghdwmc");
        input.addContent(ghdwmc.setText("上海融族网络科技有限公司"));
        Element ghdwdzdh = new Element("ghdwdzdh");
        input.addContent(ghdwdzdh.setText("上海市浦东新区康威路1500号3幢1层103室02158958286"));
        Element ghdwyhzh = new Element("ghdwyhzh");
        input.addContent(ghdwyhzh.setText("中国建设银行股份有限公司上海张江支行31050161393600001918"));
        Element qdbz = new Element("qdbz");
        input.addContent(qdbz.setText("0"));
        Element title_type = new Element("title_type");
        input.addContent(title_type.setText(""));
        Element extParam = new Element("extParam");
        input.addContent(extParam.setText(""));

        Element front_url = new Element("front_url");
        input.addContent(front_url.setText(""));

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

        Element tzdbh = new Element("tzdbh");
        input.addContent(tzdbh.setText(""));

        //原发票代码
        Element yfpdm = new Element("yfpdm");
        input.addContent(yfpdm.setText(""));
        //原发票号码
        Element yfphm = new Element("yfphm");
        input.addContent(yfphm.setText(""));

        Element sprsjh = new Element("sprsjh");
        input.addContent(sprsjh.setText("zhaokun@shuzutech.com"));
        if (map.containsKey("tspz")) {
            Element tspz = new Element("tspz");
            input.addContent(tspz.setText(map.get("tspz")));
        }
        if (map.containsKey("zsfs")) {
            Element zsfs = new Element("zsfs");
            input.addContent(zsfs.setText(map.get("zsfs")));
        }
        if (map.containsKey("kpzdbs")) {
            input.removeChild("jsbh");
            Element kpzdbs = new Element("kpzdbs");
            input.addContent(kpzdbs.setText(map.get("kpzdbs")));
        }
        if (map.containsKey("jqbh")) {
            input.removeChild("jsbh");
            Element jqbh = new Element("jqbh");
            input.addContent(jqbh.setText(map.get("jqbh")));
        }
        if (map.containsKey("fpqqlsh")) fppqqlsh.setText(map.get("fpqqlsh"));
        if (map.containsKey("shnsrsbh")) shnsrsbh.setText(map.get("shnsrsbh"));
        if (map.containsKey("jsbh")) jsbh.setText(map.get("jsbh"));
        if (map.containsKey("order_no")) {
            Element order_no = new Element("order_no");
            input.addContent(order_no.setText(map.get("order_no")));
        }
        if (map.containsKey("qdbz")) qdbz.setText(map.get("qdbz"));
        if (map.containsKey("kplx")) kplx.setText(map.get("kplx"));
        if (map.containsKey("yhlx")) yhlx.setText(map.get("yhlx"));
        if (map.containsKey("ghdwsbh")) ghdwsbh.setText(map.get("ghdwsbh"));
        if (map.containsKey("ghdwmc")) ghdwmc.setText(map.get("ghdwmc"));
        if (map.containsKey("ghdwdzdh")) ghdwdzdh.setText(map.get("ghdwdzdh"));
        if (map.containsKey("ghdwyhzh")) ghdwyhzh.setText(map.get("ghdwyhzh"));
        if (map.containsKey("title_type")) title_type.setText(map.get("title_type"));
        if (map.containsKey("bz")) bz.setText(map.get("bz"));
        if (map.containsKey("front_url")) front_url.setText(map.get("front_url"));
        if (map.containsKey("readonly")) readonly.setText(map.get("readonly"));
        if (map.containsKey("skr")) skr.setText(map.get("skr"));
        if (map.containsKey("fhr")) fhr.setText(map.get("fhr"));
        if (map.containsKey("tzdbh")) tzdbh.setText(map.get("tzdbh"));
        if (map.containsKey("yfpdm")) yfpdm.setText(map.get("yfpdm"));
        if (map.containsKey("yfphm")) yfphm.setText(map.get("yfphm"));
        if (map.containsKey("terminalKey")) {
            Element terminalKey = new Element("terminalKey");
            input.addContent(terminalKey.setText(map.get("terminalKey")));
        }
        if (map.containsKey("sprsjh")) sprsjh.setText(map.get("sprsjh"));
        if (map.containsKey("fplxdm")) {
            String values = (String) map.get("fplxdm");
            fplxdm.setText(values);
            if (values == "025") {
                input.removeChild("qdbz");
                input.removeChild("tzdbh");
                input.removeChild("ghdwdzdh");
                input.removeChild("ghdwyhzh");
                input.removeChild("shnsrsbh");
                sprsjh.setText("");
            }
            if (values == "026") {
                input.removeChild("qdbz");
                input.removeChild("tzdbh");
            }
            if (values == "007") {
                input.removeChild("tzdbh");
                input.removeChild("shnsrsbh");
                sprsjh.setText("");
            }
            if (values == "004") {
                input.removeChild("shnsrsbh");
                sprsjh.setText("");
            }
        }
        return input;

    }

    public static Element discountFyxm(ArrayList<GroupModel> groupModels) {
        Element fyxm = new Element("fyxm");
        fyxm.setAttribute("count", "" + groupModels.size());
        for (int i = 0; i < groupModels.size(); i++) {
            GroupModel groupModel = groupModels.get(i);
            Element group = discountGroup(groupModel);
            group.setAttribute("xh", "" + (i + 1));
            fyxm.addContent(group);
        }

        return fyxm;
    }

    public static Element discountGroup(GroupModel groupModel) {
        Element group = new Element("group");
        Element fphxz = new Element("fphxz");
        group.addContent(fphxz.setText("0"));
        if (groupModel.getFphxz() != null) {
            fphxz.setText(groupModel.getFphxz());
        }
        Element spmc = new Element("spmc");
        group.addContent(spmc.setText("服务费"));
        if (groupModel.getSpmc() != null) spmc.setText(groupModel.getSpmc());

        Element ggxh = new Element("ggxh");
        group.addContent(ggxh.setText(""));

        Element dw = new Element("dw");
        group.addContent(dw.setText(""));

        Element spsl = new Element("spsl");
        group.addContent(spsl.setText(groupModel.getSpsl()));
        if (groupModel.getSpsl() != null) spsl.setText(groupModel.getSpsl());

        Element dj = new Element("dj");
        group.addContent(dj.setText(groupModel.getDj()));
        if (groupModel.getDj() != null) dj.setText(groupModel.getDj());

        Element je = new Element("je");
        group.addContent(je.setText(groupModel.getJe()));
        if (groupModel.getJe() != null) je.setText(groupModel.getJe());

        Element sl = new Element("sl");
        group.addContent(sl.setText(groupModel.getSl()));
        if (groupModel.getSl() != null) sl.setText(groupModel.getSl());

        Element se = new Element("se");
        group.addContent(se.setText(groupModel.getSe()));
        if (groupModel.getSe() != null) se.setText(groupModel.getSe());

        if (groupModel.getFphxz() == "1") {
            ggxh.setText("");
            dw.setText("");
            spsl.setText("");
            dj.setText("");
        }

        Element spbm = new Element("spbm");
        group.addContent(spbm.setText("3040201040000000000"));
        if (groupModel.getSpbm() != null) spbm.setText(groupModel.getSpbm());

        Element zxbm = new Element("zxbm");
        group.addContent(zxbm.setText(""));
        Element yhzcbs = new Element("yhzcbs");
        group.addContent(yhzcbs.setText("0"));
        Element lslbs = new Element("lslbs");
        group.addContent(lslbs.setText(""));
        Element zzstsgl = new Element("zzstsgl");
        group.addContent(zzstsgl.setText(""));
        return group;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel = new GroupModel("1231", "2", "", "", "123123");
        GroupModel groupModel1 = new GroupModel("12312", "2", "0.06", "0.12", "55555");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        HashMap<String, String> map = new HashMap<>();
        map.put("fplxdm", "026");
        System.out.println(BuildXmlDoc(map, groupModels));
    }

}
