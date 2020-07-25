package com.shuzutech.config;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.model.PostRequest;
import com.shuzutech.model.SaveInvoiceMessage;
import org.testng.Assert;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

public class TestResult {

    private static void testFpcxResult(JSONObject realResult) {
        JSONObject expectedResult = new JSONObject();
        expectedResult.put("returncode", 0);
        expectedResult.put("returnmsg", "成功");
        Assert.assertEquals(realResult, expectedResult);
    }

    public static void testFpkjResult(String result) {
        JSONObject realResult = parseResult(result);
        JSONObject expectedResult = new JSONObject();
        expectedResult.put("returncode", 0);
        expectedResult.put("returnmsg", "提交成功，请稍后查询");
        Assert.assertEquals(realResult, expectedResult);
    }

    public static void runResult(HashMap<String, String> map) throws IOException, NoSuchAlgorithmException {
        String jsbh = map.get("jsbh");
        String fplxdm = map.get("fplxdm");
        String fpqqlsh = map.get("fpqqlsh");
        String fpcx = FPCX.fpcx(jsbh, fplxdm, fpqqlsh);
        String result;
        result = PostRequest.zhenPiaoYunRequest(fpcx, TestEnv.testEnv);
        JSONObject fpcxResult;
        fpcxResult = parseResult(result);
        while (fpcxResult.get("retrunmsg") == "该发票正在开具中，请稍后查询") {
            result = PostRequest.zhenPiaoYunRequest(fpcx, TestEnv.testEnv);
            fpcxResult = parseResult(result);
        }
        testFpcxResult(parseResult(result));
        String fpdm = result.substring(result.indexOf("<fpdm>") + ("<fpdm>").length(), result.indexOf("</fpdm>"));
        String fphm = result.substring(result.indexOf("<fphm>") + ("<fphm>").length(), result.indexOf("</fphm>"));
        map.put("fpdm", fpdm);
        map.put("fphm", fphm);
        System.out.println("fpdm:" + fpdm);
        System.out.println("fphm:" + fphm);
        new SaveInvoiceMessage().saveSuccessInvoiceMessage(map, new Date());
    }

    public static JSONObject parseResult(String result) {
        String leftTag = "<returncode>";
        String rightTag = "</returncode>";
        String code = result.substring(result.indexOf(leftTag) + leftTag.length(), result.indexOf(rightTag));
        String left = "<returnmsg>";
        String right = "</returnmsg>";
        String retrunmsg = result.substring(result.indexOf(left) + left.length(), result.indexOf(right));
        int returncode = Integer.valueOf(code);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode", returncode);
        jsonObject.put("returnmsg", retrunmsg);
        return jsonObject;
    }
}
