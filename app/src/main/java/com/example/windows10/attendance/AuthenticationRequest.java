package com.example.windows10.attendance;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows 10 on 10/15/2017.
 */

public class AuthenticationRequest {

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
