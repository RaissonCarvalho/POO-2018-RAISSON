package model;

import java.util.ArrayList;
import java.util.Collections;

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
        return Collections.unmodifiableList(lists);
    }

    public void addList(List list){

        lists.add(list);

    }

    public String listingAllLists(){

        String listTitle = "";

        if (lists.isEmpty()){

            listTitle = "Nenhuma lista para ser exibida";

        }else{

            for (int i = 0; i < lists.size(); i++){

                listTitle += "  [  " + lists.get(i).getTitulo() + "  ]  ";

            }
        }

        return listTitle;
    }

    public List searchListByTitle(String title) {

        List list = null;

        for (int i = 0; i < lists.size(); i++){

            if (lists.get(i).getTitulo().equals(title)){

                list = lists.get(i);
                break;

            }

        }

        return list;
    }

}
