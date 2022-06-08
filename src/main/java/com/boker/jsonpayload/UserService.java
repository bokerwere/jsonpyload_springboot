package com.boker.jsonpayload;

import com.boker.jsonpayload.domain.User;
import com.boker.jsonpayload.repository.UserRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
@Service
public class UserService {
    private static String jsom_url="https://jsonplaceholder.typicode.com/users";
    @Autowired
   private UserRepository userRepository;
    public Iterable<User>list() {
        return userRepository.findAll();
    }
        public User sava(User user){
       return userRepository.save(user);
    }
    public Iterable<User>save(List<User> users) {
        return userRepository.saveAll(users);
    }
    @PostConstruct
     public void fetchJson() throws IOException, InterruptedException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest httpRequest=HttpRequest.newBuilder(URI.create(jsom_url)).build();
        HttpResponse response=client.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
         ObjectMapper mapper = new ObjectMapper();
         TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
        // InputStream inputStream = TypeReference.class.getResourceAsStream("resource/json/users.json");
         try {
             //List<User> users = mapper.readValue((URL) response.body(),typeReference);
             List<User> users = mapper.readValue(response.body().toString(),typeReference);
             save(users);
             System.out.println("Users Saved!");
         } catch (IOException e){
             System.out.println("Unable to save users: " + e.getMessage());
         }
     }
}
