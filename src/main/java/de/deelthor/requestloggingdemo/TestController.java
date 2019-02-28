package de.deelthor.requestloggingdemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {

    @LogRequest
    @GetMapping("/test1")
    @ResponseBody
    public String handleTest1 () {
        return "response for test1";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String handleTest2 () {
        return "response for test2";
    }
}
