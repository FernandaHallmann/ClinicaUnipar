package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Atendimento;
import br.unipar.programacaointernet.clinica.model.Medico;
import br.unipar.programacaointernet.clinica.model.Paciente;
import br.unipar.programacaointernet.clinica.service.AtendimentoService;
import br.unipar.programacaointernet.clinica.service.MedicoService;
import br.unipar.programacaointernet.clinica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AtendimentoWebController {

    private final AtendimentoService atendimentoService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AtendimentoWebController(AtendimentoService atendimentoService, MedicoService medicoService, PacienteService pacienteService) {
        this.atendimentoService = atendimentoService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping(path = "/atendimentos")
    public String getAllAtendimento(Model model) {
        List<Atendimento> atendimentos = atendimentoService.getAll();
        List<Medico> medicos = medicoService.getAll();
        List<Paciente> pacientes = pacienteService.getAll();
        model.addAttribute("atendimentos", atendimentos);
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        return "atendimentos";
    }

    @PostMapping(path = "/atendimentos/save")
    public String saveAtendimento(Atendimento atendimento) {
        atendimentoService.save(atendimento);
        return "redirect:/atendimentos";
    }
}
