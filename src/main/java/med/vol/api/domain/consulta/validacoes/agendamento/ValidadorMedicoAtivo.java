package med.vol.api.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.domain.medico.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com medico");
        }
    }
    
}
