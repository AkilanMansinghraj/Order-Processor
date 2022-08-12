package com.lowes.orderprocessor.aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class OrderAeropike {
    @Autowired
    static AerospikeClient client;

    public static JSONRecord getOrder(String orderId) throws JSONException {
        Policy policy = new Policy();
        Key key = new Key("test", "order", orderId);
        com.aerospike.client.Record result = client.get(policy, key);
        return new JSONRecord(result);
    }

    public static void putOrder(String orderId , JSONObject jsonObject){
        WritePolicy wp = new WritePolicy();
        if(client == null)
            client = new AerospikeClient("localhost",
                    3000);
        client.put(wp,
                new Key("test", "order",orderId),
                new Bin("orderData", jsonObject.toString())
        );
    }
}
