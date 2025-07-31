package br.com.alura.screematch_spring.service;

public abstract interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
