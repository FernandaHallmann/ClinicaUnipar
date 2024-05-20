package br.unipar.programacaointernet.clinica.repository;

import br.unipar.programacaointernet.clinica.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>  {
}
