package model;

import java.util.ArrayList;

public class Board {

    private String titulo;
    private String visibilidade;
    private ArrayList<List> lists = new ArrayList<>();

    public Board(String titulo, String visibilidade) {
        this.titulo = titulo;
        this.visibilidade = visibilidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
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
