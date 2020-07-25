package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.*;
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


public class ZhuanPiao {

    ArrayList<GroupModel> groupModels = new ArrayList<>();

    @Test(groups = {"开具专票"}, description = "所有参数均正常，开具一张专票")
    public void specialInvoice() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具专票"}, description = "6行商品的专票开具")
    public void specialInvoiceSixCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 6);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具专票"}, description = "8行商品的专票开具")
    public void specialInvoiceEightCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 8);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具专票"}, description = "9行商品的专票开具")
    public void specialInvoiceNineCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("qdbz", "1");
        String file = Java2XML.BuildXMLDoc(map, 9);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具专票"},description = "开具一张带折扣行的专票")
    public void discountSpecialInvoice() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        GroupModel groupModel = new GroupModel("2", "1", "200", "200", "0.03", "6");
        GroupModel groupModel1 = new GroupModel("1", "", "", "-10", "0.03", "-0.3");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map,groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }


}
