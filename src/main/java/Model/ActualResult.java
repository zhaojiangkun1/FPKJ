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
}
