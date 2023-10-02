package med.vol.api.domain.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.vol.api.domain.consulta.validacoes.ValidacaoException;
import med.vol.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.vol.api.model.Consulta;
import med.vol.api.model.Medico;
import med.vol.api.repository.ConsultaRepository;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.repository.PacienteRepository;

@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public void agendar(DadosAgendamentoConsulta dados) {
        if(!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id informado inexistente");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id informado inexistente");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade e obrigatoria");
        }

        return medicoRepository.escolherMedicoAleatoriaLivreNaData(dados.especialidade(), dados.data());
    }
    
}
