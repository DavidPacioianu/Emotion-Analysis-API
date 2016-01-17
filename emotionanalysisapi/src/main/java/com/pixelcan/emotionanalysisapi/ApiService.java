package com.pixelcan.emotionanalysisapi;

import com.google.gson.JsonObject;
import com.pixelcan.emotionanalysisapi.models.FaceAnalysis;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by davidpacioianu on 1/12/16.
 */
public interface ApiService {

    @Headers("Content-Type: application/octet-stream")
    @POST("recognize")
    Call<FaceAnalysis[]> analyzePicture(
            @Header("Ocp-Apim-Subscription-Key") String subscriptionKey,
            @Body RequestBody image
    );

    @Headers("Content-Type: application/json")
    @POST("recognize")
    Call<FaceAnalysis[]> analyzePicture(
            @Header("Ocp-Apim-Subscription-Key") String subscriptionKey,
            @Body JsonObject url
    );
}
