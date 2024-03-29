package org.task.network;

import org.task.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("posts/")
    Call<List<User>> getUsers();

    @GET("posts/{id}")
    Call<User> getUserById(@Path("id") int id);
}
