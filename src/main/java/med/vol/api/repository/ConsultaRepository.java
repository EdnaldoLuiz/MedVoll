package med.vol.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import med.vol.api.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndDataBetween(
        Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
    
    boolean eexistsByMedicoIdAndData(Long idMedico, LocalDateTime data);
}
