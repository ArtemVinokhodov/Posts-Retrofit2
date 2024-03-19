package org.task.model;

import org.task.controller.UserByIdController;
import org.task.controller.UsersController;
import org.task.view.UserByIdView;
import org.task.view.UsersView;

public class AppModel {

    public void readUsers() {
        UserModel model = new UserModel();
        UsersView view = new UsersView();
        UsersController controller = new UsersController(model, view);
        controller.getUsers();
    }

    public void readUserById() {
        UserModel model = new UserModel();
        UserByIdView view = new UserByIdView();
        UserByIdController controller = new UserByIdController(model, view);
        controller.getUserById();
    }
}
