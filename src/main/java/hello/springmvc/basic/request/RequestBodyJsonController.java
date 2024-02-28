package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;

/*
* {"username":"hello","age":20}
* content-type : application/json
* */

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/reuqest-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={},age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/reuqest-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws Exception {

        log.info("messageBody={}",messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={},age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/reuqest-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) throws Exception {

        log.info("username={},age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/reuqest-body-json-v4")
    public String requestBodyJsonV4(@RequestBody HttpEntity<HelloData> data) throws Exception {

        HelloData body = data.getBody();
        log.info("username={},age={}", body.getUsername(), body.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/reuqest-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData data) throws Exception {

        log.info("username={},age={}", data.getUsername(), data.getAge());

        return data;
    }







}
