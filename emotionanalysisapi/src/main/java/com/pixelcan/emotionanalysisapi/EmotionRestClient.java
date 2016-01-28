package com.pixelcan.emotionanalysisapi;

import android.content.Context;
import android.net.Uri;

import com.google.gson.JsonObject;
import com.pixelcan.emotionanalysisapi.models.FaceAnalysis;
import com.pixelcan.emotionanalysisapi.util.FileUtils;
import com.pixelcan.emotionanalysisapi.util.NetworkUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by David Pacioianu on 1/12/16.
 */
public class EmotionRestClient {

    private static final String API_BASE_URL = "https://api.projectoxford.ai/emotion/v1.0/";
    private ApiService apiService = null;
    private String subscriptionKey;
    private Context context;

    private static EmotionRestClient client = null;

    public static EmotionRestClient getInstance() {
        return client;
    }

    public synchronized static void init(Context context, String subscriptionKey){
        if( client == null ){
            client = new EmotionRestClient(context, subscriptionKey);
        }
    }

    private EmotionRestClient(Context context, String subscriptionKey) {
        this.context = context;
        this.subscriptionKey = subscriptionKey;

        // Retrofit setup
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Service setup
        apiService = retrofit.create(ApiService.class);
    }
    
    public void detect(byte[] data,final ResponseCallback callback){
        
        RequestBody requestBody = RequestBody
                .create(MediaType.parse("application/octet-stream"), data);

        Call<FaceAnalysis[]> call = apiService.analyzePicture(subscriptionKey, requestBody);
        call.enqueue(new Callback<FaceAnalysis[]>() {
            @Override
            public void onResponse(Response<FaceAnalysis[]> response) {
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    FaceAnalysis[] result = response.body();
                    if (result != null) {
                        callback.onSuccess(result);
                    } else {
                        callback.onError(response.message());
                    }
                } else {
                    //request not successful (like 400,401,403 etc)
                    try {
                        callback.onError(response.errorBody().string());
                    } catch (IOException e) {
                        callback.onError(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
    
    public void detect(Bitmap bmp, final ResponseCallback callback){
        if (!NetworkUtils.hasInternetConnection(context)){
            callback.onError(context.getString(R.string.no_internet_connection));
            return;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();
        detect(data,callback);
    }
    public void detect(Uri uri, final ResponseCallback callback){
        if (!NetworkUtils.hasInternetConnection(context)){
            callback.onError(context.getString(R.string.no_internet_connection));
            return;
        }

        // convert the image to bytes array
        byte[] data;

        try {
            data = FileUtils.toBinary(uri);
        } catch (Exception e) {
            callback.onError(e.getMessage());
            return;
        }
        detect(data,callback);
    }

    public void detect(String url, final ResponseCallback callback){
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("url", url);

        Call<FaceAnalysis[]> call = apiService.analyzePicture(subscriptionKey, requestBody);
        call.enqueue(new Callback<FaceAnalysis[]>() {
            @Override
            public void onResponse(Response<FaceAnalysis[]> response) {
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    FaceAnalysis[] result = response.body();
                    if (result != null) {
                        callback.onSuccess(result);
                    } else {
                        callback.onError(response.message());
                    }
                } else {
                    //request not successful (like 400,401,403 etc)
                    try {
                        callback.onError(response.errorBody().string());
                    } catch (IOException e) {
                        callback.onError(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
