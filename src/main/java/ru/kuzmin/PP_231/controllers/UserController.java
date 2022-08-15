package ru.kuzmin.PP_231.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuzmin.PP_231.models.User;
import ru.kuzmin.PP_231.servicies.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping() //+
    public String index(Model model) {
        model.addAttribute("allUsers", userService.showUsers());
        return "users/index";
    }


    @GetMapping("/new") //+
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "users/new";
    }

    @PostMapping("/save") //+
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}") //+
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userToShow", userService.getUserById(id));
        return "users/show";
    }

    @GetMapping("/{id}/update") //+
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userToShow", userService.getUserById(id));
        return "users/update";
    }

    @PatchMapping("/{id}/update") //+
    public String updateUser(@ModelAttribute("userToUpdate") User userToUpdate) {
        userService.updateUser(userToUpdate);
        return "redirect:/users/" + userToUpdate.getId();
    }

    @DeleteMapping("{id}/delete") //+
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
