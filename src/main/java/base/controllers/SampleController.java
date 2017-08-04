package base.controllers;

/**
 * Created by kongxiangwen on 2017/8/4.
 */

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello spring boot World!";
    }

    @RequestMapping("/ping")
    @ResponseBody
    String pong() {
        return "pong";
    }
}