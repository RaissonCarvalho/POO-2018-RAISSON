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

    public int searchIndexBoard(){

        for (int i = 0; i < boards.size(); i++){

            

        }

    }

}
