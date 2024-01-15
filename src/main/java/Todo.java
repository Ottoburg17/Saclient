/*
* File: Saclient.java
* Author: Németh Ottó
* Copyright: 2024, Németh Ottó
* Group: Szoft 2-E
* Date: 2024-01-15
* Github: https://github.com/Ottoburg17/
* Licenc: GNU GPL
*/



public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

  

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
