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

    public String listingAllCards(){

        String cardTitle = "";

        if (cards.isEmpty()){

            cardTitle = "Nenhum cartão para ser exibida";

        }else{

            for (int i = 0; i < cards.size(); i++){

                cardTitle += "  [  " + cards.get(i).getTitulo() + "  ]  ";

            }
        }

        return cardTitle;

    }

}
