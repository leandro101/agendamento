package io.github.leandro101.domain.exception;

public class ClienteExistsException extends Exception{

    public ClienteExistsException(String mensagem){
        super(mensagem, null);
    }
}
