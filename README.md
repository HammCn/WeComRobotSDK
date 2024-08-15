<h1 align="center">WeCom Robot SDK</h1>
<p align="center">
    <img src="https://img.shields.io/badge/License-MIT-orange.svg"/>
    <img src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
    <img src="https://img.shields.io/maven-metadata/v.svg?label=Maven%20Central&metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcn%2Fhamm%2Fwecom%2FWeComRobotSDK%2Fmaven-metadata.xml"/>
</p>

<p align="center">
一个很好用的 <a href="https://developer.work.weixin.qq.com/document/path/91770" target="_blank">企业微信机器人</a> 开发工具包。 <a href="https://github.com/HammCn/WeComRobotSDK" target="_blank">Github</a> | <a href="https://gitee.com/hamm/WeComRobotSDK">Gitee</a> | <a href="https://central.sonatype.com/artifact/cn.hamm.wecom/WeComRobotSDK">Maven</a>
</p>

## 一、通过Maven引入

```xml
<dependency>
    <groupId>cn.hamm.wecom</groupId>
    <artifactId>WeComRobotSDK</artifactId>
    <version>1.0.3</version>
</dependency>
```

## 二、构建消息包体

请注意，以下为示例代码，仅展示了常用的一些配置方法，可安装依赖后在项目中查看更多。

### 1. 文本类型消息
```java
WeComTextMessage weComTextMessage = new WeComTextMessage();
weComTextMessage.getText().setContent("text");
weComTextMessage.send(ROBOT_KEY);
```

### 2. `Markdown`类型消息

```java
WeComMarkdownMessage weComMarkdownMessage = new WeComMarkdownMessage();
weComMarkdownMessage.getMarkdown().setContent("markdown");
weComMarkdownMessage.send(ROBOT_KEY);
```

### 3. 图片类型消息

```java
WeComImageMessage weComImageMessage = new WeComImageMessage();
String file = "src/test/resources/image.png";
Path path = Paths.get(file);
weComImageMessage.getImage().setPath(path);
weComImageMessage.send(ROBOT_KEY);
```

### 4. 图文类型消息

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

### 5. 文件类型消息

```java
String file = "src/test/resources/test.pdf";
String mediaId = WeComFile.uploadFile(ROBOT_KEY, file);
WeComFileMessage weComFileMessage = new WeComFileMessage();
weComFileMessage.getFile().setMediaId(mediaId);
weComFileMessage.send(ROBOT_KEY);
```

### 6. 语音消息

```java
String file = "src/test/resources/voice.amr";
String mediaId = WeComFile.uploadVoice(ROBOT_KEY, file);
WeComVoiceMessage weComVoiceMessage = new WeComVoiceMessage();
weComVoiceMessage.getVoice().setMediaId(mediaId);
weComVoiceMessage.send(ROBOT_KEY);
```

### 7. 模板卡片消息

- 7.1 文本通知卡片
    
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

- 7.2 图文展示卡片

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

### 8. 文件上传

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
