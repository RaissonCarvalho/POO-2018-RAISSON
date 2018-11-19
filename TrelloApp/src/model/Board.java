package model;

import java.util.ArrayList;

public class Board {

    private String titulo;
    private String tipo;
    private ArrayList<List> lists = new ArrayList<>();

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

        lists.add(list);

    }

    public String listingAllLists(){

        String listTitle = "";

        for (int i = 0; i < lists.size(); i++){

            listTitle += "  [  " + lists.get(i).getTitulo() + "  ]  ";

        }

        return listTitle;
    }

}
