package com.yzh.springcloud.service.impl;

import com.yzh.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author simple
 */
@EnableBinding(Source.class) // 定义消息的推送源
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid.getBytes()).build());
        System.out.println("------ send uuid: " + uuid);
        return "send message";
    }
}
