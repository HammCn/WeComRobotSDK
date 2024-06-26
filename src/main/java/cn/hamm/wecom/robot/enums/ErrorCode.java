package cn.hamm.wecom.robot.enums;

/**
 * <h1>错误代码</h1>
 *
 * @author Hamm.cn
 */
public enum ErrorCode {
    /**
     * <h2>成功</h2>
     */
    SUCCESS(200),

    /**
     * <h2>服务发生异常</h2>
     */
    SERVICE_ERROR(500);

    /**
     * <h2>错误代码</h2>
     */
    private final int code;

    /**
     * <h2>创建一个错误代码</h2>
     *
     * @param code 错误代码
     */
    ErrorCode(int code) {
        this.code = code;
    }

    /**
     * <h2>获取状态码</h2>
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }
}
