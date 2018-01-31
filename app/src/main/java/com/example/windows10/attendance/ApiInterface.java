package com.example.windows10.attendance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows 10 on 10/10/2017.
 */

public interface ApiInterface {

    @POST(NetworkURL.LOGIN)
    Call<MessageResponse> login(@Body AuthenticationRequest body);

    @POST(NetworkURL.REGISTRATION)
    Call<MessageResponse> registration(@Body AuthenticationRequest body);

}
