package med.vol.api.DTO.paciente;

import jakarta.validation.constraints.NotNull;
import med.vol.api.DTO.DadosEndereco;

public record DadosAtualizacaoPaciente(
    @NotNull
    Long id,
    String nome,
    String email,
    String telefone,
    DadosEndereco endereco) {
}
