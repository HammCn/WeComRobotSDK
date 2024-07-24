package cn.hamm.wecom.robot.base;

import cn.hamm.wecom.robot.constant.WeComAlias;
import cn.hamm.wecom.robot.constant.WeComConstant;
import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.util.HttpUtil;
import cn.hamm.wecom.robot.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * <h1>企业微信机器人消息</h1>
 *
 * @author Hamm.cn
 */
public class WeComMessage {
    @JsonProperty(WeComAlias.MESSAGE_TYPE)
    private String msgType;

    public String getMsgType() {
        return msgType;
    }

    protected void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * <h2>发送机器人消息</h2>
     *
     * @param robotKey 机器人 {@code Key}
     * @throws WeComException 异常
     */
    public final void send(String robotKey) throws WeComException {
        try {
            String request = JsonUtil.toString(this);
            String response = HttpUtil.post(String.format(WeComConstant.WEB_HOOK_URL, robotKey), request);
            Map<?, ?> map = JsonUtil.parse(response, Map.class);
            int errorCode = (int) map.get(WeComAlias.ERROR_CODE);
            if (errorCode != WeComConstant.SUCCESS_CODE) {
                throw new WeComException(response);
            }
        } catch (Exception exception) {
            throw new WeComException(exception.getMessage());
        }
    }
}
