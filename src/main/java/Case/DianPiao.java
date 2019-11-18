package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class DianPiao {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"开具电票"},description = "所有参数都正常，开具一张电票")
    public void dianPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("readonly","1");
        map.put("shnsrsbh","110101201601010075");
        map.put("jsbh","110101201601010075~~499000153838");
        map.put("sprsjh","zhaokun@shuzutech.com");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"自助开票"},description = "所有参数都正常，自助开票")
    public void ziZhuKaiPiao_0002() throws IOException, NoSuchAlgorithmException {
        map.put("yhlx","1");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"电票冲红"},description = "所有参数均正常，开具一张负数发票")
    public void dianPiaoChongHong_0003() throws IOException, NoSuchAlgorithmException {
        map.put("kplx","1");
        map.put("spsl","-1");
        map.put("dj","32.6");
        map.put("je","-32.6");
        map.put("sl","0.06");
        map.put("se","-1.96");
        map.put("readonly","0");
        map.put("yfpdm","150000456123");
        map.put("yfphm","36873823");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张6行商品的电票")
    public void multiGroupDianPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0004");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常，开具一张8行商品的电票")
    public void multiGroupDianPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0005");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张9行商品的电票")
    public void multiGroupDianPiao_0006() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",9);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0006");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

}
