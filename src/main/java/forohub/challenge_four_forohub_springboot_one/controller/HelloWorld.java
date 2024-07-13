package forohub.challenge_four_forohub_springboot_one.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envio")
public class HelloWorld {

    @PostMapping
    public String envio(@RequestBody String datos) {
        System.out.println(datos);
        return datos;
    }
}
