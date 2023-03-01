package springboot.primerpaquete.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springboot.primerpaquete.web.app.models.Usuario;

import java.util.ArrayList;
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

    /*
        Utilizaremos un objeto Usuario para comenzar a compartir mediante clases POJO con el framework Spring
        Lo primero de todo sera declarar y inizializar el objeto usuario con sus parametros
        una vez hecho esto lo añadiremos al model y con el titulo sacaremos el usuario.
     */
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Francisco");
        usuario.setApellidos("Navarro");
        usuario.setEmail("fran@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo","El perfil del usuario: "+usuario.getNombre());
        return "perfil";
    }
    /*
      Utilizaremos una lista del objeto Usuario para comenzar a compartir mediante clases POJO con el framework Spring
      Lo primero de todo sera declarar y inizializar la lista usuarios con sus parametros
      una vez hecho esto lo añadiremos al model y con el titulo sacaremos el usuario.
   */
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Francisco","Navarro","fran@gmail.com"));
        usuarios.add(new Usuario("Francisco","Ureña","Francisco@gmail.com"));
        usuarios.add(new Usuario("Francisco","De Juan","de Juan@gmail.com"));
        model.addAttribute("titulo","Listado de usuarios");
        model.addAttribute("usuarios",usuarios);
        return "listar";
    }
}
