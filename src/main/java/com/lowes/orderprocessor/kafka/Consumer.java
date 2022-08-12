package com.lowes.orderprocessor.kafka;

import com.lowes.orderprocessor.aerospike.OrderAeropike;


import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class Consumer {
    @KafkaListener(topics = "quickstart-events", groupId = "group_id")
    public void consume(String message) throws Exception {
        System.out.println(String.format("#### -> Consumed message -> %s", message));
        String orderId = String.valueOf(new Random().nextInt(10000));
        JSONObject jsonObject = new JSONObject(message);
        jsonObject.put("orderid" , orderId);
        OrderAeropike.putOrder(orderId,jsonObject);
        JSONObject result = OrderAeropike.getOrder(orderId);
        System.out.println(result);
    }
}
