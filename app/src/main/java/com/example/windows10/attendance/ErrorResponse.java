package com.example.windows10.attendance;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows 10 on 10/15/2017.
 */

public class ErrorResponse {

    @SerializedName("error")
    String error;

    public String getError() {
        return error;
    }
}
