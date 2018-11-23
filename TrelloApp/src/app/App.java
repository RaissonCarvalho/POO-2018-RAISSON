package app;

import model.Board;
import model.Card;
import model.List;
import service.Service;
import ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        final int CREAT_BOARD = 1;
        final int ADD_LIST = 2;
        final int ADD_CARD_TO_LIST = 3;
        final int MOVE_LIST_TO_BOARD = 4;
        final int DELETE_BOARD = 5;
        final int DELETE_LIST = 6;
        final int DELETE_CARD =7;
        final int LIST_ALL_BOARDS = 8;
        final int LIST_ALL_LISTS = 9;
        final int LIST_ALL_CARDS = 10;
        final int LIST_LOGS = 11;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CREAT_BOARD:{

                    createBoard(service);
                    break;

                }

                case ADD_LIST:{

                    addList(service);
                    break;

                }

                case ADD_CARD_TO_LIST:{

                    addCardToList(service);
                    break;

                }

                case MOVE_LIST_TO_BOARD:{

                    moveListToBoard(service);
                    break;

                }

                case DELETE_BOARD:{

                    deleteBoard(service);
                    break;

                }

                case DELETE_LIST:{

                    deleteList(service);
                    break;

                }

                case DELETE_CARD:{

                    deleteCard(service);
                    break;

                }

                case LIST_ALL_BOARDS:{

                    UserInterface.showMsg(service.listingAllBoards());
                    break;

                }

                case LIST_ALL_LISTS:{

                    listAllLists(service);
                    break;

                }

                case LIST_ALL_CARDS:{

                    listAllCards(service);
                    break;

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
            service.createLog("Criou o Quadro [ " + title + " ]");

        }catch (NullPointerException e){

            UserInterface.showMsg("Erro ao criar Quadro" );

        }

    }

    private static void addList(Service service){

        try {

            String title = UserInterface.requestBoardTitle();

            if (service.searchBoardByTitle(title) != null){

                String listTitle = UserInterface.requestListTitle();
                service.searchBoardByTitle(title).addList(service.createList(listTitle));

                service.createLog("Adicionou a lista [ " + listTitle + " ] ao Quadro " + title);
            }else{

                UserInterface.showMsg("Quadro não encontrado");

            }

        }catch (IndexOutOfBoundsException e){

            UserInterface.showMsg("Impossivel adicionar Lista. Nenhum Quadro criado");

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

                        service.createLog("Adicionou o Cartão [" + cardTitle + " ] à Lista [ " + listTitle + " ] do Quadro " + boardTitle);

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Nenhuma Lista encontrada");

                    }

                }

            }catch (NullPointerException e){

                UserInterface.showMsg("Nenhum Quadro encontrado");

            }

        }

    }

    private static void moveListToBoard(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            try {

                String boardTitle = UserInterface.requestBoardTitle();
                Board board = service.searchBoardByTitle(boardTitle);

                if (service.searchBoardByTitle(boardTitle).getLists().isEmpty()){

                    UserInterface.showMsg("Nenhuma Lista criada");

                }else{

                    try {

                        String listTitle = UserInterface.requestListTitle();
                        List list = service.searchBoardByTitle(boardTitle).searchListByTitle(listTitle);

                        try {

                            String newBoardTitle = UserInterface.requestNewBoardTitle();
                            Board newBoard = service.searchBoardByTitle(newBoardTitle);

                            newBoard.addList(list);
                            board.removeList(list);

                            service.createLog("Moveu a Lista [" + listTitle + " ]para o Quadro " + newBoardTitle);

                        }catch (NullPointerException e){

                            UserInterface.showMsg("Quadro não encontrado");

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

    private static void deleteBoard(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            String boardTitle = UserInterface.requestBoardTitle();

            try {

               Board board = service.searchBoardByTitle(boardTitle);
               service.removeBoard(board.getTitulo());

               service.createLog("Removeu o Quadro [ " + boardTitle + " ]");

            }catch (NullPointerException e){

                UserInterface.showMsg("Quadro não encontrado");

            }

        }

    }

    private static void deleteList(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            String boardTitle = UserInterface.requestBoardTitle();

            try {

                Board board = service.searchBoardByTitle(boardTitle);

                try {

                    if (board.getLists().isEmpty()){

                        UserInterface.showMsg("Nenhuma Lista no Quadro [ " +boardTitle + " ]");

                    }else{

                        String listTitle = UserInterface.requestListTitle();

                        if (board.searchListByTitle(listTitle) != null){

                            board.removeList(board.searchListByTitle(listTitle));

                        }else{
                            UserInterface.showMsg("Lista não encontrada");
                        }

                    }

                }catch (NullPointerException e){

                    UserInterface.showMsg("Quadro não encontrado");

                }

            }catch (NullPointerException e){

                UserInterface.showMsg("Quadro não encontrado");

            }

        }

    }

    private static void deleteCard(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            String boardTitle = UserInterface.requestBoardTitle();

            try {

                Board board = service.searchBoardByTitle(boardTitle);

                if (board.getLists().isEmpty()){

                    UserInterface.showMsg("Lista não encontrada");

                }else{

                    String listTitle = UserInterface.requestListTitle();

                    try {

                        List list = board.searchListByTitle(listTitle);

                        if (list.getCards().isEmpty()){

                            UserInterface.showMsg("Nenhum Cartão na Lista [ " + listTitle + " ]");

                        }else{

                            String cardTitle = UserInterface.requestCardTitle();

                            try {

                                list.getCards().remove(list.searchCardByTitle(cardTitle));

                            }catch (NullPointerException e){

                                UserInterface.showMsg("Cartão não encontrado");

                            }

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

    private static void listAllLists(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            String title = UserInterface.requestBoardTitle();

            try {

                UserInterface.showMsg(service.searchBoardByTitle(title).listingAllLists());

            }catch (NullPointerException e){

                UserInterface.showMsg("Quadro não encontrado");

            }

        }

    }

    private static void listAllCards(Service service){

        if (service.getBoards().isEmpty()){

            UserInterface.showMsg("Nenhum Quadro criado");

        }else{

            String boadTitle = UserInterface.requestBoardTitle();

            try {

                if (service.searchBoardByTitle(boadTitle).getLists().isEmpty()){

                    UserInterface.showMsg("Nenhuma Lista criada");

                }else{

                    String listTitle = UserInterface.requestListTitle();

                    try {

                        UserInterface.showMsg(service.searchBoardByTitle(boadTitle).searchListByTitle(listTitle).listingAllCards());

                    }catch (NullPointerException e){

                        UserInterface.showMsg("Lista não encontrada");

                    }

                }

            }catch (NullPointerException e){

                UserInterface.showMsg("Quadro não encontrado");

            }

        }

    }

}