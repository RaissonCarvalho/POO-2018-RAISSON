package app;

import model.Card;
import model.List;
import service.Service;
import ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        final int CREAT_BOARD =1;
        final int ADD_LIST = 2;
        final int ADD_CARD_TO_LIST = 3;
        final int LIST_ALL_BOARDS = 4;
        final int LIST_ALL_LISTS = 5;
        final int LIST_ALL_CARDS = 6;
        final int LIST_LOGS = 7;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    try {

                        String title = UserInterface.requestBoardTitle();
                        String type = UserInterface.requestVisibility();

                        service.createBoard(title, type);
                        service.createLog("Criou o Quadro " + title);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Erro ao criar Quadro" );

                    }
                    break;
                }

                case ADD_LIST:{

                    try {

                        String title = UserInterface.requestBoardTitle();

                        if (service.searchBoardByTitle(title) != null){

                            String listTitle = UserInterface.requestListTitle();

                            service.searchBoardByTitle(title).addList(service.createList(listTitle));

                            service.createLog("Adicionou a lista " + listTitle + " ao Quadro " + title);
                        }else{

                            UserInterface.showMsg("Quadro não encontrado");

                        }

                        break;

                    }catch (IndexOutOfBoundsException e){

                        UserInterface.showMsg("Impossível adicionar lista. Nenhum quadro criado");
                        break;

                    }

                }

                case ADD_CARD_TO_LIST:{

                    try {

                        if (service.getBoards().isEmpty()){

                            UserInterface.showMsg("Nenhum Quadro criado");
                            break;

                        }else{

                            String boardTitle =  UserInterface.requestBoardTitle();

                            if (service.searchBoardByTitle(boardTitle).getLists().isEmpty()){

                                UserInterface.showMsg("Nenhuma Lista criada");
                                break;

                            }else{

                                String listTitle = UserInterface.requestListTitle();
                                String cardTitle = UserInterface.requestCardTitle();
                                service.searchBoardByTitle(boardTitle).searchListByTitle(listTitle).addCard(service.createCard(cardTitle));

                                service.createLog("Adicionou o Cartão " + cardTitle + " à Lista " + listTitle + "do Quadro " + boardTitle);
                                break;

                            }

                        }

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Não foi possivel adicionar Cartão");
                        break;

                    }

                }

                case LIST_ALL_BOARDS:{

                    UserInterface.showMsg(service.listBoards());
                    break;

                }

                case LIST_ALL_LISTS:{

                    if (service.getBoards().isEmpty()){

                       UserInterface.showMsg("Impossível exibir Listas. Nenhum Quadro criado");
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

                case LIST_ALL_CARDS:{

                    //TODO Implementar Exibir Cartões

                }

                case LIST_LOGS:{

                    UserInterface.showMsg(service.listLogs());
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