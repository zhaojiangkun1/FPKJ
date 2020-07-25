package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.SaveFpInfo;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GetSaveFpInfo;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.GroupModel;
import com.shuzutech.model.GroupModelList;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class DiffTaxInvoice {
    ArrayList<GroupModel> groupModels = GroupModelList.groupModelArrayList();
    ArrayList<GroupModel> groupModelsRed = GroupModelList.groupModelArrayListRed();

    @Test(groups = {"开具电票"}, description = "不同商品，不同税率的电票开具",priority = 9)
    public void diffTaxElectronicInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
//        new SaveInvoiceMessage().saveSuccessInvoiceMessage(map, new Date());
    }

    @Test(groups = {"电票冲红"}, description = "不同商品、税率的电票冲红",priority = 10)
    public void diffTaxElectronicRed() throws IOException, NoSuchAlgorithmException, InterruptedException {
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        map.put("kplx", "1");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModelsRed), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "不同商品，不同税率的普票开具",priority = 11)
    public void diffTaxPuInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"普票冲红"}, description = "不同商品、税率的普票冲红",priority = 12)
    public void diffTaxPuPiaoRed() throws IOException, NoSuchAlgorithmException, InterruptedException {
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        map.put("kplx", "1");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModelsRed), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }


    @Test(groups = {"开具专票"}, description = "不同商品，不同税率的专票开具")
    public void diffTaxZhuanInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String, String> map = InvoiceParamters.hashMap("004");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }
}
