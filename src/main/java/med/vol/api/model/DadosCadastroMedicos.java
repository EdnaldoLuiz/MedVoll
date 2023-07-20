package med.vol.api.model;

public record DadosCadastroMedicos(
    String nome, 
    String email, 
    String crm, 
    Especialidade especialidade, 
    DadosEndereco endereco
    ) {
}