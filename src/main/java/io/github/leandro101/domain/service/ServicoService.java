package io.github.leandro101.domain.service;

import io.github.leandro101.domain.entity.Servico;
import io.github.leandro101.domain.exception.ServicoExistException;
import io.github.leandro101.domain.exception.ServicoNotFoundException;
import io.github.leandro101.domain.repository.Servicos;
import io.github.leandro101.domain.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private Servicos servicos;

    public Servico getServico(Integer codigo) throws ServicoNotFoundException {
        Servico servico = servicos.getServicoByCodigo(codigo);
        ExceptionUtils.throwsIfNull(servico, new ServicoNotFoundException("SERVICO NOT FOUND"));
        return servicos.getServicoByCodigo(codigo);
    }

    public Servico save(Servico servico) throws ServicoExistException {
        if(servicos.existsByDescricao(servico.getDescricao()))
            throw new ServicoExistException(" SERVICO JA CADASTRADO.");
        return servicos.save(servico);
    }

    public Servico update(Servico servico) {
        return servicos.save(servico);
    }

    public void delete(Servico cliente){
        servicos.delete(cliente);
    }
}
