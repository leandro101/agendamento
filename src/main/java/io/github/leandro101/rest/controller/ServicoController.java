package io.github.leandro101.rest.controller;

import io.github.leandro101.domain.entity.Servico;
import io.github.leandro101.domain.exception.ServicoExistException;
import io.github.leandro101.domain.exception.ServicoNotFoundException;
import io.github.leandro101.domain.service.ServicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{codigo}")
    @ResponseBody
    @ApiOperation("Obter servico por codigo")
    public ResponseEntity<Servico> getServicoByCodigo(@PathVariable Integer codigo) throws ServicoNotFoundException {
        return new ResponseEntity(servicoService.getServico(codigo),  HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    @ApiOperation("Salvar servico")
    public ResponseEntity<Servico> save(@RequestBody Servico servico) throws ServicoExistException {
        return new ResponseEntity(servicoService.save(servico),  HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("Atualizar servico")
    public ResponseEntity<Servico> update(@RequestBody Servico servico) throws ServicoExistException {
        return new ResponseEntity(servicoService.update(servico),  HttpStatus.OK);
    }

    @DeleteMapping(value = "/{codigo}")
    @ApiOperation("Deletar servico")
    public ResponseEntity<Servico> delete(@PathVariable Integer codigo) throws ServicoNotFoundException {
        servicoService.delete(servicoService.getServico(codigo));
        return new ResponseEntity(codigo,  HttpStatus.OK);
    }
}
