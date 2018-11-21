package app;

import service.Service;
import ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        final int CREAT_BOARD = 1;
        final int ADD_LIST = 2;
        final int ADD_CARD_TO_LIST = 3;
        final int MOVE_LIST_TO_BOARD = 4;
        final int LIST_ALL_BOARDS = 5;
        final int LIST_ALL_LISTS = 6;
        final int LIST_ALL_CARDS = 7;
        final int LIST_LOGS = 8;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    createBoard(service);
                    break;

                }

                case ADD_LIST:{

                    try {
                        addList(service);
                        break;
                    }catch (IndexOutOfBoundsException e){

                        UserInterface.showMsg("Impossivel adicionar Lista. Nenhum Quadro criado");

                    }

                }

                case ADD_CARD_TO_LIST:{

                    addCardToList(service);
                    break;

                }

                case MOVE_LIST_TO_BOARD:{

                    if (service.getBoards().isEmpty()){

                        UserInterface.showMsg("Nenhum Quadro criado");
                        break;

                    }else{

                        try {

                            String boardTitle = UserInterface.requestBoardTitle();

                            if (service.searchBoardByTitle(boardTitle).getLists().isEmpty()){

                                UserInterface.showMsg("Nenhuma lista criada");
                                break;

                            }else{

                                try {

                                    String listTitle = UserInterface.requestListTitle();
                                    String newBoardTitle = UserInterface.requestNewBoardTitle();

                                    try {

                                        service.searchBoardByTitle(boardTitle).removeList(service.searchBoardByTitle(boardTitle).searchListByTitle(listTitle));
                                        service.searchBoardByTitle(newBoardTitle).addList(service.searchBoardByTitle(boardTitle).searchListByTitle(listTitle));
                                        break;

                                    }catch (NullPointerException e){

                                        UserInterface.showMsg("Quadro não encontrado");
                                        break;

                                    }


                                }catch (NullPointerException e){

                                    UserInterface.showMsg("Lista não encontrada");

                                }

                            }

                        }catch (NullPointerException e){

                            UserInterface.showMsg("Quadro não encontrado");

                        }

                    }

                }

                case LIST_ALL_BOARDS:{

                    UserInterface.showMsg(service.listingAllBoards());
                    break;

                }

                case LIST_ALL_LISTS:{

                    if (service.getBoards().isEmpty()){

                       UserInterface.showMsg("Nenhum Quadro criado");
                       break;

                   }else{

                       String title = UserInterface.requestBoardTitle();

                       try {

                           UserInterface.showMsg(service.searchBoardByTitle(title).listingAllLists());
                           break;

                       }catch (NullPointerException e){

                           UserInterface.showMsg("Quadro não encontrado");
                           break;

                       }

                   }

                }

                case LIST_ALL_CARDS:{

                    if (service.getBoards().isEmpty()){

                        UserInterface.showMsg("Nenhum Quadro criado");
                        break;

                    }else{

                        String boadTitle = UserInterface.requestBoardTitle();

                        try {

                            if (service.searchBoardByTitle(boadTitle).getLists().isEmpty()){

                                UserInterface.showMsg("Nenhuma Lista criada");
                                break;

                            }else{

                                String listTitle = UserInterface.requestListTitle();

                                try {

                                    UserInterface.showMsg(service.searchBoardByTitle(boadTitle).searchListByTitle(listTitle).listingAllCards());
                                    break;

                                }catch (NullPointerException e){

                                    UserInterface.showMsg("Lista não encontrada");
                                    break;

                                }

                            }

                        }catch (NullPointerException e){

                            UserInterface.showMsg("Quadro não encontrado");

                        }

                    }

                }

                case LIST_LOGS:{

                    UserInterface.showMsg(service.listingAllLogs());
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

    private static void createBoard(Service service){

        try {

            String title = UserInterface.requestBoardTitle();
            String type = UserInterface.requestVisibility();

            service.createBoard(title, type);
            service.createLog("Criou o Quadro " + title);

        }catch (NullPointerException e){

            UserInterface.showMsg("Erro ao criar Quadro" );

        }

    }

    private static void addList(Service service){

        String title = UserInterface.requestBoardTitle();

        if (service.searchBoardByTitle(title) != null){

            String listTitle = UserInterface.requestListTitle();

            service.searchBoardByTitle(title).addList(service.createList(listTitle));

            service.createLog("Adicionou a lista " + listTitle + " ao Quadro " + title);
        }else{

            UserInterface.showMsg("Quadro não encontrado");

        }

    }

    private static void addCardToList(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            try {

                String boardTitle =  UserInterface.requestBoardTitle();

                if (service.searchBoardByTitle(boardTitle).getLists().isEmpty()){

                    UserInterface.showMsg("Nenhuma Lista criada");

                }else{

                    String listTitle = UserInterface.requestListTitle();

                    try {

                        String cardTitle = UserInterface.requestCardTitle();
                        service.searchBoardByTitle(boardTitle).searchListByTitle(listTitle).addCard(service.createCard(cardTitle));

                        service.createLog("Adicionou o Cartão " + cardTitle + " à Lista " + listTitle + "do Quadro " + boardTitle);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Nenhuma Lista encontrada");

                    }

                }

            }catch (NullPointerException e){

                UserInterface.showMsg("Nenhum Quadro encontrado");

            }

        }

    }

}