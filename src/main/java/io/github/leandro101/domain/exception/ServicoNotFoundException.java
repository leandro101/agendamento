package io.github.leandro101.domain.exception;

public class ServicoNotFoundException extends Exception{

    public ServicoNotFoundException(String mensagem){
        super(mensagem, null);
    }

}
