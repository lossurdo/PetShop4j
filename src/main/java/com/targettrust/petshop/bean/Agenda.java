package com.targettrust.petshop.bean;

import java.util.Date;

public class Agenda {
    private Integer id;
    private Date data;
    private String hora;
    private Integer clienteID;
    private Integer servicoID;
    private String status;

    public Agenda(Integer id) {
        this.id = id;
    }

    public Agenda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Integer getServicoID() {
        return servicoID;
    }

    public void setServicoID(Integer servicoID) {
        this.servicoID = servicoID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
}
