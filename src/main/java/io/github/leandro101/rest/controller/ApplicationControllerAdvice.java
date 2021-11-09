package io.github.leandro101.rest.controller;

import io.github.leandro101.domain.exception.*;
import io.github.leandro101.rest.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiErros exceptionClienteNaoEncontrado(Exception ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(ClienteExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros exceptionCPFClienteCadastrado(Exception ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(ServicoNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiErros exceptionServicoNaoEncontrado(Exception ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(ServicoExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros exceptionServicoCadastrado(Exception ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(AgendamentoExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros exceptionAgendamentoCadastrado(Exception ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

}
