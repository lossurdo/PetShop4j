package com.targettrust.petshop.bd;

public abstract class CrudBD<T> implements Crud<T> {

    protected final String BD_STRING_CONEXAO = "jdbc:derby:PetShopDB;create=true";
    protected final String BD_USERNAME = "root";
    protected final String BD_PASSWORD = "root";
    
    public CrudBD() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
