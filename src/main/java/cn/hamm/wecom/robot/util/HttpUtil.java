package cn.hamm.wecom.robot.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * <h1>HTTP</h1>
 *
 * @author Hamm.cn
 */
public class HttpUtil {
    /**
     * <h2>发起Post请求</h2>
     *
     * @param url  URL
     * @param json Json
     * @return Response
     */
    public static String post(String url, String json) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
            entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setEntity(entity);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
                if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity response = httpResponse.getEntity();
                    if (Objects.nonNull(response)) {
                        return EntityUtils.toString(response);
                    }
                    throw new RuntimeException("服务器未返回数据");
                }
                throw new RuntimeException("服务器返回异常");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
