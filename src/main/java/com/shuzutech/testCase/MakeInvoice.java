package com.shuzutech.testCase;

import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
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

public class MakeInvoice {
    /**
     * 用来单独测试的，不在自动化测试范围内
     *
     * @throws InterruptedException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    ArrayList<GroupModel> groupModels = GroupModelList.groupModelArrayList();
    ArrayList<GroupModel> groupModelsRed = GroupModelList.groupModelArrayListRed();

    @Test
    public void makeInvoice() throws InterruptedException, NoSuchAlgorithmException, IOException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
//        map.put("qdbz","0");
        map.put("ghdwmc", "上海盛付通电子支付服务有限公司");
        map.put("ghdwsbh", "9131011567624841X0");
        map.put("ghdwdzdh", "");
        map.put("gwdyhzh", "");
        map.put("spmc","");
        map.put("spsl", "");
        map.put("dj", "");
        map.put("je", "1475.12");
        map.put("sl", "");
        map.put("se", "");
        map.put("spbm","");
//        map.put("yhzcbs", "0");
//        map.put("zzstsgl", "免税");
        PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
//        GongYouFangFa.zpy(map, result);
//        map.put("kplx","1");
//        map.put("yfpdm","050000000004");
//        map.put("yfphm","20191672");
//        map.put("fpqqlsh","SZZPY20200728154316");
//        PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map,groupModels), TestEnv.bwt_env);
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
