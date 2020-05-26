package Case.Invoice;

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
        map.put("fplxdm", "007");
//        map.put("shnsrsbh","");
//        map.put("jsbh","110101201707010064~~499000152528");
        map.put("ggxh","DES-2.7535,直径(mm)：2.75,长度(mm)：35");
        map.put("fpqqlsh","uP92120200520182419");

        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    /**
     * map.put("spmc","详见销货清单");
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"普票冲红"}, description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","");
        map.put("jsbh","91320594MA1MECA285~~537100950610");
        map.put("fplxdm", "007");
        map.put("sprsjh", "");
        map.put("kplx", "1");
        map.put("spmc","技术服务费");
        map.put("spsl","-1");
        map.put("dj","100");
        map.put("je","-100");
        map.put("sl","0.06");
        map.put("se","-6");
        map.put("yfpdm", "032001900104");
        map.put("yfphm", "71891448");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常，开具一张6行商品的普票")
    public void multiLineGroupPuPiao_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("jsbh","110101201707010064~~499000152528");
        String file = Java2XML.BuildXMLDoc(map,6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0003");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常,开具一张8行商品的普票")
    public void multiLineGroupPuPiao_0004() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("jsbh","110101201707010064~~499000152528");
        String file = Java2XML.BuildXMLDoc(map,8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0004");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行普票开具"}, description = "所有参数均正常，开具一张10行商品的普票")
    public void multiLineGroupPuPiao_0005() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh","110101201707010064~~499000152528");
        map.put("fplxdm","007");
        String file = Java2XML.BuildXMLDoc(map,10);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0005");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);

    }
}
