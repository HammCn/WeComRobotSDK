package cn.hamm.wecom.robot.base;

import cn.hamm.wecom.robot.constant.WeComAlias;
import cn.hamm.wecom.robot.constant.WeComConstant;
import cn.hamm.wecom.robot.exception.WeComException;
import cn.hamm.wecom.robot.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <h1>企业微信上传文件</h1>
 *
 * @author Hamm.cn
 */
public class WeComFile {

    /**
     * <h2>上传语音</h2>
     *
     * @param key  机器人 {@code Key}
     * @param path 文件路径
     * @return 文件 {@code ID}
     */
    public static String uploadVoice(String key, String path) throws WeComException, IOException {
        return upload(key, WeComAlias.VOICE, path);
    }

    /**
     * <h2>上传语音</h2>
     *
     * @param key  机器人 {@code Key}
     * @param path 文件路径
     * @return 文件 {@code ID}
     */
    public static String uploadFile(String key, String path) throws WeComException, IOException {
        return upload(key, WeComAlias.FILE, path);
    }

    /**
     * <h2>上传文件</h2>
     *
     * @param key  机器人 {@code Key}
     * @param type 类型
     * @param path 文件路径
     * @return 文件 {@code ID}
     */
    private static String upload(String key, String type, String path) throws IOException, WeComException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(String.format(WeComConstant.UPLOAD_FILE_URL, type, key));

            File file = new File(path);
            HttpEntity multipartEntity = MultipartEntityBuilder.create()
                    .addPart(WeComAlias.MEDIA, new FileBody(file))
                    .build();

            httpPost.setEntity(multipartEntity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null) {
                    String body = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
                    Map<?, ?> map = JsonUtil.parse(body, Map.class);
                    int errorCode = (int) map.get(WeComAlias.ERROR_CODE);
                    if (errorCode != WeComConstant.SUCCESS_CODE) {
                        throw new WeComException(body);
                    }
                    return map.get(WeComAlias.MEDIA_ID).toString();
                }
            } finally {
                httpClient.close();
            }
        }
        throw new WeComException("上传文件失败");
    }
}
