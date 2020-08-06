package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.SaveFpInfo;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.GetSaveFpInfo;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class SpecialConfigurationInvoice {
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
