package model;

import java.util.ArrayList;

public class List {

    private String titulo;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public List(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void addCard(Card card){

        cards.add(card);

    }


}
