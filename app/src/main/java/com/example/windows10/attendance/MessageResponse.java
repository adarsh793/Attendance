package com.example.windows10.attendance;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows 10 on 10/15/2017.
 */

public class MessageResponse {

    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }
}
