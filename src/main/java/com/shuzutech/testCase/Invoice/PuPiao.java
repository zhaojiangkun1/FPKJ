package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.*;
import com.shuzutech.config.TestResult;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.GroupModel;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.shuzutech.config.GetInvoiceCase.getInvoiceCase;
import static com.shuzutech.model.GongYouFangFa.gongYouFangFa;

public class PuPiao {

    ArrayList<GroupModel> groupModels = new ArrayList<>();

    /**
     * 合力："HOLY",10001,"商品名称格式有误_FyxmN1"
     * 旋极：{"returnmsg":"开票明细中包含GBK无法编码字符,请检查！","returncode":1000008}
     *
     * 智能空气品质控制器 KF-700RM(RPM+Malino)
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException
     */
    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张增值税普通发票")
    public void puPiao_0001() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("ghdwmc", "上海盛付通电子支付服务有限公司");
        map.put("ghdwsbh", "9131011567624841X0");
        map.put("ghdwdzdh", "");
        map.put("ghdwyhzh", "");
        map.put("dj", "");
        map.put("spsl", "");
        map.put("je", "1309.39");
        map.put("dw", "");
        map.put("ggxh", "");
        map.put("sl", "0.06");
        map.put("se", "78.56");
//        map.put("tspz","01");
        map.put("front_url", "http://www.shuzutech.com/");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map,2),TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开具普票"},description = "开具一张带折扣行的普票")
    public void discountPuPiao() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        GroupModel groupModel = new GroupModel("2", "1", "20", "20", "0.03", "0.6");
        GroupModel groupModel1 = new GroupModel("1", "", "", "-10", "0.03", "-0.3");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map,groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张6行商品的普票")
    public void multiLineGroupPuPiao_0003() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 6);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开票普票"}, description = "所有参数均正常,开具一张8行商品的普票")
    public void multiLineGroupPuPiao_0004() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 8);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张10行商品的普票")
    public void multiLineGroupPuPiao_0005() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("qdbz","1");
        String file = Java2XML.BuildXMLDoc(map, 10);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);

    }

}
