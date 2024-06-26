package cn.hamm.wecom.robot;

import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.util.HttpUtil;
import cn.hamm.wecom.robot.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * <h1>消息基类</h1>
 *
 * @author Hamm.cn
 */
public class WeComMessage {
    public static final String URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";
    public static final int SUCCESS_CODE = 0;
    public static final String CODE_KEY = "errcode";

    @JsonProperty("msgtype")
    private String msgType;

    public String getMsgType() {
        return msgType;
    }

    protected void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public final void send(String robotKey) throws WeComException {
        try {
            String request = JsonUtil.toString(this);
            System.out.println(request);
            String response = HttpUtil.post(URL + robotKey, request);
            System.out.println(response);
            Map map = JsonUtil.parse(response, Map.class);
            int errorCode = (int) map.get(CODE_KEY);
            if (errorCode != SUCCESS_CODE) {
                throw new WeComException(response);
            }
        } catch (Exception exception) {
            throw new WeComException(exception.getMessage());
        }
    }
}
