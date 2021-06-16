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

        Map<String, Videogame> videogames = new HashMap<String, Videogame>();

        try {
        //MySQL DB connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
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
    } catch (Exception e) {
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

        try {
        //MySQL DB connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_servlet_java", "root", "");
        //Retrieving data
        statement = connDB.createStatement();
        query = statement.executeQuery("INSERT INTO videogames (Name, Description, Price, ID) VALUES ("+v.getName()+", "+v.getDescription()+", "+v.getPrice()+", "+v.getId()+");");

        } catch (SQLException ex) { 
            ex.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;
        }
        finally {
            try{
                query.close();
            } catch(Exception e){
                return false;
            }
            try{
                statement.close();
            } catch(Exception e){
                return false;
            }
            try{
                connDB.close();
            } catch(Exception e) {
                return false;
            }
        }

        return true;
    }

}