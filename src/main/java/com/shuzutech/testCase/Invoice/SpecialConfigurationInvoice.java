package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class SpecialConfigurationInvoice {

    @Test(groups = {"特殊配置发票"},description = "不传商品，使用默认商品开票")
    public void useDefaultProduct() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String,String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("ghdwmc", "上海盛付通电子支付服务有限公司");
        map.put("ghdwsbh", "9131011567624841X0");
        map.put("ghdwdzdh", "");
        map.put("ghdwyhzh", "");
        map.put("spmc", "");
        map.put("dj","");
        map.put("spsl","");
        map.put("je","200");
        map.put("sl","");
        map.put("se","");
        map.put("spbm","");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    /**
     * 专票是不能开具0税率发票
     * @throws InterruptedException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test(groups = {"特殊配置发票"},description = "使用免税政策开票")
    public void useFree() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String,String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        map.put("sl","0");
        map.put("se","0");
        map.put("lslbs","1");
        map.put("yhzcbs","1");
        map.put("zzstsgl","免税");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    /**
     * 目前是仅合力接口支持特殊票种的开具，专票是没有校验码
     * 特殊票种：01、02、06、07、08
     * @throws InterruptedException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void useTspzInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String,String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh",fpqqlsh);
        map.put("tspz","06");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }
}
