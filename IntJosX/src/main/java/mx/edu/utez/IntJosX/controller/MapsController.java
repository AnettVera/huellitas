package mx.edu.utez.IntJosX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapsController {

    @GetMapping("/ShowMap")
    public String viewMap(Model model) {
        model.addAttribute("apiKey", "AIzaSyAFqc82sJSxb4czh5TPUobEUYW8An0Z-qA");
        return "map";
    }
}
