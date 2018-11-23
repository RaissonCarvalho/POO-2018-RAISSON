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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){

        cards.add(card);

    }

    public void removeCard(Card card){

        cards.remove(card);

    }

    public String listingAllCards(){

        String cardTitle = "";

        if (cards.isEmpty()){

            cardTitle = "Nenhum cartão para ser exibido";

        }else{

            for (int i = 0; i < cards.size(); i++){

                cardTitle += "  [  " + cards.get(i).getTitulo() + "  ]  ";

            }
        }

        return cardTitle;

    }

    public Card searchCardByTitle(String title){

        Card card = null;

        for (int i = 0; i< cards.size(); i++){

            if (cards.get(i).getTitulo().equals(title)){

                card = cards.get(i);

            }

        }

        return card;
    }

}
