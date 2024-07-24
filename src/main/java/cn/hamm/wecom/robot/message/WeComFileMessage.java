package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.base.WeComFile;
import cn.hamm.wecom.robot.base.WeComMessage;
import cn.hamm.wecom.robot.constant.WeComAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <h1>文件</h1>
 *
 * @author Hamm.cn
 */
public class WeComFileMessage extends WeComMessage {
    public WeComFileMessage() {
        this.setMsgType(WeComAlias.FILE);
    }

    private File file = new File();

    public File getFile() {
        return file;
    }

    public WeComFileMessage setFile(File file) {
        this.file = file;
        return this;
    }

    public static class File {
        @JsonProperty(WeComAlias.MEDIA_ID)
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        /**
         * <h2>文件 {@code ID}</h2>
         *
         * @param mediaId 文件 {@code ID}
         * @see WeComFile#uploadFile
         */
        public File setMediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }
    }
}
