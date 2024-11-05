package cn.hamm.wecom.robot;


import cn.hamm.wecom.robot.base.WeComFile;
import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.message.*;
import cn.hamm.wecom.robot.message.WeComTemplateCardMessage.TemplateCard.Source.DescColor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static cn.hamm.wecom.robot.message.WeComTemplateCardMessage.TemplateCard;

public class Test {
    public static final String HAMM_CN = "https://hamm.cn";
    public static final String IMAGE_URL = "https://avatars.githubusercontent.com/u/10349107?v=4";
    private static final String ROBOT_KEY = "ea2edec3-61af-4094-acaf-73e228cad3bb";

    public static void main(String... args) throws WeComException, IOException {
        String file = "src/test/resources/voice.amr";
        String mediaId = WeComFile.uploadVoice(ROBOT_KEY, file);
        System.out.println(mediaId);
        testVoiceMessage(mediaId);
    }

    private static void testVoiceMessage(String mediaId) throws WeComException {
        WeComVoiceMessage weComVoiceMessage = new WeComVoiceMessage();
        weComVoiceMessage.getVoice().setMediaId(mediaId);
        weComVoiceMessage.send(ROBOT_KEY);
    }

    private static void testFileMessage(String mediaId) throws WeComException {
        WeComFileMessage weComFileMessage = new WeComFileMessage();
        weComFileMessage.getFile().setMediaId(mediaId);
        weComFileMessage.send(ROBOT_KEY);
    }

    private static void testNews() throws WeComException {
        WeComNewsMessage weComNewsMessage = new WeComNewsMessage();
        weComNewsMessage.getNews().addArticle(
                new WeComNewsMessage.News.Article()
                        .setTitle("Hello")
                        .setDescription("World")
                        .setPicUrl(IMAGE_URL)
                        .setUrl(HAMM_CN)
        ).addArticle(
                new WeComNewsMessage.News.Article()
                        .setTitle("Hello")
                        .setDescription("World")
                        .setPicUrl(IMAGE_URL)
                        .setUrl(HAMM_CN)
        );
        weComNewsMessage.send(ROBOT_KEY);
    }

    private static void testImage() throws WeComException {
        WeComImageMessage weComImageMessage = new WeComImageMessage();
        String file = "src/test/resources/image.png";
        // 读取资源文件夹下的图片
        Path path = Paths.get(file);
        weComImageMessage.getImage().setPath(path);
        weComImageMessage.send(ROBOT_KEY);
    }

    private static void testText() throws WeComException {
        WeComTextMessage weComTextMessage = new WeComTextMessage();
        weComTextMessage.getText().setContent("text");
        weComTextMessage.send(ROBOT_KEY);
    }

    private static void testMarkdown() throws WeComException {
        WeComMarkdownMessage weComMarkdownMessage = new WeComMarkdownMessage();
        weComMarkdownMessage.getMarkdown().setContent("markdown");
        weComMarkdownMessage.send(ROBOT_KEY);
    }

    private static void testTemplateCard() throws WeComException {
        WeComTemplateCardMessage weComTemplateCardMessage = new WeComTemplateCardMessage();
        TemplateCard templateCard = new TemplateCard().setCardTypeText();
        templateCard.getMainTitle().setTitle("TemplateCard").setDesc("desc");
        templateCard.getSource()
                .setDesc("desc")
                .setDescColor(DescColor.GREEN)
                .setIconUrl(IMAGE_URL);
        templateCard.getEmphasisContent().setTitle("10000").setDesc("Desc");
        templateCard.getCardAction().setUrl(HAMM_CN);
        templateCard.addJump(new TemplateCard.Jump().setTitle("Github").setUrl(HAMM_CN));
        templateCard.addHorizontalContent(new TemplateCard.HorizontalContent().setKeyName("Key").setValue("Value"));
        templateCard.setSubTitleText("subTitleText");
        weComTemplateCardMessage.setTemplateCard(templateCard);
        weComTemplateCardMessage.send(ROBOT_KEY);
    }

}
