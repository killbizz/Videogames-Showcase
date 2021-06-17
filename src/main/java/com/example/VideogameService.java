package com.example;

import com.example.model.Videogame;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class VideogameService {

    Connection connDB = null;
    Statement statement = null;
    ResultSet query = null;
    
    public Map<String, Videogame> getVideogamesFromDB() {

        HashMap<String, Videogame> videogames = new HashMap<String, Videogame>();

        try {
        //MySQL DB connection
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_servlet_java", "root", "");
        //Retrieving data
        statement = connDB.createStatement();
        query = statement.executeQuery("Select * from videogames;");
        
        while(query.next()){
            String id = query.getString("ID");
            String name = query.getString("Name");
            String description = query.getString("Description");
            double price = query.getDouble("Price");

            videogames.put(id, new Videogame(id,name,description,price));
        }

    } catch (SQLException ex) { 
        ex.printStackTrace();
        System.out.println("SQLException");
        System.out.println(ex.getMessage());
    } catch (Exception e) {
        System.out.println("GenericException");
        System.out.println(e.getMessage());
    }
    finally {
        try{
            query.close();
        } catch(Exception e){
        }
        try{
            statement.close();
        } catch(Exception e){
        }
        try{
            connDB.close();
        } catch(Exception e) {
        }
    }
        return videogames;
    }

    public boolean insertNewVideogameToDB(Videogame v) {
        System.out.println(v.getName());
        try {
        //MySQL DB connection
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_servlet_java", "root", "");
        //Retrieving data
        statement = connDB.createStatement();
        statement.executeUpdate("INSERT INTO videogames (Name, Description, Price, ID) VALUES ('"+v.getName()+"', '"+v.getDescription()+"', '"+v.getPrice()+"', '"+v.getId()+"');");

        } catch (SQLException ex) { 
            ex.printStackTrace();
            System.out.println("SQLException");
            System.out.println(ex.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("genericException");
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            try{
                statement.close();
            } catch(Exception e){
                System.out.println("statementCloseException");
                return false;
            }
            try{
                connDB.close();
            } catch(Exception e) {
                System.out.println("DBconnectionCloseException");
                return false;
            }
        }

        return true;
    }

}