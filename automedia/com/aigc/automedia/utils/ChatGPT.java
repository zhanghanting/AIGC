    package aigc.automedia.utils;
    import com.alibaba.fastjson.JSONObject;
    import org.apache.http.HttpHost;
    import org.apache.http.HttpResponse;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.config.RequestConfig;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.entity.StringEntity;
    import org.apache.http.impl.client.HttpClientBuilder;
    import org.apache.http.util.EntityUtils;

    public class ChatGPT {
        public static void main(String[] args) throws Exception {
            HttpHost proxy = new HttpHost("127.0.0.1", 7890);
            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

            HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
           // HttpClient httpClient = HttpClientBuilder.create().build();
            //HttpPost request = new HttpPost("https://api.openai.com/v1/engines/davinci/jobs");
            //HttpPost request = new HttpPost("https://api.openai.com/v1/engines/davinci-codex/completions");
            HttpPost request = new HttpPost("https://api.openai.com/v1/engines/davinci/completions");

            request.addHeader("Content-Type", "application/json");
            request.addHeader("Authorization", "Bearer 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");

            JSONObject requestBody = new JSONObject();
            requestBody.put("prompt", "What is the capital of France?");
            requestBody.put("max_tokens", 100);
            requestBody.put("temperature", 0.5);

            StringEntity requestEntity = new StringEntity(requestBody.toString());
            request.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(request);
            System.out.println("-----response:" + response.getStatusLine());

            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println(responseString);
            JSONObject responseJson = JSONObject.parseObject(responseString);
            System.out.println("-----responseJson:" + responseJson);

            System.out.println("Response: " + responseJson.getString("choices").split("\n")[0]);
        }
    }