package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.WeComFile;
import cn.hamm.wecom.robot.WeComMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <h1>语音</h1>
 *
 * @author Hamm.cn
 */
public class WeComVoiceMessage extends WeComMessage {
    public WeComVoiceMessage() {
        this.setMsgType("voice");
    }

    private Voice voice = new Voice();

    public Voice getVoice() {
        return voice;
    }

    public WeComVoiceMessage setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public static class Voice {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        /**
         * <h2>文件id</h2>
         *
         * @param mediaId 文件ID
         * @see WeComFile#uploadFile
         */
        public Voice setMediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }
    }
}
