package med.vol.api.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.model.Especialidade;

public record DadosCadastroMedicos(

    @NotBlank
    String nome, 

    @NotBlank
    @Email
    String email, 

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm, 

    @NotBlank
    String telefone,

    @NotNull
    Especialidade especialidade,
    
    @NotNull
    @Valid
    DadosEndereco endereco) {
}