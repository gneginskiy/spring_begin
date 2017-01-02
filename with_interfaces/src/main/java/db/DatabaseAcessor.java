package db;// Created by Neginskiy Gregoriy.

public class DatabaseAcessor {

    public DatabaseAcessor() {
        testConnection();
    }

    public void testConnection(){
        System.out.println(getClass().getSimpleName()+ " is testing connection....");
    }
}
