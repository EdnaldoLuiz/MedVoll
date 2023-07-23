package med.vol.api.DTO.paciente;

import med.vol.api.model.Endereco;
import med.vol.api.model.Paciente;

public record DadosDetalhamentoPaciente(String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }

}
