package com.shuzutech.config;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.EnvNum;
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

    public static void runResult(HashMap<String, String> map) throws IOException, NoSuchAlgorithmException, InterruptedException {
        long t1 = System.currentTimeMillis()/1000;
        String fpcx = FPCX.fpcx(map);
        String result="";
        result=PostRequest.zhenPiaoYunRequest(fpcx, TestEnv.testEnv);
        JSONObject fpcxResult = new JSONObject();
        fpcxResult = parseResult(result);
        String returnmsg = fpcxResult.getString("returnmsg");
        System.out.println("returnmsg:" + returnmsg);
        boolean flag = (returnmsg.equals("该发票正在开具中，请稍后查询")||returnmsg.equals("发票明细查询失败，未找到相关发票信息！")||returnmsg.equals(""));
        System.out.println("flag：" + flag);
        int num = 1;
        while (flag) {
            Thread.sleep(1000);
            long t2 = System.currentTimeMillis()/1000;
            result = PostRequest.zhenPiaoYunRequest(fpcx, TestEnv.testEnv);
            fpcxResult = parseResult(result);
            returnmsg = fpcxResult.getString("returnmsg");
            System.out.println("执行第" + num + "次");
            if (t2-t1 > 50)
                flag = false;
            else
                flag = (returnmsg.equals("该发票正在开具中，请稍后查询")||returnmsg.equals("发票明细查询失败，未找到相关发票信息！")||returnmsg.equals(""));
            num++;
            System.out.println("while+flag:" + flag);
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

    public static void main(String[] args) throws InterruptedException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode", "300077");
        jsonObject.put("returnmsg", "该发票正在开具中，请稍后查询");
        boolean flag = jsonObject.getString("returnmsg").equals("该发票正在开具中，请稍后查询");
        long t1 = System.currentTimeMillis();
        long totalSeconds = t1 / 1000;
        System.out.println("t1:" + totalSeconds);
//        long currentSeconds = totalSeconds / 60;
//        System.out.println("currentSeconds:" + currentSeconds);
        int num = 1;
        while (flag) {
            Thread.sleep(1000);
            long t2 = System.currentTimeMillis() / 1000 ;
            System.out.println("t2:" + t2);
            System.out.println("执行第" + num + "次");
//            System.out.println("t2-t1:" + (t2 - t1));
            if (t2 - totalSeconds > 50) {
                flag = false;

            } else {
                flag = true;
            }
            System.out.println("flag:" + flag);
            num++;
        }


    }
}
