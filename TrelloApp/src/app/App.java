package app;

import model.Board;
import model.List;
import ui.UserInterface;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Board> boards = new ArrayList<>();

        final int CREAT_BOARD =1;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    try {

                        String title = UserInterface.requestTitle();

                        Board board = new Board(title, "private");
                        boards.add(board);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Erro" + e.getMessage());

                    }
                    break;
                }

                case SAIR:{
                    return;
                }

                default: {
                    UserInterface.showMsg("Digite um opção válida");
                }
            }

        }

    }
}
