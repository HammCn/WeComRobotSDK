package cn.hamm.wecom.robot.util;

import cn.hamm.wecom.robot.WeComMessage;
import cn.hamm.wecom.robot.message.WeComFileMessage;
import cn.hamm.wecom.robot.message.WeComImageMessage;
import cn.hamm.wecom.robot.message.WeComMarkdownMessage;
import cn.hamm.wecom.robot.message.WeComNewsMessage;
import cn.hamm.wecom.robot.message.WeComTemplateCardMessage;
import cn.hamm.wecom.robot.message.WeComTextMessage;
import cn.hamm.wecom.robot.message.WeComVoiceMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Objects;

/**
 * <h1>Json Util</h1>
 *
 * @author Hamm.cn
 */
public class JsonUtil {
    private static ObjectMapper objectMapper;

    public static <E> E parse(String json, Class<E> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static WeComMessage parseWeComMessage(String json) {
        try {
            WeComMessage weComMessage = getObjectMapper().readValue(json, WeComMessage.class);
            switch (weComMessage.getMsgTypeEnum()) {
                case IMAGE:
                    return getObjectMapper().readValue(json, WeComImageMessage.class);
                case FILE:
                    return getObjectMapper().readValue(json, WeComFileMessage.class);
                case NEWS:
                    return getObjectMapper().readValue(json, WeComNewsMessage.class);
                case TEXT:
                    return getObjectMapper().readValue(json, WeComTextMessage.class);
                case VOICE:
                    return getObjectMapper().readValue(json, WeComVoiceMessage.class);
                case MARKDOWN:
                    return getObjectMapper().readValue(json, WeComMarkdownMessage.class);
                case TEMPLATE_CARD:
                    return getObjectMapper().readValue(json, WeComTemplateCardMessage.class);
                default:
                    return null;
            }
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String toString(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static ObjectMapper getObjectMapper() {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
            // 忽略未声明的属性
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // 忽略值为null的属性
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            // 忽略没有属性的类
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        }
        return objectMapper;
    }
}
