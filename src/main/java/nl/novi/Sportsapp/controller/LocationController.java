//package nl.novi.Sportsapp.controller;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.ResponseBody;
//
//import org.springframework.web.bind.annotation.*;
//import java.io.IOException;
//import java.net.URLEncoder;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/test")
//public class LocationController {
//
//    @GetMapping
//    public String getGeocode(String address) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        String encodedAddress = URLEncoder.encode(address, "UTF-8");
//        Request request = new Request.Builder()
//                .url("https://maps.googleapis.com/maps/api/geocode/json?place_id=ChIJd8BlQ2BZwokRAFUEcm_qrcA\n" +
//                        "&key="
//                        + encodedAddress)
//                .get()
//                .addHeader("host", "maps.googleapis.com")
//                .addHeader("key", "AIzaSyAeL0sH-SHddn-Dq_m0k0vTcuYLEzS2X5M"/*  Use your API Key here */)
//                .build();
//        ResponseBody responseBody = client.newCall(request).execute().body();
//        return responseBody.string();
//    }
//
//}
