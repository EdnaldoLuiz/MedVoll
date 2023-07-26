package med.vol.api.domain.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.endereco.DadosEndereco;

public record DadosCadastroPacientes(

    @NotBlank(message = "{nome.obrigatorio}")
    String nome,

    @Email
    @NotBlank(message = "{email.obrigatorio}")
    String email,

    @NotBlank(message = "{telefone.obrigatorio}")
    String telefone,

    @NotBlank(message = "{cpf.obrigatorio}") 
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") 
    String cpf,

    @NotNull(message = "{endereco.obrigatorio}")
    DadosEndereco endereco) {}