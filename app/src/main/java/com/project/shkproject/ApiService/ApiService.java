package com.project.shkproject.ApiService;

import com.project.shkproject.Entity.HK11;
import com.project.shkproject.Entity.UpdateProfileRequest;
import com.project.shkproject.Entity.User;
import com.project.shkproject.Request.HK11Request;
import com.project.shkproject.Request.LoginRequest;
import com.project.shkproject.Request.RegisterRequest;
import com.project.shkproject.Response.DefaultResponse;
import com.project.shkproject.Response.HK11Response;
import com.project.shkproject.Response.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("register-user")
    Call<RegisterRequest> registerUser(@Body RegisterRequest registerRequest);

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @GET("hK1_1s")
    Call<DefaultResponse> getAllHK11(@Header("Authorization") String token);

    @POST("hK1_1s")
    Call<HK11Response> createHK11(@Header("Authorization") String token, @Body HK11Request request);

    @PATCH("/update-profile/{userId}")
    Call<User> updateProfile(@Header("Authorization") String token, @Body UpdateProfileRequest updateProfileRequest);

    @GET("view-profile/{id}")
    Call<User> getUserById(@Header("Authorization") String token, @Path("id") Long id);

//
//    @GET("/komoditas-hk1_1/{komoditas}")
//    Call<List<HK11>> getAllHK11(@Header("Authorization") String token);
//
////    @GET("/responden-hk1_1/{responden}")
////    Call<HK11> getHK11 (@Path("id") Long id);

}
