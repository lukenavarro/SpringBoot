package springboot.primerpaquete.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
        //Podemos hacerlos con ModelMap y con Map(Java Base) con el map utilizaremos el map.put y indicarle los tipos de la Clave Valor
        // añadimos al model(K,V) y lo enviamos al HMTL index.
        model.addAttribute("titulo","hola Springboot con Model!");
        return "index";
    }
    //Uso con Model Map Hereda del Mapa de Java.
    @GetMapping("/ModelMap")
    public String index(ModelMap model){
        model.addAttribute("titulo","Hola SpringBoot con ModelMap!");
        return "index";
    }
    // Uso con el Map
    @GetMapping("/map")
    public String index(Map<String,Object> map){
        map.put("titulo","Hola Springboot con Map!");
        return "index";
    }
    /*
        Otra forma de hacer lo anterior es con el model and view
        Para ello devolveremos un objeto ModelAndView
        En este añadiremos el objeto K V
        Añadimos el SetViewName con el index.html
        Lo devolvemos para sacarlo por pantalla.
     */
    @GetMapping("/ModelAndView")
    public ModelAndView index(ModelAndView mv){
        mv.addObject("titulo","Hola Springboot con Model And view!");
        mv.setViewName("index");
        return mv;
    }
}
