package Config;

import Bean.EnvNum;
import Bean.SaveAddr;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSaveAddr {

    /**
     * 获取开票的链接
     * @param num
     * @return
     * @throws IOException
     */
    public static String getSaveAddr(EnvNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SaveAddr saveAddr = new SaveAddr();
        if (num == EnvNum.PRO || num == EnvNum.PRO1){
            saveAddr = session.selectOne("getSaveAddr","PRO");
        }
        if (num == EnvNum.DEV){
            saveAddr = session.selectOne("getSaveAddr","DEV");
        }
        if (num == EnvNum.TEST || num == EnvNum.TEST1){
            saveAddr = session.selectOne("getSaveAddr","TEST");
        }

        return saveAddr.getAddress();
    }

    public static void main(String[] args){
        try {
            System.out.println("本次请求的token："+getSaveAddr(EnvNum.PRO));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
