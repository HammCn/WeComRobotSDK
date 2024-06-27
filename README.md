# WeCom Robot SDK

一个很好用的企业微信机器人开发工具包。 [Github](https://github.com/HammCn/WeComRobotSDK) | [Gitee](https://gitee.com/hamm/WeComRobotSDK) | [Maven](https://central.sonatype.com/artifact/cn.hamm.wecom/WeComRobotSDK)

## 一、通过Maven引入

```xml
<dependency>
    <groupId>cn.hamm.wecom</groupId>
    <artifactId>WeComRobotSDK</artifactId>
    <version>0.0.1</version>
</dependency>
```

## 二、构建消息包体

1. 文本类型消息
```java
WeComTextMessage weComTextMessage = new WeComTextMessage();
weComTextMessage.getText().setContent("text");
weComTextMessage.send(ROBOT_KEY);
```

2. 图片类型消息

```java
WeComImageMessage weComImageMessage = new WeComImageMessage();
String file = "src/test/resources/image.png";
Path path = Paths.get(file);
weComImageMessage.getImage().setPath(path);
weComImageMessage.send(ROBOT_KEY);
```

3. 图文类型消息

```java
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
```

4. 文件类型消息

```java
String file = "src/test/resources/test.pdf";
String mediaId = WeComFile.uploadFile(ROBOT_KEY, file);
WeComFileMessage weComFileMessage = new WeComFileMessage();
weComFileMessage.getFile().setMediaId(mediaId);
weComFileMessage.send(ROBOT_KEY);
```

5. 语音消息

```java
String file = "src/test/resources/voice.amr";
String mediaId = WeComFile.uploadVoice(ROBOT_KEY, file);
WeComVoiceMessage weComVoiceMessage = new WeComVoiceMessage();
weComVoiceMessage.getVoice().setMediaId(mediaId);
weComVoiceMessage.send(ROBOT_KEY);
```

6. 模板卡片消息

- 6.1 文本通知卡片
    
```java
// 按需设置
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
```    

- 6.2 图文展示卡片

```java
// 按需设置
WeComTemplateCardMessage weComTemplateCardMessage = new WeComTemplateCardMessage();
TemplateCard templateCard = new TemplateCard().setCardTypeImage();
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
```   

7. 文件上传

```java
// 上传语音
String file = "src/test/resources/voice.amr";
String mediaId = WeComFile.uploadVoice(ROBOT_KEY, file);
System.out.println(mediaId);
```

```java
// 上传文件
String file = "src/test/resources/test.pdf";
String mediaId = WeComFile.uploadFIle(ROBOT_KEY, file);
System.out.println(mediaId);
```

## 三、意见反馈

欢迎在本仓库的 `Issues` 提出你的问题或者反馈发现的 BUG。 也欢迎加入我们的开发者交流QQ群: 1140258698