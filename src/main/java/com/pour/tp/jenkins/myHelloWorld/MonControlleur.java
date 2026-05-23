package com.pour.tp.jenkins.myHelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonControlleur {

    @GetMapping("/")
    public String afficherMessage() {
        return "<h1>Félicitations ! Votre application Java tourne sur le Web !</h1>";
    }
}