package br.unipar.programacaointernet.clinica.service;

import br.unipar.programacaointernet.clinica.model.Medico;
import br.unipar.programacaointernet.clinica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getAll() {
        return this.medicoRepository.findAll();
    }

    public Medico save(Medico medico) {
        return this.medicoRepository.save(medico);
    }
}
