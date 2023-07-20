package med.vol.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.vol.api.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
