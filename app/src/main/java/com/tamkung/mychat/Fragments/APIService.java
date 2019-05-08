package com.tamkung.mychat.Fragments;

import com.tamkung.mychat.Notification.MyResponse;
import com.tamkung.mychat.Notification.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAmPDiKfY:APA91bE_di7da1z5T8K3VD52jfycK1mzcfgBhnauZbZYLK5h5PpM_TiaLhTqOkbxuNNUtLBac7rWAY88x0P-dHjsKjTyG5tPEpO73U65O3jv474aJQ4pr3dVuYji3rErLVetS0_yHOIp"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
