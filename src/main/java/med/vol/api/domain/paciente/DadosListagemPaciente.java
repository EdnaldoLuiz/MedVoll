package med.vol.api.domain.paciente;

import med.vol.api.model.Paciente;

public record DadosListagemPaciente(

    String nome,
    String email) {

        public DadosListagemPaciente(Paciente paciente) {
            this(paciente.getNome(), paciente.getEmail());
        }

}
