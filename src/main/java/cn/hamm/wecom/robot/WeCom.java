package cn.hamm.wecom.robot;

/**
 * <h1>企业微信SDK</h1>
 *
 * @author Hamm.cn
 */
public class WeCom {
    /**
     * <h2>WebHook URL</h2>
     */
    public static final String WEB_HOOK_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";

    /**
     * <h2>文件上传URL</h2>
     */
    public static final String UPLOAD_FILE_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/upload_media?type=%s&key=%s";

    /**
     * <h2>成功状态码</h2>
     */
    public static final int SUCCESS_CODE = 0;

    /**
     * <h2>错误代码Key</h2>
     */
    public static final String CODE_KEY = "errcode";
}
