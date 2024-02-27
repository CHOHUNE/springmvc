package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassControllrr {

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUSer() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String id ) {
        return "get userId=" + id;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }



}
