package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class JuanPiao {

    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap<>();

    @Test(groups = {"开具卷票"}, description = "所有参数均正常，开具一张卷票")
    public void juanPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "025");
        map.put("sprsjh", "");
        map.put("readonly", "0");
        invoiceCase = GetInvoiceCase.getInvoiceCase("juanPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"冲红卷票"}, description = "所有参数均正常，开具一张负数卷票")
    public void juanPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "025");
        map.put("kplx", "1");
        map.put("sprsjh", "");
        map.put("spsl", "-1");
        map.put("hsje", "-34.56");
        map.put("se", "-1.96");
        map.put("yfpdm", "150001201509");
        map.put("yfphm", "20191054");
        invoiceCase = GetInvoiceCase.getInvoiceCase("juanPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张6行商品的卷票")
    public void multiGroupJuanPiao_0003() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025", 6);
        invoiceCase = GetInvoiceCase.getInvoiceCase("juanPiao_0003");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张8行商品的卷票")
    public void multiGroupJuanPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025", 8);
        invoiceCase = GetInvoiceCase.getInvoiceCase("juanPiao_0004");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张超过8行商品的卷票")
    public void multiGroupJuanPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025", 9);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("juanPiao_0005");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }


}
