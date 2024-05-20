package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Usuario;
import br.unipar.programacaointernet.clinica.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginWebController {
  private final UsuarioService usuarioService;

  public LoginWebController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping("/hello-world")
  public String helloWorld(
          @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return "Hello " + name + "!";
  }

  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @GetMapping("/bemvindo")
  public String bemvindo() {
    return "bemvindo";
  }

  @PostMapping("/login")
  public String login(
          @RequestParam("username") String username,
          @RequestParam("password") String password,
          HttpSession session,
          Model model
  ) {
    Usuario usuario = usuarioService.validarUsuario(username, password);
    if (username.equals("fernandinha") && password.equals("bart2004")) {
      session.setAttribute("usuarioLogado", username);
      return "redirect:/bemvindo";
    } else {
      model.addAttribute("erro", "Usuário ou senha inválidos");
      return "login";
    }
  }
}
