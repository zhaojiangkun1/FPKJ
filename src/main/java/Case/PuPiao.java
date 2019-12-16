package Case;

import Bean.InvoiceCase;
import Bean.TestEnv;
import Config.GetInvoiceCase;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class PuPiao {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"开具普票"},description = "所有参数均正常，开具一张增值税普通发票")
    public void puPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("jsbh","110101201707010043~~A20016420000265");
        map.put("shnsrsbh","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"普票冲红"},description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("sprsjh","");
        map.put("kplx","1");
        map.put("spsl","-1");
        map.put("dj","7.55");
        map.put("je","-7.55");
        map.put("sl","0.06");
        map.put("se","-0.45");
        map.put("yfpdm","050000000102");
        map.put("yfphm","13315608");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常，开具一张6行商品的普票")
    public void multiLineGroupPuPiao_0003() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007",6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0003");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常,开具一张8行商品的普票")
    public void multiLineGroupPuPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007", 8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0004");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常，开具一张9行商品的普票")
    public void multiLineGroupPuPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007",9);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("puPiao_0005");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);

    }
}
