package org.esfe.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String index (Model model){
        String saludo = "Hola, bienvenido";
        model.addAttribute("mensaje", saludo);
        return "home/index";
    }

    @GetMapping("/saludame")
    public String saludame (@RequestParam("nombre") String nombre, Model model){
       String saludo = "Hola, " + nombre + ",bienvenido";
       model.addAttribute("mensaje", saludo);
       return "home/saludame";
    }
    @GetMapping("/suma")
    public String  suma (){
        return "home/suma";
    }
    @PostMapping("/resultado")
    public String resultado (@RequestParam("num1") int num1,
                             @RequestParam("num2")int num2,Model model){
        int suma = num1+num2;
        model.addAttribute("resultado", suma);
        return "home/resultado";
    }

    @GetMapping("/conversion")
    public String showConversionForm() {
        // Muestra el formulario de conversión
        return "home/conversion";
    }

    @PostMapping("/total")
    public String total(@RequestParam("num1") double num1,
                        @RequestParam("num2") double num2, Model model) {
        double division = num1 / num2;
        model.addAttribute("total", division);
        return "home/total";
    }
}

