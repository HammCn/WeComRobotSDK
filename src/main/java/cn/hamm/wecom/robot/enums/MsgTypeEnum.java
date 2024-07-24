package cn.hamm.wecom.robot.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息类型
 *
 * @author QingWei
 */

public enum MsgTypeEnum {

    /**
     * 文本消息
     */
    @JsonProperty("text") TEXT,
    /**
     * 图片消息
     */
    @JsonProperty("image") IMAGE,
    /**
     * 图文消息
     */
    @JsonProperty("news") NEWS,
    /**
     * 文件消息
     */
    @JsonProperty("file") FILE,
    /**
     * 语音消息
     */
    @JsonProperty("voice") VOICE,
    /**
     * 模板卡片消息
     */
    @JsonProperty("template_card") TEMPLATE_CARD,
    /**
     * markdown消息
     */
    @JsonProperty("markdown") MARKDOWN;


}
