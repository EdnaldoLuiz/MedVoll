package med.vol.api.model;

public record DadosCadastroPacientes(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco
) {
}