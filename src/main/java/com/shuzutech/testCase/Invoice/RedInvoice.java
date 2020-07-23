package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.TestResult;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import com.shuzutech.model.ZhuanPiaoChongHong;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static com.shuzutech.config.GetInvoiceCase.getInvoiceCase;
import static com.shuzutech.model.GongYouFangFa.gongYouFangFa;


public class RedInvoice {
    @Test(groups = {"电票冲红"}, description = "所有参数均正常，冲红一张电子发票")
    public void dianPiaoChongHong_0003() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String,String> map = InvoiceParamters.hashMap("026");
        map.put("kplx", "1");
        map.put("spsl", "-0.5");
        map.put("dj", "20");
        map.put("je", "-10");
        map.put("sl", "0.03");
        map.put("se", "-0.03");
        map.put("yfpdm", "050003521107");
        map.put("yfphm", "20181266");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        TestResult.testFpkjResult(result);
        Thread.sleep(50000);
        TestResult.runResult(map);
    }

    @Test(groups = {"电票冲红"},description = "冲红一张带清单电子发票")
    public void redListDianPiao() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String,String> map = InvoiceParamters.hashMap("026");
        map.put("kplx", "1");
        map.put("spsl", "-0.5");
        map.put("dj", "20");
        map.put("je", "-10");
        map.put("sl", "0.03");
        map.put("se", "-0.03");
        map.put("yfpdm", "050003521107");
        map.put("yfphm", "20181266");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        TestResult.testFpkjResult(result);
        Thread.sleep(50000);
        TestResult.runResult(map);
    }

    /**
     *
     * map.put("spmc","详见销货清单");
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"普票冲红"}, description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        HashMap<String,String> map = InvoiceParamters.hashMap("007");
        map.put("sprsjh", "");
        map.put("kplx", "1");
        map.put("spmc", "技术服务费");
        map.put("spsl", "-1");
        map.put("dj", "100");
        map.put("je", "-100");
        map.put("sl", "0.06");
        map.put("se", "-6");
        map.put("yfpdm", "032001900104");
        map.put("yfphm", "71891448");
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"普票冲红"}, description = "冲红一张带清单普票")
    public void redListPuPiao() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        HashMap<String,String> map = InvoiceParamters.hashMap("007");
        map.put("sprsjh", "");
        map.put("kplx", "1");
        map.put("spmc", "技术服务费");
        map.put("spsl", "-1");
        map.put("dj", "100");
        map.put("je", "-100");
        map.put("sl", "0.06");
        map.put("se", "-6");
        map.put("qdbz","1");
        map.put("yfpdm", "032001900104");
        map.put("yfphm", "71891448");
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test
    public void hzxxbsc() throws IOException, NoSuchAlgorithmException {
        HashMap<String, String> map1 = new HashMap<>();
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
        HashMap<String,String> map = InvoiceParamters.hashMap("004");
        map.put("kplx", "1");
        map.put("spmc", "技术服务费");
        map.put("sprsjh", "");
        map.put("spsl", "-1");
        map.put("dj", "282.075472");
        map.put("je", "-282.08");
        map.put("sl", "0.06");
        map.put("se", "-16.92");
        map.put("tzdbh", "3201122006019300");
        map.put("yfpdm", "3200192130");
        map.put("yfphm", "56436284");
        InvoiceCase invoiceCase = getInvoiceCase("zhuanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"专票冲红"}, description = "所有参数均正常，冲红一张增值税专票")
    public void redListZhuanPiao() throws IOException, NoSuchAlgorithmException {
        HashMap<String,String> map = InvoiceParamters.hashMap("004");
        map.put("kplx", "1");
        map.put("spmc", "技术服务费");
        map.put("sprsjh", "");
        map.put("spsl", "-1");
        map.put("dj", "282.075472");
        map.put("je", "-282.08");
        map.put("sl", "0.06");
        map.put("se", "-16.92");
        map.put("qdbz","1");
        map.put("tzdbh", "3201122006019300");
        map.put("yfpdm", "3200192130");
        map.put("yfphm", "56436284");
        InvoiceCase invoiceCase = getInvoiceCase("zhuanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
