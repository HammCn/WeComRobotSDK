package cn.hamm.wecom.robot;

import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.message.WeComImageMessage;
import cn.hamm.wecom.robot.message.WeComTextMessage;
import cn.hamm.wecom.robot.util.JsonUtil;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestSerial {

    public static void main(String[] args) throws WeComException {
        text2Image();
        image2Text();
    }

    public static void text2Json() {
        WeComTextMessage weComTextMessage = new WeComTextMessage();
        weComTextMessage.getText().setContent("text");

        String jsonStr = JsonUtil.toString(weComTextMessage);
        System.out.println(jsonStr);

    }


    public static void json2Text() {
        String json = "{\"text\":{\"content\":\"text\",\"mentioned_list\":[]},\"msgtype\":\"text\"}";

        WeComMessage parse = JsonUtil.parse(json, WeComMessage.class);
        System.out.println(parse.getMsgTypeEnum());
    }


    public static void text2Image() {
        WeComImageMessage weComImageMessage = new WeComImageMessage();
        String file = "src/test/resources/image.png";
        Path path = Paths.get(file);
        weComImageMessage.getImage().setPath(path);
        System.out.println(JsonUtil.toString(weComImageMessage));

    }


    public static void image2Text() {
        String json = "{\"image\":{\"base64\":\"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\",\"md5\":\"366e5ee28e544aeeb9d405bea57a15e2\"},\"msgtype\":\"image\"}";

        WeComMessage parse = JsonUtil.parseWeComMessage(json);

        System.out.println(parse.getClass().getSimpleName());
    }
}
