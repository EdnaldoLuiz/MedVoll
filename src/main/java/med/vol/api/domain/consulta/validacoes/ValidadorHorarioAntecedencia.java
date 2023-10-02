package med.vol.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import med.vol.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaMinuto = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaMinuto < 30) {
            throw new ValidacaoException("Minimo de 30m de antecendecia");
        }
    }
    
}
