package cn.hamm.wecom.robot;

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

import java.io.*;
import java.util.Map;

/**
 * <h1>企业微信上传文件</h1>
 *
 * @author Hamm.cn
 */
public class WeComFile extends WeCom {
    /**
     * <h2>上传语音</h2>
     *
     * @param key  机器人Key
     * @param path 文件路径
     * @return 文件ID
     */
    public static String uploadVoice(String key, String path) throws WeComException, IOException {
        return upload(key, "voice", path);
    }

    /**
     * <h2>上传语音</h2>
     *
     * @param key  机器人Key
     * @param path 文件路径
     * @return 文件ID
     */
    public static String uploadFile(String key, String path) throws WeComException, IOException {
        return upload(key, "file", path);
    }

    /**
     * <h2>上传文件</h2>
     *
     * @param key  机器人Key
     * @param type 类型
     * @param path 文件路径
     * @return 文件ID
     */
    private static String upload(String key, String type, String path) throws IOException, WeComException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(String.format(UPLOAD_FILE_URL, type, key));

            File file = new File(path);
            HttpEntity multipartEntity = MultipartEntityBuilder.create()
                    .addPart("media", new FileBody(file))
                    .build();

            httpPost.setEntity(multipartEntity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null) {
                    String body = EntityUtils.toString(httpEntity);
                    System.out.println(body);
                    Map map = JsonUtil.parse(body, Map.class);
                    int errorCode = (int) map.get(WeCom.CODE_KEY);
                    if (errorCode != WeCom.SUCCESS_CODE) {
                        throw new WeComException(body);
                    }
                    return map.get("media_id").toString();
                }
            } finally {
                httpClient.close();
            }
        }
        throw new WeComException("上传失败");
    }
}
