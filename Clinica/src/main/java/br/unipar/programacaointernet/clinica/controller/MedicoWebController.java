package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Medico;
import br.unipar.programacaointernet.clinica.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicoWebController {
    private final MedicoService medicoService;

    public MedicoWebController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping(path = "/medicos")
    public String getAllMedico(Model model) {
        List<Medico> medicos = medicoService.getAll();
        model.addAttribute("medicos", medicos);
        return "medicos";
    }

    @PostMapping(path = "/medicos/save")
    public String saveMedico(Medico medico) {
        medicoService.save(medico);
        return "redirect:/medicos";
    }
}
