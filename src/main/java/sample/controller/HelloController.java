package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sample.entity.Sample;
import sample.repository.SampleRepository;
import sample.service.HelloService;
import sample.service.Hoge;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    public SampleRepository sampleRepository;

    @Autowired
    public HelloService helloService;

    /*
    @RequestMapping(value="/sample", method=RequestMethod.GET)
    public String sample() {
        Sample sample = sampleRepository.findOne(1);
        //return sample.toString();
        return("OK");
    }
    */

    @RequestMapping(method= RequestMethod.POST)
    @Transactional
    public Sample create(@RequestBody Sample param) {
        sampleRepository.save(param);
        return param;
    }

    /*
    @RequestMapping(method= RequestMethod.POST)
    public Hoge hello(@RequestBody Hoge param) {
        System.out.println(param);

        Hoge hoge = new Hoge();
        hoge.id=3;
        hoge.name="hogehoge";

        return hoge;
    }
    */

    /**
     * method属性でHTTPメソッドとマッピングできる。
     *
     */
    @RequestMapping(method=RequestMethod.GET)
    public String getHello() {
        return "Hello Get";
    }

    /**
     * value属性にパスを設定するとこの場合では「/hello/postpath」にマッピングされる。
     *
     */
    @RequestMapping(value="/postpath", method=RequestMethod.POST)
    public String postHello() {
        return "2nd post method!!";
    }


    @RequestMapping(value="/world", method=RequestMethod.GET)
    public String getWorld() {
        return "Hello World!!";
    }
    /**
     * value属性によるパスの定義に「{}」をで囲ったパラメータを定義し、メソッドの引数に同名の変数を
     * @PathVariableで注釈を入れて定義する。
     *
     */
    @RequestMapping(value="/{id}/{name}", method=RequestMethod.GET)
    public String getMethod(@PathVariable int id, @PathVariable String name) {
        return "ID=" + id + ", Name=" + name;
    }
}
