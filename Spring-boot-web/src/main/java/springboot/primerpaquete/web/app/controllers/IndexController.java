package springboot.primerpaquete.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Utilizamos el @Controller para establecer el controlador
@Controller
public class IndexController {
    /**
     * Mapeamos el meotodo con @RequestMapping(ruta, method = "Metodo"), @GetMapping("ruta") o PostMapping({"ruta1","ruta2"}) como si fuese un array.
     *
     * @param model
     * @return
     */
    @GetMapping({"/index","/","/home"})
    public String index(Model model){
        // añadimos al model(K,V) y lo enviamos al HMTL index.
        model.addAttribute("titulo","hola Springboot!");
        return "index";
    }
}
