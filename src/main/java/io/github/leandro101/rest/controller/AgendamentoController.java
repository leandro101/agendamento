package io.github.leandro101.rest.controller;

import io.github.leandro101.domain.entity.Agendamento;
import io.github.leandro101.domain.exception.AgendamentoExistException;
import io.github.leandro101.domain.service.AgendamentoService;
import io.github.leandro101.domain.util.DataUtils;
import io.github.leandro101.rest.model.dto.AgendamentoDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    @ResponseBody
    @ApiOperation("Solicitar Agendamento")
    public ResponseEntity<Agendamento> save(@RequestBody AgendamentoDTO agendamento) throws AgendamentoExistException {
        return new ResponseEntity(agendamentoService.save(new Agendamento(agendamento.getId(), agendamento.getCliente(),
                DataUtils.stringToLocaDateTime(agendamento.getDataHora()) , agendamento.getObservacao(),
                agendamento.getServicos())),  HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("Remarcar data do agendamento")
    public ResponseEntity<Agendamento> remarcarData(@RequestBody AgendamentoDTO agendamento) {
        return new ResponseEntity(agendamentoService.update(new Agendamento(agendamento.getId(),
                agendamento.getCliente(), DataUtils.stringToLocaDateTime(agendamento.getDataHora()) ,
                agendamento.getObservacao(), agendamento.getServicos())),  HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    @ApiOperation("Listar todos agendamentos")
    public ResponseEntity<Agendamento> listarTodos() {
        return new ResponseEntity(agendamentoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("listarTodosByDataAndValor")
    @ResponseBody
    @ApiOperation("Listar todos agendamentos por data e valor")
    public ResponseEntity<Agendamento> listarTodosByDataValor() {
        return new ResponseEntity(agendamentoService.listarTodosByDataValor(), HttpStatus.OK);
    }

    @GetMapping("sumarizarAtendimento")
    @ResponseBody
    @ApiOperation("Sumarizar atendimento")
    public ResponseEntity<Agendamento> sumarizarAtendimento(@RequestParam("idCliente") Integer idCliente,
                                                            @RequestParam("dataHora") String dataHora) {
        return new ResponseEntity(agendamentoService.sumarizarAtendimento(idCliente, dataHora), HttpStatus.OK);
    }
}
