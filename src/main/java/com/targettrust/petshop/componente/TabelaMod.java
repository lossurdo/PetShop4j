package com.targettrust.petshop.componente;

import java.lang.reflect.Field;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaMod extends AbstractTableModel {

    private final List lista;

    public TabelaMod(List lista) {
        this.lista = lista;
    }

    @Override
    public String getColumnName(int column) {
        if (lista != null && lista.size() > 0) {
            try {
                Class<? extends Object> clazz = lista.get(0).getClass();
                final Field atributo = clazz.getDeclaredFields()[column];
                return atributo.getName().toUpperCase();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return "N/D";
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        if (lista != null && lista.size() > 0) {
            Class<? extends Object> clazz = lista.get(0).getClass();
            return clazz.getDeclaredFields().length;
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lista != null && lista.size() > 0) {
            try {
                Class<? extends Object> clazz = lista.get(rowIndex).getClass();
                final Field atributo = clazz.getDeclaredFields()[columnIndex];
                atributo.setAccessible(true);
                return atributo.get(lista.get(rowIndex));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }
}
