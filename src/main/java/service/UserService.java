package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password){
        List<User> userList = userDAO.findUserByEmailAndPassword(username, password);
        if (userList.stream().findFirst().isPresent()){
            return userList.stream().findFirst().get();
        }
        return null;
    }

}
