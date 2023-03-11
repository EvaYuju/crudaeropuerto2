package com.example.crudAeropuerto.Controller;

import com.example.crudAeropuerto.Entity.Administrador;
import com.example.crudAeropuerto.Entity.Usuario;
import com.example.crudAeropuerto.Entity.Vuelo;
import com.example.crudAeropuerto.Repository.AdminRepo;
import com.example.crudAeropuerto.Repository.UsuarioRepo;
import com.example.crudAeropuerto.Repository.VueloRepo;
import com.example.crudAeropuerto.Service.AdminService;
import com.example.crudAeropuerto.Service.AdminServiceIMPL.AdminServiceIMPL;
import com.example.crudAeropuerto.Service.UsuarioService;
import com.example.crudAeropuerto.Service.UsuarioServiceIMPL.UsuarioServiceIMPL;
import com.example.crudAeropuerto.Service.VueloService;
import com.example.crudAeropuerto.Service.VueloServiceIMPL.VueloServiceIMPL;
import com.mysql.cj.QueryAttributesBindings;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("CrudRepo")
public class Controlador {

    @Autowired
    private VueloServiceIMPL impl;

    @Autowired
    private UsuarioService userService;

    @Autowired
    private VueloRepo vueloRepo;

    @Autowired
    private UsuarioServiceIMPL implUsu;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private AdminServiceIMPL implAdmin;

    @Autowired
    private AdminRepo adminRepo;

    Usuario loggedUser;

    // Login
    @GetMapping("/")
    public String login() {
        return "userLogin";
    }

    @PostMapping({"/userLogin"})
    public String authenticateUser(@RequestParam String nombre, @RequestParam String pwdUsuario) {
        boolean isAuthenticated = userService.authenticateUser(nombre, pwdUsuario);
        if (isAuthenticated) {
            List<Usuario> usuarios = usuarioRepo.findAll();
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuario) && usuario.getPwdUsuario().equals(pwdUsuario)) {
                    loggedUser = usuario;
                }
            }
            if (nombre.equals("admin") && pwdUsuario.equals("admin")) {
                return "creaVuelo";
            } else {
                return "vuelos";
            }
        } else {
            return "login?error";
        }
    }


    // Controlador para vuelos
    @RequestMapping(value = "/ConsultarVuelos")
    public String ConsultarVuelos(Model model){
        List<Vuelo> listaVuelos= vueloRepo.findAll();
        model.addAttribute("listaVuelos", listaVuelos);
        return "vuelos";
    }

    @RequestMapping(value = "/CrearVuelos")
    public String CreaVuelos(Model model){
        return "creaVuelos";
    }

        @PostMapping(value = "/CrearVuelos")
    public String CrearVuelos(@ModelAttribute("vuelo") Vuelo vuelo, Model model){
        Vuelo vueloCreado = vueloRepo.save(vuelo);
        model.addAttribute("vuelo", vueloCreado);
        return "vueloCreado.html";
    }

    @GetMapping(value = "/ModificarVuelos")
    public String ModiVuelos(@RequestParam int numVuelo, Model model){
        Vuelo vuelo = impl.BuscaVuelo(numVuelo);
        model.addAttribute("vuelo", vuelo);
        return "modificarVuelo";
    }



    @GetMapping(value = "/BuscaVuelo/{numVuelo}")
    public ResponseEntity<?> BuscaVuelo (@PathVariable int numVuelo){
        Vuelo vuelo = impl.BuscaVuelo(numVuelo);
        return ResponseEntity.ok(vuelo);
    }

    @GetMapping(value = "/ElimnVuelo")
    public String ElimnVuelo(@RequestParam int numVuelo){
        Vuelo vuelo = impl.BuscaVuelo(numVuelo);
        vueloRepo.delete(vuelo);
        return "vuelos";
    }


    // Controlador para Usuarios
    @GetMapping(value = "/ConsultarUsuarios")
    public String ConsultarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "Usuarios";
    }

    @RequestMapping(value = "/CrearUsuarios")
    public String CreaUsuarios(Model model){
        return "creaUsuarios";
    }

    @PostMapping(value = "/CrearUsuarios")
    public String CrearUsuarios(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario usuarioCreado = usuarioRepo.save(usuario);
        model.addAttribute("usuario", usuarioCreado);
        return "usuarioCreado.html";
    }

    @GetMapping(value = "/ModificarUsuarios")
    public String ModiUsuario(@RequestParam int idUsuario, Model model){
        Usuario usuario = implUsu.BuscaUsuario(idUsuario);
        model.addAttribute("usuario", usuario);
        return "modificarUsuario";
    }


    @GetMapping(value = "/ElimnUsuarios")
    public String EliminarUsuario(@RequestParam int idUsuario){
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        usuarioRepo.delete(usuario);
        return "usuarios";
    }

    // Controlador para Administradores
    @RequestMapping(value = "/ConsultarAdministradores")
    public String ConsultarAdministradores(Model model){
        List<Administrador> listaAdministradores = adminRepo.findAll();
        model.addAttribute("listaAdministradores",listaAdministradores);
        return "Administrador"; // *
    }

    @RequestMapping(value = "/CrearAdministrador")
    public String CrearAdministrador(Model model){
        return "creaAdministradores";
    }

    @PostMapping(value = "/CrearAdministrador")
    public String CrearAdministrador(@ModelAttribute("administrador") Administrador administrador, Model model){
        Administrador administradorCreado = adminRepo.save(administrador);
        model.addAttribute("administrador", administradorCreado);
        return "administradorCreado.html";
    }

    @GetMapping(value = "/ModificarAdministradores")
    public String ModiAdministrador(@RequestParam int id, Model model){
        Administrador administrador = implAdmin.BuscaAdministrador(id);
        model.addAttribute("administrador", administrador);
        return "modificarAdministrador";
    }


    @GetMapping(value = "/ElimnAdministradores")
    public String EliminarAdministrador(@RequestParam int id){
        Administrador administrador = adminRepo.findById(id).orElse(null);
        adminRepo.delete(administrador);
        return "Administrador";
    }

    

}
