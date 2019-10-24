package com.taohui.springbootdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
  @GetMapping("/")
  public String hello(){
    return "hello world";
  }

  @Autowired
  private SimpleProducer producer;

  @RequestMapping("/send")
  public String send() throws JsonProcessingException {
    ObjectMapper Obj = new ObjectMapper();

    Country c = new Country("China", 111);

    String jsonStr = Obj.writeValueAsString(c);
    producer.sendMessage(jsonStr);

    return "发送数据【" + jsonStr + "】成功！";
  }
}
