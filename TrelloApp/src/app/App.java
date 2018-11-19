package app;

import model.List;
import service.Service;
import ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        final int CREAT_BOARD =1;
        final int ADD_LIST = 2;
        final int LIST_ALL_BOARDS = 3;
        final int LIST_ALL_LISTS = 4;
        final int LIST_ALL_CARDS = 5;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    try {

                        String title = UserInterface.requestBoardTitle();
                        String type = UserInterface.requestVisibility();

                        service.createBoard(title, type);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Erro" + e.getMessage());

                    }
                    break;
                }

                case ADD_LIST:{

                    try {

                        String title = UserInterface.requestBoardTitle();

                        if (service.searchBoardByTitle(title) != null){

                            service.searchBoardByTitle(title).addList(new List(UserInterface.requestListTitle()));
                        }else{

                            UserInterface.showMsg("Quadro não encontrado");

                        }

                        break;

                    }catch (IndexOutOfBoundsException e){

                        UserInterface.showMsg("Impossível adicionar lista. Nenhum quadro criado");
                        break;

                    }

                }

                case LIST_ALL_BOARDS:{

                    if (service.getBoards().isEmpty()){

                        UserInterface.showMsg("Nenhum Quadro criado");
                        break;

                    }else{

                        UserInterface.showMsg(service.listBoards());
                        break;

                    }

                }

                case LIST_ALL_LISTS:{

                   if (service.getBoards().isEmpty()){

                       UserInterface.showMsg("Impossível listar Cartões. Nenhum Quadro criado");
                       break;

                   }else{

                       String title = UserInterface.requestBoardTitle();

                       try {

                           if (service.searchBoardByTitle(title).getLists().isEmpty()){

                               UserInterface.showMsg("Nenhuma Lista no Quadro" + " " + service.searchBoardByTitle(title).getTitulo());
                               break;

                           }else{

                               UserInterface.showMsg(service.searchBoardByTitle(title).listingAllLists());
                               break;

                           }

                       }catch (NullPointerException e){

                           UserInterface.showMsg("Quadro não encontrado");
                           break;

                       }

                   }

                }

                case LIST_ALL_CARDS: {
                    //TODO IMPLEMENTAR LISTAGEM DE CARTÕES 

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
