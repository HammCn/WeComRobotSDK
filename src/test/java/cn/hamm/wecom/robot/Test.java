package cn.hamm.wecom.robot;


import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.message.WeComTemplateCardMessage;
import cn.hamm.wecom.robot.message.WeComTemplateCardMessage.TemplateCard.Source.DescColor;

import static cn.hamm.wecom.robot.message.WeComTemplateCardMessage.*;

public class Test {
    public static void main(String... args) throws WeComException {
        WeComTemplateCardMessage weComTemplateCardMessage = new WeComTemplateCardMessage();
        TemplateCard templateCard = new TemplateCard();
        templateCard.getMainTitle().setTitle("title").setDesc("desc");
        templateCard.getSource()
                .setDesc("desc")
                .setDescColor(DescColor.GREEN)
                .setIconUrl("https://avatars.githubusercontent.com/u/10349107?v=4");
        templateCard.getEmphasisContent().setTitle("10000").setDesc("Desc");
        templateCard.getCardAction().setUrl("https://github.com/HammCn");
        templateCard.addJump(new TemplateCard.Jump().setTitle("Github").setUrl("https://github.com/HammCn"));
        templateCard.addHorizontalContent(new TemplateCard.HorizontalContent().setKeyName("Key").setValue("Value"));
        templateCard.setSubTitleText("subTitleText");
        weComTemplateCardMessage.setTemplateCard(templateCard);
        weComTemplateCardMessage.send("624b2bc6-25e9-4b75-a00a-f3b4481f45f0");
    }
}