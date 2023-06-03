package aigc.automedia.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ChatGPTClient {

    public static void main(String[] args) throws IOException {
        String apiKey = "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";
        String chatGPTModel = "gpt-3.5-turbo";
        //String prompt = "请描述一下男性和女性的区别，要求200字左右";
        String prompt = "请问我刚说了什么";

        // 构建请求
        //String url = "https://api.openai.com/v1/engines/" + chatGPTModel + "/completions";
        String url = "https://api.openai.com/v1/engines/davinci/completions";
        HttpHost proxy = new HttpHost("127.0.0.1", 7890);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());

        // 设置请求体
        StringEntity requestBody = new StringEntity(
                "{\"prompt\": \"" + prompt + "\", \"temperature\": 0.7, \"max_tokens\": 2000}",
                ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestBody);

        // 发送请求
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();) {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseJson = EntityUtils.toString(entity);
                // 处理 API 响应
                System.out.println(responseJson);
            }
        }
    }
}
