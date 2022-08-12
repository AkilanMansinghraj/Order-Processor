package com.lowes.orderprocessor;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class OrderprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderprocessorApplication.class, args);
	}

	@Bean
	public AerospikeClient asClient() throws AerospikeException {

		return new AerospikeClient("localhost",
				3000);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		return new MultipartConfigElement("");
	}
}
