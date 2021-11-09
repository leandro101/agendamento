package io.github.leandro101.domain.exception;

public class ClienteNotFoundException extends Exception{
    public ClienteNotFoundException(String mensagem){
        super(mensagem, null);
    }
}
