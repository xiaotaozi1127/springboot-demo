package com.taohui.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class SimpleProducer {

  private static final Logger logger = LoggerFactory.getLogger(SimpleProducer.class);

  @Autowired
  private KafkaTemplate<Object, Object> kafkaTemplate;

  public void sendMessage(String data){
    logger.info(MessageFormat.format("开始向Kafka推送数据：{0}", data));

    try {
      kafkaTemplate.sendDefault(data);
      logger.info("推送数据成功！");
    } catch (Exception e) {
      logger.error(MessageFormat.format("推送数据出错，data:{0}"
              , data));
    }
  }


}
