package service;

import model.Board;
import model.Card;
import model.List;
import model.Log;

import java.util.ArrayList;

public class Service {

    ArrayList<Board> boards = new ArrayList<>();
    ArrayList<Log> logs = new ArrayList<>();

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void createBoard(String title, String tipo){

        Board board = new Board(title, tipo);
        boards.add(board);

    }

    public void removeBoard(String title){

        boards.remove(searchBoardByTitle(title));

    }

    public List createList(String title){

        List list = new List(title);

        return list;
    }

    public Card createCard(String title){

        Card card = new Card(title);

        return card;
    }

    public Log createLog(String descricao){

        Log log = new Log(descricao);
        logs.add(log);

        return log;
    }

    public Board searchBoardByTitle(String title){

        Board board = null;

        for (int i = 0; i < boards.size(); i++){

            if (boards.get(i).getTitulo().equals(title)){

                board = boards.get(i);
                break;

            }

        }

        return board;
    }


    public String listingAllBoards(){

        String boardTitle = "";

        if (boards.isEmpty()){

            boardTitle = "Nenhum Quadro para ser exibido";

        }else{

            for (int i = 0; i < boards.size(); i++){

                boardTitle += "  [  " + boards.get(i).getTitulo() + "  ]  ";

            }

        }

        return boardTitle;
    }

    public String listingAllLogs(){
        String descricaoLog = "";

        if (logs.isEmpty()){

            descricaoLog = "Não existem registros";

        }else{

            for (int i = 0; i < logs.size(); i++){

                descricaoLog += "  [  " + logs.get(i).getDescricao() + "  ]  \n";

            }

        }

        return descricaoLog;
    }

}
