package base.controllers;

/**
 * Created by kongxiangwen on 2017/8/4.
 */

import base.models.TestEvent;
import base.services.EventBusService;
import java.awt.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventBusController {

    @Resource
    private EventBusService eventBusService;
    @RequestMapping("/event")
    @ResponseBody
    String event() {

        eventBusService.registerNewEventHandler(event -> {
            //System.out.println("new event handler");
            System.out.println(event.getMessage());

        });

        eventBusService.postEvent(new TestEvent("hi event bus."));
        return "Hello spring boot event World!";
    }
}