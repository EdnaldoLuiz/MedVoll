package med.vol.api.domain.medico;

import med.vol.api.model.Especialidade;
import med.vol.api.model.Medico;

public record DadosListagemMedico(

    String nome, 
    String email, 
    String crm, 
    Especialidade especialidade) {

        public DadosListagemMedico(Medico medico) {
            this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
        }

}
