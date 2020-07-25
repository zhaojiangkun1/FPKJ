package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.TestResult;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.GroupModel;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import com.shuzutech.model.ZhuanPiaoChongHong;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.shuzutech.config.GetInvoiceCase.getInvoiceCase;
import static com.shuzutech.model.GongYouFangFa.gongYouFangFa;


public class ZhuanPiaoRed {



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
    @Test(groups = {"专票冲红"}, description = "所有参数均正常，冲红一张增值税专票",enabled = false)
    public void zhuanPiaoHongChong_0002() throws IOException, NoSuchAlgorithmException {
        HashMap<String, String> map = hashMap("004");
        map.put("sprsjh", "");
        map.put("tzdbh", "3201122006019300");
        map.put("yfpdm", "3200192130");
        map.put("yfphm", "56436284");
        InvoiceCase invoiceCase = getInvoiceCase("zhuanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"专票冲红"}, description = "所有参数均正常，冲红一张带清单的增值税专票",enabled = false)
    public void redListZhuanPiao() throws IOException, NoSuchAlgorithmException {
        HashMap<String, String> map = hashMap("004");
        map.put("sprsjh", "");
        map.put("qdbz", "1");
        map.put("tzdbh", "3201122006019300");
        map.put("yfpdm", "3200192130");
        map.put("yfphm", "56436284");
        InvoiceCase invoiceCase = getInvoiceCase("zhuanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map, 9), invoiceCase);
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


