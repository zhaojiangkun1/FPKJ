package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ZhuanPiao {
    HashMap<String,String> map = new HashMap<>();
    @Test(groups = {"开具专票"},description = "所有参数均正常，开具一张专票")
    public void zhuanPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("sprsjh","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    /**
     * 专票冲红，必须带上通知单编号，需要提前上传红字信息表，返回一个通知单编号之后，才能冲红专票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"专票冲红"},description = "所有参数均正常，冲红一张增值税专票")
    public void zhuanPiaoHongChong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("sprsjh","");
        map.put("spsl","");
        map.put("dj","");
        map.put("je","");
        map.put("sl","");
        map.put("se","");
        map.put("tzdbh","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"多行专票开具"},description = "6行商品的专票开具")
    public void multiGroupZhuanPiao_0003() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("004",6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0003");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行专票开具"},description = "8行商品的专票开具")
    public void multiGroupZhuanPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("004",8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0004");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行专票开具"},description = "9行商品的专票开具")
    public void multiGroupZhuanPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("004",9);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0005");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

}
