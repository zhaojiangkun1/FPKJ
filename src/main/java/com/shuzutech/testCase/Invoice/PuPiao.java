package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.*;
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

@Test(dependsOnGroups = {"开具电票"})
public class PuPiao {

    ArrayList<GroupModel> groupModels = new ArrayList<>();

    /**
     * 合力："HOLY",10001,"商品名称格式有误_FyxmN1"
     * 旋极：{"returnmsg":"开票明细中包含GBK无法编码字符,请检查！","returncode":1000008}
     * <p>
     * 智能空气品质控制器 KF-700RM(RPM+Malino)
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException
     */
    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张增值税普通发票")
    public void generalInvoice() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "所有参数均正常，冲红一张增值税普通发票", dependsOnMethods = {"generalInvoice"})
    public void generalInvoiceRed() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = hashMap("007");
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        map.put("sprsjh", "");
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "开具一张带折扣行的普票",dependsOnMethods = {"generalInvoiceRed"})
    public void discountGeneralInvoice() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        GroupModel groupModel = new GroupModel("2", "1", "20", "20", "0.03", "0.6");
        GroupModel groupModel1 = new GroupModel("1", "", "", "-10", "0.03", "-0.3");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }


    @Test(groups = {"开具普票"}, description = "冲红一张带折扣的增值税普通发票", dependsOnMethods = {"discountGeneralInvoice"})
    public void discountPuPiaoRed() throws IOException, NoSuchAlgorithmException, InterruptedException {
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel = new GroupModel("0", "-1", "10", "-10", "0.03", "-0.3");
        groupModels.add(groupModel);
        map.put("kplx", "1");
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张6行商品的普票",dependsOnMethods = {"discountPuPiaoRed"})
    public void generalInvoiceSixCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String file = Java2XML.BuildXMLDoc(map, 6);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开票普票"}, description = "所有参数均正常,开具一张8行商品的普票",dependsOnMethods = {"generalInvoiceSixCommodity"})
    public void generalInvoiceEightCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        String file = Java2XML.BuildXMLDoc(map, 8);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "所有参数均正常，开具一张10行商品的普票",dependsOnMethods = {"generalInvoiceEightCommodity"})
    public void generalInvoiceTenCommodity() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        map.put("qdbz", "1");
        String file = Java2XML.BuildXMLDoc(map, 10);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);

    }

    @Test(groups = {"开具普票"}, description = "冲红一张带清单普票", dependsOnMethods = {"generalInvoiceTenCommodity"})
    public void redListGeneralInvoice() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = hashMap("007");
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        map.put("sprsjh", "");
        map.put("qdbz", "1");
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map, 10), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "不同商品，不同税率的普票开具",dependsOnMethods = {"redListGeneralInvoice"})
    public void diffTaxPuInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        ArrayList<GroupModel> groupModels = GroupModelList.groupModelArrayList();
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    @Test(groups = {"开具普票"}, description = "不同商品、税率的普票冲红",dependsOnMethods = {"diffTaxPuInvoice"})
    public void diffTaxPuPiaoRed() throws IOException, NoSuchAlgorithmException, InterruptedException {
        ArrayList<GroupModel> groupModelsRed = GroupModelList.groupModelArrayListRed();
        SaveFpInfo saveFpInfo = GetSaveFpInfo.getSaveFpInfo();
        HashMap<String, String> map = InvoiceParamters.hashMap("007");
        map.put("kplx", "1");
        map.put("yfpdm", saveFpInfo.getFpdm());
        map.put("yfphm", saveFpInfo.getFphm());
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map, groupModelsRed), TestEnv.testEnv);
        GongYouFangFa.zpy(map, result);
    }

    /**
     * 专票是不能开具0税率发票
     * @throws InterruptedException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test(groups = {"开票普票"},description = "使用免税政策开票",dependsOnMethods = {"diffTaxPuPiaoRed"})
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

    private static HashMap<String, String> hashMap(String fplxdm) {
        HashMap<String, String> map = InvoiceParamters.hashMap(fplxdm);
        map.put("kplx", "1");
        map.put("spsl", "-1");
        map.put("dj", "282.075472");
        map.put("je", "-282.08");
        map.put("sl", "0.06");
        map.put("se", "-16.92");
        return map;
    }
}
