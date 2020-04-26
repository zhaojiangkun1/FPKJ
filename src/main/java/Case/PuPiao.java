package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class PuPiao {
    HashMap<String, String> map = new HashMap<>();

    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张增值税普通发票")
    public void puPiao_0001() throws IOException, NoSuchAlgorithmException {
//        map.put("fpqqlsh","KA28020200424114443");
        map.put("fplxdm", "007");
        map.put("spsl","1");
        map.put("shnsrsbh","110101201707010043");
        map.put("jsbh", "");
//        map.put("terminalKey","hl0002");
//        map.put("kpr","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"普票冲红"}, description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "007");
        map.put("sprsjh", "");
        map.put("kplx", "1");
        map.put("spsl", "-1");
        map.put("dj", "282.075472");
        map.put("je", "-282.08");
        map.put("sl", "0.06");
        map.put("se", "-16.92");
        map.put("yfpdm", "050000000102");
        map.put("yfphm", "20192204");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常，开具一张6行商品的普票")
    public void multiLineGroupPuPiao_0003() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007", 6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0003");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常,开具一张8行商品的普票")
    public void multiLineGroupPuPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007", 8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0004");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常，开具一张10行商品的普票")
    public void multiLineGroupPuPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007", 10);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0005");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);

    }
}
