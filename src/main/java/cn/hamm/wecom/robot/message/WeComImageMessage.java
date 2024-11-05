package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.base.WeComMessage;
import cn.hamm.wecom.robot.constant.WeComAlias;
import cn.hamm.wecom.robot.util.ImageUtil;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * <h1>图片</h1>
 *
 * @author Hamm.cn
 */
public class WeComImageMessage extends WeComMessage {

    private Image image = new Image();

    public WeComImageMessage() {
        this.setMsgType(WeComAlias.IMAGE);
    }

    public Image getImage() {
        return image;
    }

    public WeComImageMessage setImage(Image image) {
        this.image = image;
        return this;
    }

    public static class Image {
        private String base64;
        private String md5;

        public String getBase64() {
            return base64;
        }

        /**
         * <h2>图片内容的 {@code Base64} 编码</h2>
         *
         * @param base64 图片内容的 {@code Base64} 编码
         */
        public Image setBase64(String base64) {
            this.base64 = base64;
            return this;
        }

        public String getMd5() {
            return md5;
        }

        /**
         * <h2>图片内容 {@code Base64编码前} 的md5值</h2>
         *
         * @param md5 图片内容 {@code Base64编码前} 的 {@code MD5} 值
         */
        public Image setMd5(String md5) {
            this.md5 = md5;
            return this;
        }

        /**
         * <h2>设置图片</h2>
         *
         * @param path 图片路径
         */
        public Image setPath(Path path) {
            try (InputStream imageStream = Files.newInputStream(path)) {
                byte[] bytes = Files.readAllBytes(path);
                md5 = ImageUtil.getImageMd5(imageStream);
                base64 = new String(Base64.getEncoder().encode(bytes));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return this;
        }
    }
}
