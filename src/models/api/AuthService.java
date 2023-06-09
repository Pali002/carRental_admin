package models.api;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AuthService {
    String host = "http://localhost:8000/api/";
    // String host = "http://[::1]:3000/";

    public AuthService() {
    }
    
    public void registry (String name, String email, String password) {
        String enpoint = "register";
        String url = this.host + enpoint;

        User userData = new User(name, email, password, password);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonData = gson.toJson(userData);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
    
        HttpClient http = new HttpClient();
        String result = http.post(url, jsonData, headers);
        System.out.println(http.getResponseCode());
        System.out.println(result);
    }
}
