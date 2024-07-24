package cn.hamm.wecom.robot.constant;

/**
 * <h2>企业微信常量</h2>
 *
 * @author Hamm.cn
 */
public class WeComConstant {
    /**
     * <h2>{@code WebHook URL}</h2>
     */
    public static final String WEB_HOOK_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=%s";

    /**
     * <h2>文件上传 {@code URL}</h2>
     */
    public static final String UPLOAD_FILE_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/upload_media?type=%s&key=%s";

    /**
     * <h2>成功状态码</h2>
     */
    public static final int SUCCESS_CODE = 0;
}
