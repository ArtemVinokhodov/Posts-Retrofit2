package org.task.model;

import org.task.entity.User;
import org.task.network.ApiClient;
import org.task.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

public class UserModel {

    // REST posts/
    public Optional<Response<List<User>>> fetchUsers() {

        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<List<User>> call = service.getUsers();
        Optional<Response<List<User>>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }

    // REST posts/{id}
    public Optional<Response<User>> fetchUserById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<User> call = service.getUserById(id);
        Optional<Response<User>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }
}
