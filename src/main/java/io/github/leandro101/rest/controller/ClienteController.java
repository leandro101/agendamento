package io.github.leandro101.rest.controller;

import io.github.leandro101.domain.entity.Cliente;
import io.github.leandro101.domain.exception.ClienteExistsException;
import io.github.leandro101.domain.exception.ClienteNotFoundException;
import io.github.leandro101.domain.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation("Obter Cliente por ID")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) throws ClienteNotFoundException {
        return new ResponseEntity(clienteService.getCliente(id),  HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    @ApiOperation("Salvar Cliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) throws ClienteExistsException {
        return new ResponseEntity(clienteService.save(cliente),  HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation("Atualizar Cliente")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return new ResponseEntity(clienteService.update(cliente),  HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Deletar Cliente")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) throws ClienteNotFoundException {
        clienteService.delete(clienteService.getCliente(id));
        return new ResponseEntity(id,  HttpStatus.OK);
    }
}
