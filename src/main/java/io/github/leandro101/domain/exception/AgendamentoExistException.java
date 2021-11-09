package io.github.leandro101.domain.exception;

public class AgendamentoExistException extends Exception{

    public AgendamentoExistException(String mensagem){
        super(mensagem, null);
    }
}
