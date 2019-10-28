package Model;

import com.alibaba.fastjson.JSONObject;

public class ActualResult {

    public static JSONObject parametersError(String param){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","10001");
        jsonObject.put("returnmsg",param+":参数错误");
        return jsonObject;
    }
    public static JSONObject resultCorrect(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","0");
        jsonObject.put("returnmsg","提交成功，请稍后查询");
        return jsonObject;
    }
    public static JSONObject resultCorrect1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","100012");
        jsonObject.put("returnmsg","开票明细中包含GBK无法编码字符,请检查！");
        return jsonObject;
    }
    public static JSONObject resultCorrect2(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","99");
        jsonObject.put("returnmsg","10034:红票原发票代码号码格式有误");
        return jsonObject;
    }
    public static JSONObject resultCorrect3(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","300063");
        jsonObject.put("returnmsg","开票码不匹配");
        return jsonObject;
    }
    public static JSONObject resultCorrect4(){
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("returncode","10001");
         jsonObject.put("returnmsg","缺少节点或内容ghdwmc");
         return jsonObject;
     }
     public static JSONObject resultCorrect5(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","10001");
        jsonObject.put("returnmsg","缺少节点或内容ghdwsbh");
        return jsonObject;
    }

         
}
