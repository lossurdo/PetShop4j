package com.targettrust.petshop.rn;

import com.targettrust.petshop.bd.CrudBD;
import com.targettrust.petshop.bean.Servico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoRN extends CrudBD<Servico> {

    @Override
    public void salvar(Servico bean) {
        // NÃO É NECESSÁRIO IMPLEMENTAR PARA ESTE EXERCÍCIO
    }

    @Override
    public void excluir(Servico bean) {
        // NÃO É NECESSÁRIO IMPLEMENTAR PARA ESTE EXERCÍCIO
    }

    @Override
    public Servico consultar(Servico bean) {
        Servico s = null;
        Connection conn = null;        
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM servico WHERE id=").append(bean.getId());
            
            ResultSet rs = conn.createStatement().executeQuery(sql.toString());
            while(rs.next()) {
                s = new Servico();
                s.setId(rs.getInt("id"));
                s.setTitulo(rs.getString("titulo"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
        return s;
    }

    @Override
    public void alterar(Servico bean) {
        // NÃO É NECESSÁRIO IMPLEMENTAR PARA ESTE EXERCÍCIO
    }

    @Override
    public List<Servico> pesquisar(Servico bean) {
        List<Servico> lista = new ArrayList<Servico>();
        Connection conn = null;        
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM servico ");
            
            if(bean!=null && bean.getId()!=null) {
                sql.append(" WHERE id=").append(bean.getId());
            }
            
            sql.append(" ORDER BY id ");
            
            ResultSet rs = conn.createStatement().executeQuery(sql.toString());
            while(rs.next()) {
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setTitulo(rs.getString("titulo"));
                
                lista.add(s);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
        return lista;
    }

    
}
