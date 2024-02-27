package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기) * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping({"/hello-basic", "hello-go"})
    public String helloBasic() {

        log.info("helloBasic");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {

        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);

        return "ok";
    }



    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {

        log.info("mappingHeader");

        return "ok";

    }

    //쿼리 파라미터를 조건에 매핑할 수 있다.
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {

        log.info("mappingConsumes");

        return "ok";}

    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
