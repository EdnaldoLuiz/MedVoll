package med.vol.api.DTO;

import med.vol.api.model.Paciente;

public record DadosListagemPaciente(

    String nome,
    String email) {

        public DadosListagemPaciente(Paciente paciente) {
            this(paciente.getNome(), paciente.getEmail());
        }

}
