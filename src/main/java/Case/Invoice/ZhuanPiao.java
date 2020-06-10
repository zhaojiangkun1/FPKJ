package Case.Invoice;

import Bean.EnvNum;
import Bean.InvoiceCase;
import Bean.TestEnv;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ZhuanPiao {
    HashMap<String, String> map = new HashMap<>();

    @Test(groups = {"开具专票"}, description = "所有参数均正常，开具一张专票")
    public void zhuanPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "004");
        map.put("shnsrsbh","");
        map.put("jsbh", "91320191MA1ML4CL25~~661921253676");
        map.put("ghdwmc","南京阿有料网络科技有限公司");
        map.put("ghdwsbh","91320100339341672J");
        map.put("ghdwdzdh","南京市高新技术产业开发区星火路11号动漫大厦B座2楼C-1室025-68959525");
        map.put("ghdwyhzh","南京工商银行 3201000323459889");
        map.put("spsl","1");
        map.put("dj","100");
        map.put("je","100");
        map.put("sl","0.06");
        map.put("se","6.00");
        // 规格型号过长
//        map.put("ggxh","285.6g(1.02g*80片*1瓶+1.02g*100片*2瓶)");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test
    public void hzxxbsc() throws IOException, NoSuchAlgorithmException {
        HashMap<String,String> map1 = new HashMap<>();
        String body = PostRequest.zhenPiaoYunRequest(ZhuanPiaoChongHong.getHzxxbsc(map1), TestEnv.testEnv);
        System.out.println(body);
    }


    /**
     * 专票冲红，必须带上通知单编号，需要提前上传红字信息表，返回一个通知单编号之后，才能冲红专票
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"专票冲红"}, description = "所有参数均正常，冲红一张增值税专票")
    public void zhuanPiaoHongChong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "004");
        map.put("sprsjh", "");
        map.put("spsl", "");
        map.put("dj", "");
        map.put("je", "");
        map.put("sl", "");
        map.put("se", "");
        map.put("tzdbh", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行专票开具"}, description = "6行商品的专票开具")
    public void multiGroupZhuanPiao_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("jsbh","110101201707010064~~499000152528");
        String file = Java2XML.BuildXMLDoc(map,6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0003");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行专票开具"}, description = "8行商品的专票开具")
    public void multiGroupZhuanPiao_0004() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("jsbh","110101201707010064~~499000152528");
        String file = Java2XML.BuildXMLDoc(map,8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0004");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行专票开具"}, description = "9行商品的专票开具")
    public void multiGroupZhuanPiao_0005() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("jsbh","110101201707010064~~499000152528");
        String file = Java2XML.BuildXMLDoc(map,10);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zhuanPiao_0005");
        GongYouFangFa.gongYouFangFa(file, invoiceCase);
    }

}
