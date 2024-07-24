package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.base.WeComMessage;
import cn.hamm.wecom.robot.constant.WeComAlias;

/**
 * <h1>MarkDown</h1>
 *
 * @author Hamm.cn
 */
public class WeComMarkdownMessage extends WeComMessage {

    public WeComMarkdownMessage() {
        this.setMsgType(WeComAlias.MARKDOWN);
    }

    private MarkDown markdown = new MarkDown();

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
         * <h2>设置 {@code MarkDown} 内容</h2>
         *
         * @param content {@code MarkDown} 内容
         */
        public MarkDown setContent(String content) {
            this.content = content;
            return this;
        }
    }
}
