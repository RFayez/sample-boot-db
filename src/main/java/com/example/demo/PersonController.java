package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class PersonController {
    @Autowired
    private UserRepository userRepository;

    Random rand = new Random();
    int n = rand.nextInt(10);

    @GetMapping("/")
    public String welcome(){
        return "Ahlan Ahlan-->"+ n;
    }

    @GetMapping("/users")
    public List<User> users(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public String users(@RequestBody String userName){
        User user=new User();
        user.setName(userName);
        userRepository.save(user);
        return "Added";
    }
}
