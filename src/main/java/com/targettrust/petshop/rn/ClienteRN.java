package com.targettrust.petshop.rn;

import com.targettrust.petshop.bd.CrudBD;
import com.targettrust.petshop.bean.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRN extends CrudBD<Cliente> {

    @Override
    public void salvar(Cliente bean) {
        if(consultar(bean)!=null) {
            alterar(bean);
            return;
        }
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO cliente (id,animal,proprietario,telefone,email,tipo) VALUES (?,?,?,?,?,?)");
            
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getId());
            pstm.setString(2, bean.getAnimal());
            pstm.setString(3, bean.getProprietario());
            pstm.setString(4, bean.getTelefone());
            pstm.setString(5, bean.getEmail());
            pstm.setString(6, bean.getTipo());
            
            pstm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
    }

    @Override
    public void excluir(Cliente bean) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM cliente WHERE id=?");
            
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getId());
            
            pstm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
    }

    @Override
    public Cliente consultar(Cliente bean) {
        Cliente c = null;
        Connection conn = null;        
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM cliente WHERE id=").append(bean.getId());
            
            ResultSet rs = conn.createStatement().executeQuery(sql.toString());
            while(rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setAnimal(rs.getString("animal"));
                c.setProprietario(rs.getString("proprietario"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
        return c;
    }

    @Override
    public void alterar(Cliente bean) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE cliente SET animal=?,proprietario=?,telefone=?,email=?,tipo=? WHERE id=?");
            
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getAnimal());
            pstm.setString(2, bean.getProprietario());
            pstm.setString(3, bean.getTelefone());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getTipo());
            pstm.setInt(6, bean.getId());
            
            pstm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) { }
        }
    }

    @Override
    public List<Cliente> pesquisar(Cliente bean) {
        List<Cliente> lista = new ArrayList<Cliente>();
        Connection conn = null;        
        try {
            conn = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM cliente ");
            
            if(bean!=null && bean.getId()!=null) {
                sql.append(" WHERE id=").append(bean.getId());
            }
            
            sql.append(" ORDER BY id ");
            
            ResultSet rs = conn.createStatement().executeQuery(sql.toString());
            while(rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setAnimal(rs.getString("animal"));
                c.setProprietario(rs.getString("proprietario"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getString("tipo"));
                
                lista.add(c);
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
