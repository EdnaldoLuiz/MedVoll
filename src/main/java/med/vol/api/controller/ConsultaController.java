package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.consulta.AgendaDeConsultas;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.domain.consulta.DadosDetalhamentoConsulta;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @Transactional
    @PostMapping
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }
    
}
