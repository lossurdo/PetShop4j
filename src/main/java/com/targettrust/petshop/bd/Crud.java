package com.targettrust.petshop.bd;

import java.util.List;

public interface Crud<T> {

    void salvar(T bean);
    void excluir(T bean);
    T consultar(T bean);
    void alterar(T bean);
    List<T> pesquisar(T bean);
    
}
