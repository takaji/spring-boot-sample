package sample.service;

import org.springframework.stereotype.Component;

/**
 * Created by takahashi on 2016/03/09.
 */
@Component
public class HelloServiceImpl implements HelloService {

    public String hello() {
        return "Hello Spring Boot Web!!";
    }
}
