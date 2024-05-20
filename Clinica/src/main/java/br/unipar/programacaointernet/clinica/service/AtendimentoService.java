package br.unipar.programacaointernet.clinica.service;

import br.unipar.programacaointernet.clinica.model.Atendimento;
import br.unipar.programacaointernet.clinica.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {
    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<Atendimento> getAll() {
        return this.atendimentoRepository.findAll();
    }

    public Atendimento save(Atendimento atendimento) {
        return this.atendimentoRepository.save(atendimento);
    }
}
