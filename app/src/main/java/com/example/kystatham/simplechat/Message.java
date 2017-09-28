package com.example.kystatham.simplechat;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Jayson on 9/27/2017.
 */

@ParseClassName("Message")
public class Message extends ParseObject{
    public static final String USER_ID_KEY = "userId";
    public static final String BODY_KEY = "body";

    public String getUserId() {
        return getString(USER_ID_KEY);
    }

    public String getBody() {
        return getString(BODY_KEY);
    }

    public void setUserId(String userId) {
        put(USER_ID_KEY, userId);
    }

    public void setBody(String body) {
        put(BODY_KEY, body);
    }
}
