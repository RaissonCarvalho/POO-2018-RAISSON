package app;

import model.List;
import service.Service;
import ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        final int CREAT_BOARD =1;
        final int ADD_LIST = 2;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    try {

                        String title = UserInterface.requestBoardTitle();
                        String type = UserInterface.requestType();

                        service.createBoard(title, type);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Erro" + e.getMessage());

                    }
                    break;
                }

                case ADD_LIST:{

                    try {

                        String title = UserInterface.requestBoardTitle();

                        if (service.searchByTitle(title) != null){

                            service.searchByTitle(title).addList(new List(UserInterface.requestListTitle()));
                        }else{

                            UserInterface.showMsg("Quadro não encontrado");

                        }

                        break;

                    }catch (IndexOutOfBoundsException e){

                        UserInterface.showMsg("Impossível adicionar lista. Nenhum quadro criado");
                        break;

                    }

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
