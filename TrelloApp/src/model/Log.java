package model;

import javax.xml.datatype.XMLGregorianCalendar;

public class Log {

    private String descricao;

    public Log(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
