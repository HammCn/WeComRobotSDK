package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.base.WeComMessage;
import cn.hamm.wecom.robot.constant.WeComAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>文本</h1>
 *
 * @author Hamm.cn
 */
public class WeComTextMessage extends WeComMessage {

    public WeComTextMessage() {
        this.setMsgType(WeComAlias.TEXT);
    }

    private Text text = new Text();

    public Text getText() {
        return text;
    }

    public WeComTextMessage setText(Text text) {
        this.text = text;
        return this;
    }

    public static class Text {
        private String content;

        public String getContent() {
            return content;
        }

        /**
         * <h2>文本内容</h2>
         *
         * @param content 文本内容
         * @apiNote 最长不超过2048个字节，必须是 {@code utf8} 编码
         */
        public Text setContent(String content) {
            this.content = content;
            return this;
        }

        @JsonProperty(WeComAlias.MENTIONED_LIST)
        List<String> mentionedList = new ArrayList<>();

        public List<String> getMentionedList() {
            return mentionedList;
        }
        @JsonProperty(WeComAlias.MENTIONED_MOBILE_LIST)
        private List<String> mentionedMobileList;

        /**
         * <h2>提醒成员userid列表</h2>
         *
         * @param mentionedList userid的列表
         * @apiNote 提醒群中的指定成员(@ 某个成员)，{@code @all} 表示提醒所有人，如果开发者获取不到 {@code userid}，可以使用 {@code mentioned_mobile_list}
         */
        public Text setMentionedList(List<String> mentionedList) {
            this.mentionedList = mentionedList;
            return this;
        }

        /**
         * <h2>添加提醒成员</h2>
         *
         * @param mentioned 提醒成员
         * @apiNote 提醒群中的指定成员(@ 某个成员)，{@code @all} 表示提醒所有人，如果开发者获取不到 {@code userid}，可以使用 {@code mentioned_mobile_list}
         */
        public Text addMentioned(String mentioned) {
            if (Objects.isNull(mentionedList)) {
                mentionedList = new ArrayList<>();
            }
            mentionedList.add(mentioned);
            return this;
        }

        public List<String> getMentionedMobileList() {
            return mentionedMobileList;
        }

        /**
         * <h2>提醒手机号列表</h2>
         *
         * @param mentionedMobileList 手机号列表
         * @apiNote 提醒手机号对应的群成员(@ 某个成员)，{@code @all}表示提醒所有人
         */
        public Text setMentionedMobileList(List<String> mentionedMobileList) {
            this.mentionedMobileList = mentionedMobileList;
            return this;
        }

        /**
         * <h2>添加提醒手机号</h2>
         *
         * @param mentionedMobile 手机号
         * @apiNote 提醒手机号对应的群成员(@ 某个成员)，{@code @all}表示提醒所有人
         */
        public Text addMentionedMobile(String mentionedMobile) {
            if (Objects.isNull(mentionedMobileList)) {
                mentionedMobileList = new ArrayList<>();
            }
            mentionedMobileList.add(mentionedMobile);
            return this;
        }
    }
}
