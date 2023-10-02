package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.consulta.AgendaDeConsulta;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;
import med.vol.api.domain.consulta.DadosDetalhamentoConsulta;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private AgendaDeConsulta agenda;

    @Transactional
    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        agenda.agendar(dados);
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }
    
}