package org.task.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.task.entity.User;
import org.task.model.UserModel;
import org.task.utils.AppStarter;
import org.task.utils.Constants;
import org.task.view.UsersView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersController {

    UserModel model;
    UsersView view;

    public UsersController(UserModel model, UsersView view) {
        this.model = model;
        this.view = view;
    }

    public void getUsers() {
        view.getOutput(readUsers());
        AppStarter.startApp();
    }

    private String readUsers() {
        Optional<Response<List<User>>> optional = model.fetchUsers();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {

            Gson gson = new Gson();
            List<User> users = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<List<User>>() {}.getType());

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;

            for (User user : users) {
                str = cnt.incrementAndGet() + ") "+ "\n" +
                        "- id " + user.getId() + "\n" +
                        "- Title " + user.getTitle() + "\n" +
                        "- UserId " + user.getUserId() + "\n" +
                        "- Body " + user.getBody() + "\n";
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}
