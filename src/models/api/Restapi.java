package models.api;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// import models.Pro;
import models.Car;

public class Restapi {

    // public String getProductsAsString() {
    //     Pro pro = new Pro();
                
    //     String host = pro.getProperty("restapi.host");
    //     String endpoint = "cars";
    //     String urlStr = host + endpoint;
    //     HttpClient http = new HttpClient();
    //     String res = http.get(urlStr);
    //     return res;
    // }

    public ArrayList<Car> getCars() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        
        Car[] carsArray =  gson.fromJson(text, Car[].class);
        ArrayList<Car> carsList = 
            new ArrayList<>(Arrays.asList(carsArray));
        return carsList;
    }

    public String getProductsAsString() {

        HttpClient httpClient = new HttpClient();
        String host = "http://[::1]:3000/";
        String endpoint = "cars";
        String urlStr = host + endpoint;
        String res = httpClient.get(urlStr);

        return res;
    }

    public boolean checkUrl(String string) {
        return false;
    }
}
