package com.targettrust.petshop.rn;

import com.targettrust.petshop.bd.Crud;
import com.targettrust.petshop.bean.Cliente;
import com.targettrust.petshop.componente.ValidacaoRNException;
import java.util.List;

public class ClienteRNVal implements Crud<Cliente> {

    @Override
    public void salvar(Cliente bean) {
        if (bean == null) {
            throw new ValidacaoRNException("Parâmetros obrigatórios não foram informados");
        }
        if (bean.getId() == null) {
            throw new ValidacaoRNException("Campo Código deve ser preenchido");
        }
        if (bean.getAnimal() == null || "".equals(bean.getAnimal())) {
            throw new ValidacaoRNException("Campo Animal deve ser preenchido");
        }
        if (bean.getProprietario() == null || "".equals(bean.getProprietario())) {
            throw new ValidacaoRNException("Campo Proprietário deve ser preenchido");
        }
        if (bean.getTelefone() == null || "".equals(bean.getTelefone())) {
            throw new ValidacaoRNException("Campo Telefone deve ser preenchido");
        }
    }

    @Override
    public void excluir(Cliente bean) {
        // DEVE SER IMPLEMENTADO
    }

    @Override
    public Cliente consultar(Cliente bean) {
        // DEVE SER IMPLEMENTADO
        return null;
    }

    @Override
    public void alterar(Cliente bean) {
        salvar(bean); // mesma regra do salvar        
    }

    @Override
    public List<Cliente> pesquisar(Cliente bean) {
        // DEVE SER IMPLEMENTADO
        return null;
    }
}
