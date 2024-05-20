package br.unipar.programacaointernet.clinica.service;

import br.unipar.programacaointernet.clinica.model.Paciente;
import br.unipar.programacaointernet.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getAll() {
        return this.pacienteRepository.findAll();
    }

    public Paciente save(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }
}
