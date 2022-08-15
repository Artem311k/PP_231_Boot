package ru.kuzmin.PP_231.servicies;


import ru.kuzmin.PP_231.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> showUsers();

    void deleteUserById(Long id);

    User getUserById(Long id);

    void updateUser(User userToUpdate);
}
