package io.github.leandro101.domain.service;

import io.github.leandro101.domain.entity.Cliente;
import io.github.leandro101.domain.exception.ClienteExistsException;
import io.github.leandro101.domain.exception.ClienteNotFoundException;
import io.github.leandro101.domain.repository.Clientes;
import io.github.leandro101.domain.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private Clientes clientes;

    public Cliente getCliente(Integer id) throws ClienteNotFoundException {
        Cliente cliente = clientes.getClienteById(id);
        ExceptionUtils.throwsIfNull(cliente, new ClienteNotFoundException("CLIENTE NOT FOUND"));
        return clientes.getClienteById(id);
    }

    public Cliente save(Cliente cliente) throws ClienteExistsException {
        if(clientes.existsByCpf(cliente.getCpf()))
            throw new ClienteExistsException("ESSE CPF JA EXISTE NA BASE DE DADOS");
        return clientes.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clientes.save(cliente);
    }

    public void delete(Cliente cliente){
        clientes.delete(cliente);
    }

}
