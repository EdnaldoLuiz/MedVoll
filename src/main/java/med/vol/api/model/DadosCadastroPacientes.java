package med.vol.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPacientes(

@NotBlank
String nome,

@NotBlank
@Email
String email,

@NotBlank
String telefone,

@NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") 
String cpf,

@NotNull
DadosEndereco endereco
) {
}