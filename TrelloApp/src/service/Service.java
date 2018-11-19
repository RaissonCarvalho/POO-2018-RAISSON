package service;

import model.Board;

import java.util.ArrayList;

public class Service {

    ArrayList<Board> boards = new ArrayList<>();

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void createBoard(String title, String tipo){


        Board board = new Board(title, tipo);
        boards.add(board);

    }

    public int searchIndexBoard(String title){

        int index = 0;

        for (int i = 0; i < boards.size(); i++){

            if (boards.get(i).getTitulo().equals(title)){

                index = i;
                break;

            }

        }
        return index;
    }

    public Board searchByTitle(String title){

        Board board = null;

        for (int i = 0; i < boards.size(); i++){

            if (boards.get(i).getTitulo().equals(title)){

                board = boards.get(i);
                break;

            }

        }

        return board;
    }

}
