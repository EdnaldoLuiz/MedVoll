package med.vol.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.repository.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(pacienteAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente excluido");
        }
    }
    
}
