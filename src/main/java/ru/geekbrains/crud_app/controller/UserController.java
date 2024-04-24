package ru.geekbrains.crud_app.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.crud_app.model.User;
import ru.geekbrains.crud_app.service.UserService;

import java.util.List;


@Controller
@Log
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        log.info("(@Log)" + (users.isEmpty() ?  "users is empty":users.toString()));
        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info("(@Log)User-create: " + user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        log.info("(@Log)User-create: " + user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        log.info("(@Log)User-delete: " + userService.getUser(id));
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String getUser(Model model,@PathVariable("id") int id){
        User user = userService.getUser(id);
        log.info("(@Log)User-get: " + user);
        model.addAttribute("user",user);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        log.info("(@Log)User-update: " + user);
        return "redirect:/users";
    }


}
