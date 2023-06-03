package aigc.automedia.controller;

/*import com.openai.ChatCompletion;
import com.openai.ChatGPT;
import com.openai.ChatGPTRequest;
import com.openai.ChatGPTResponse;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TextGenerationController {

   /* private final ChatGPT chatGPT;
    private final String chatGPTModel;

    public TextGenerationController() {
        // 初始化ChatGPT模型和相关参数
        chatGPT = new ChatGPT("your-api-key");
        chatGPTModel = "gpt-3.5-turbo";
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateText(@RequestBody String keyword) {
        try {
            // 构建ChatGPT请求
            ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
            chatGPTRequest.setModel(chatGPTModel);
            chatGPTRequest.addExample(ChatGPTRequest.Example.builder().getPrompt().add(keyword).build());
            chatGPTRequest.setTemperature(0.7);
            chatGPTRequest.setMaxTokens(100);

            // 调用ChatGPT API生成文案
            ChatGPTResponse chatGPTResponse = chatGPT.createCompletion(chatGPTRequest);

            // 解析API响应并获取生成的文案
            ChatCompletion completion = chatGPTResponse.getChoices().get(0);
            String generatedText = completion.getText();

            // 将文案发布到自媒体平台
            boolean success = publishToMediaPlatform(generatedText);

            if (success) {
                return ResponseEntity.ok("文案生成成功并已发布！");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文案发布失败！");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文案生成失败！");
        }
    }*/

    private boolean publishToMediaPlatform(String text) {
        // 在这里编写将文案发布到自媒体平台的逻辑
        // 使用自媒体平台的开放API进行发布
        // 返回发布是否成功的状态
        return true; // 或根据实际情况返回相应状态
    }
}
