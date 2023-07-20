package med.vol.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.vol.api.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
