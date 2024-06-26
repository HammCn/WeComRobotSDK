package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.WeComMessage;

/**
 * <h1>MarkDown</h1>
 *
 * @author Hamm.cn
 */
public class WeComMarkdownMessage extends WeComMessage {
    public WeComMarkdownMessage() {
        this.setMsgType("markdown");
    }

    private MarkDown markdown;

    public MarkDown getMarkdown() {
        return markdown;
    }

    public WeComMarkdownMessage setMarkdown(MarkDown markdown) {
        this.markdown = markdown;
        return this;
    }

    public static class MarkDown {
        private String content;

        public String getContent() {
            return content;
        }

        /**
         * <h2>设置markdown内容</h2>
         *
         * @param content markdown内容
         */
        public MarkDown setContent(String content) {
            this.content = content;
            return this;
        }
    }
}