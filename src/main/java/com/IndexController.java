package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        // Puedes agregar atributos si deseas
        model.addAttribute("mensaje", "Bienvenido a la página de inicio");
        
        // Retorna el nombre del archivo HTML (por ejemplo index.html en /templates)
        return "index";
    }
}
