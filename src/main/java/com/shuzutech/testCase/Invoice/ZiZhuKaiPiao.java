package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ZiZhuKaiPiao {

    @Test(groups = {"自助开票"}, description = "所有参数都正常，自助开票")
    public void ziZhuKaiPiao_0002() throws IOException, NoSuchAlgorithmException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        map.put("yhlx", "1");
        System.out.println(PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv));
    }
}
