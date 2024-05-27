package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BemVindoWebController {
    private final UsuarioService usuarioService;

    public BemVindoWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/bemvindo")
    public String bemvindo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("usuarioLogadoUsername");
        String senha = (String) session.getAttribute("usuarioLogadoSenha");

        boolean isAdmin = usuarioService.isAdmin(username, senha);
        model.addAttribute("isAdmin", isAdmin);

        return "bemvindo";
    }

    @PostMapping("/bemvindo")
    public String bemvindo(@RequestParam("button") String button) {
        switch (button) {
            case "usuarios":
                return "redirect:/usuarios";
            case "medicos":
                return "redirect:/medicos";
            case "pacientes":
                return "redirect:/pacientes";
            case "atendimentos":
                return "redirect:/atendimentos";
            default:
                return "redirect:/bemvindo";
        }
    }
}
