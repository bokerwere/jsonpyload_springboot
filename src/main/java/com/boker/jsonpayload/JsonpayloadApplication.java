package com.boker.jsonpayload;

import com.boker.jsonpayload.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsonpayloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonpayloadApplication.class, args);
	}

}
