package med.vol.api.controller;

import jakarta.validation.constraints.NotNull;
import med.vol.api.DTO.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}