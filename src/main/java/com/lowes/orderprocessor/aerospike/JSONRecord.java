package com.lowes.orderprocessor.aerospike;



import com.aerospike.client.Record;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;


/**
 * JSONRecord is used to convert an Aerospike Record
 * returned from the cluster to JSON format
 *
 */
@SuppressWarnings("serial")
public class JSONRecord extends JSONObject {
    @SuppressWarnings("unchecked")
    public JSONRecord(Record record) throws JSONException {
        put("generation", record.generation);
        put("expiration", record.expiration);
        put("bins", new JSONObject(record.bins));
    }
}
