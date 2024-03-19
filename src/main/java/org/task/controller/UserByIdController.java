package org.task.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.task.entity.User;
import org.task.model.UserModel;
import org.task.utils.AppStarter;
import org.task.utils.Constants;
import org.task.view.UserByIdView;
import retrofit2.Response;

import java.util.Optional;

public class UserByIdController {

    UserModel model;
    UserByIdView view;

    public UserByIdController(UserModel model, UserByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getUserById() {
        view.getOutput(readUserById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readUserById(int id) {
        Optional<Response<User>> optional = model.fetchUserById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            User user = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<User>() {}.getType());
            return "ID: " + user.getId() + "\n" +
                    "- Title: " + user.getTitle() + "\n" +
                    "- UserId: " + user.getUserId() + "\n" +
                    "- Body: "  + user.getBody() + "\n";
        }
    }
}
