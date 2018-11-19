package model;

import java.util.ArrayList;

public class Board {

    private String titulo;
    private String tipo;
    private ArrayList<List> lists = new ArrayList<List>();

    public Board(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public java.util.List<List> getLists(){
        return lists;
    }

    public void addList(List list){

        try {

            lists.add(list);

        }catch (NullPointerException e){

        }

    }

}
