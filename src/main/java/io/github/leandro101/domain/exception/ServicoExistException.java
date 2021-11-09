package io.github.leandro101.domain.exception;

public class ServicoExistException extends Exception {

    public ServicoExistException(String mensagem){
        super(mensagem, null);
    }
}
