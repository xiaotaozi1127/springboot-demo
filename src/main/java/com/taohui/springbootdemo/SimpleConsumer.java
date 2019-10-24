package com.taohui.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;

@Component
public class SimpleConsumer {
  private static final Logger logger = LoggerFactory.getLogger(SimpleProducer.class);

  @KafkaListener(id="test",topics={"test"})
  public void listen(String data){
    System.out.println("SimpleConsumer收到消息：" + data);
    logger.info(MessageFormat.format("SimpleConsumer收到消息：{0}", data));
  }
}
