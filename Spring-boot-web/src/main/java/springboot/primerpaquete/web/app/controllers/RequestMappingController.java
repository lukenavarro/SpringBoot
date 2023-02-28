package springboot.primerpaquete.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Con el request Mapping establecemos como ruta de 1º nivel /api
@RequestMapping("/api")
public class RequestMappingController {
    //Mientras que con el Get Mapping utilizamos /requestmapping como ruta 2º nivel
    @GetMapping("/RequestMapping")
    public String RequestMapping(Model model){
        model.addAttribute("idTitulo","RestMapping");
        model.addAttribute("idContenido","Comprobacion RequestMapping con un Get!");
        return "RequestMapping";
    }
}
