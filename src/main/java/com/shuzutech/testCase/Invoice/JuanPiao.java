package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.*;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static com.shuzutech.config.GetInvoiceCase.*;
import static com.shuzutech.model.GongYouFangFa.gongYouFangFa;

public class JuanPiao {
    /**
     * 合力的税控盘，暂仅支持：004，007，026
     * 旋极的接口：fppy  税控服务器开票是必传字段，云票盒子开票此字段为空
     * 旋极卷票，fpcx返回的dj和je为0，应该展示hsdj和hsje.
     *
     * */

    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = InvoiceParamters.hashMap("025");

    @Test(groups = {"开具卷票"}, description = "所有参数均正常，开具一张卷票")
    public void juanPiao_0001() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        map.put("readonly", "0");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"冲红卷票"}, description = "所有参数均正常，开具一张负数卷票")
    public void juanPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("kplx", "1");
        map.put("sprsjh", "");
        map.put("spsl", "-1");
        map.put("hsje", "-299");
        map.put("se", "-18.04");
        map.put("yfpdm", "150001201509");
        map.put("yfphm", "20191099");
        invoiceCase = getInvoiceCase("juanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张6行商品的卷票")
    public void multiGroupJuanPiao_0003() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map,6);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张8行商品的卷票")
    public void multiGroupJuanPiao_0004() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map,8);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张超过8行商品的卷票")
    public void multiGroupJuanPiao_0005() throws IOException, NoSuchAlgorithmException, InterruptedException {
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map,10);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }


}
