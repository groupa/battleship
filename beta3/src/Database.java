

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author dmitry
 */
public class Database {

    private Connection c;
    private String databasename;

    Database(String server, String dbname, String user, String password, String path) throws Exception {
        c = null;
        databasename = dbname;
        LoadDriver();
        Connect(server, user, password);
        Init(server, user, password, dbname, path);
    }

    private void Connect(String server, String user, String password) throws Exception {
        try {
            //c = DriverManager.getConnection("jdbc:mysql://localhost/books", "root", "rtpassword");
            c = DriverManager.getConnection("jdbc:mysql://" + server + "/?user=" + user + "&password=" + password);
        } catch (Exception e) {
            Exception ex = new Exception("Wrong database data." + e.getMessage());
            throw ex;
        }
        if (c == null) {
            Exception ex = new Exception("Something got wrong");
            throw ex;
        }
    }
    
    

    private void LoadDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            Exception ex = new Exception("Couldn't find driver class.");
            throw ex;
        }
    }

    private void Init(String server, String user, String password, String dbname, String path) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Statement st = c.createStatement();
            DatabaseMetaData meta = c.getMetaData();
            ResultSet rs = meta.getCatalogs();
            while (rs.next()) {
                String listofDatabases = rs.getString("TABLE_CAT");
                list.add(listofDatabases);
            }
            if (!list.contains(dbname)) {
                UpdateQuery("CREATE DATABASE `" + databasename + "` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci");
                UpdateQuery("CREATE  TABLE `" + databasename + "`.`books` ("
                        + "`id` INT PRIMARY KEY , "
                        + "`isbn` VARCHAR(13) NULL ,"
                        + "`copynumber` INT NULL ,"
                        + "`title` TEXT NULL ,"
                        + "`author` TEXT NULL ,"
                        + "`publisher` TEXT NULL ,"
                        + "`year` YEAR NULL ,"
                        + "`statistics` INT NULL ,"
                        + "`isborrowed` VARCHAR(45) NULL ,"
                        + "`borrowdate` DATETIME NULL ,"
                        + "`returndate` DATETIME NULL ,"
                        + "`librarycardnumber` INT NULL );");

                UpdateQuery("CREATE  TABLE `" + databasename + "`.`borrowers` ("
                        + "`librarycardnumber` INT PRIMARY KEY ,"
                        + "`name` VARCHAR(45) NULL ,"
                        + "`street` VARCHAR(45) NULL ,"
                        + "`town` VARCHAR(45) NULL ,"
                        + "`zipcode` VARCHAR(45) NULL );");
                rs.close();
            }
        } catch (Exception se) {
            Exception ex = new Exception("Unable to create the database.");
            throw ex;
        }

    }
    
    String checkUser(String login, String password) {
    	 ResultSet res;
         int number = 0;
         try {
             res = Query("SELECT `users`.`login` FROM `" + databasename + "`.`users` WHERE `users`.`login` = '" + login + "' AND `users`.`password` = '" + password + "';");
             while (res.next()) {
                 number++;
             }
             if (number != 1) {
                 return "Wrong login/password.";
             } else {
            	 return "OK";	 
             }
         } catch (Exception ex) {
             return "Internal database error.";
         }
    }


  


    private ResultSet Query(String query) throws Exception {
        ResultSet rs = null;
        Statement s = null;
        try {
            s = c.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException se) {
            System.out.println("We got an exception while  executing our query: " + query + ". that probably means our SQL is invalid");
            System.out.println(se.getMessage());
           // System.exit(1);
            throw se;
        }
        return rs;
    }

    private int UpdateQuery(String query) {
        int number = 0;
        ResultSet rs = null;
        Statement s = null;
        try {
            s = c.createStatement();
            number = s.executeUpdate(query);
        } catch (SQLException se) {
            System.out.println("We got an exception while  executing our query: " + query + ". that probably means our SQL is invalid");
            System.out.println(se.getMessage());
            System.exit(1);
        }
        return number;
    }
}
