package hello.springmvc.basic.request;


import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 스트림은 바이트 코드 1이기 때문에 어떤 문자형식으로 받을지를 지정 해줘야 한다.

        log.info("messageBody={}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter)throws Exception {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity requestBodyStringV3(RequestEntity<String> httpEntity)throws Exception {

//        스프링이 알아서 클라이언트로 부터 받는 데이터의 종류를 보고 알아서 변환해준다.
//        불필요한 인풋 스트림을 얻는 코드나, 문자형식을 지정해주는 코드가 필요 없어졌다.
        String messageBody = httpEntity.getBody();

//        변환된 바디를 꺼냄

        log.info("messageBody={}", messageBody);
//       반화 또한 비슷하게 HttpEntity 자체를 반환하면 된다. 파라메터로 body부분을 지정할 수 있다.
        return new ResponseEntity<String>("ok",HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody)throws Exception {

        log.info("messageBody={}", messageBody);

        return "ok";
    }

}
