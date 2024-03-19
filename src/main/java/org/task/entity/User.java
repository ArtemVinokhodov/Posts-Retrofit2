package org.task.entity;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private final int id;
    @SerializedName("userId")
    private final String userId;
    @SerializedName("title")
    private final String title;
    @SerializedName("body")
    private final String body;


    public User(int id, String userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "," +
                "\"userId\":\"" + userId + "\"," +
                "\"title\":\"" + title + "\"," +
                "\"body\":\"" + body + "\"}";
    }
}
