package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.service.HelloService;

/**
 * Created by takahashi on 2016/03/09.
 */
@Component
public class HelloPrinter {
    @Autowired
    public HelloService helloService;

    public void run() {
        System.out.println(helloService.hello());
    }
}
