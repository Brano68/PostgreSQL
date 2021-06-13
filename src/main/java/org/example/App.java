package org.example;

/**
 * Hello world!
 * https://mkyong.com/jdbc/how-do-connect-to-postgresql-with-jdbc-driver-java/?fbclid=IwAR27EfrbIBrLq6dEa32LaaXfmzDeq5zX8CHKhulBIDzUWNCjR0yQdGfJ_5g
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class App 
{
    public static void main( String[] args ) throws ParseException {

        System.out.println( "Hello World!" );
/*
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/SkuskaData", "postgres", "123456")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
 */

        //Database database = new Database();
        //System.out.println(database.getConnection());
        //database.otestovanie();
        //database.testInsertovanie();


        //toto ide
        /*
        String url = "jdbc:postgresql://localhost:5432/SkuskaData";
        String user = "postgres";
        String password = "123456";
//https://zetcode.com/java/postgresql/
        int id = 77;
        String author = "skusammNm";
        String query = "INSERT INTO hodnota(std_id, std_name) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            System.out.println(con);
            pst.setInt(1, id);
            pst.setString(2, author);
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("preslo");

        } catch (SQLException ex) {

        }

         */



        /*
        String url = "jdbc:postgresql://localhost:5432/SkuskaData";
        String user = "postgres";
        String password = "123456";
//https://zetcode.com/java/postgresql/

        String query = "INSERT INTO Persons(Name, Age, Datum) VALUES(?, ?, ?)";
        Date datum = new Date();
        int age = 8;
        String name = "Brano";
        System.out.println(datum);

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            System.out.println(con);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setDate(3, new java.sql.Date(datum.getTime()));
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("preslo");

        } catch (SQLException ex) {

        }

         */
/*
        Database database = new Database();
        //System.out.println(database.getConnection());

        String query = "INSERT INTO Persons(Name, Age, Datum) VALUES(?, ?, ?)";
        Date datum = new Date();
        int age = 8;
        String name = "Brano";
        System.out.println(datum);

        try (PreparedStatement pst = database.getConnection().prepareStatement(query)) {
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setDate(3, new java.sql.Date(datum.getTime()));
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("preslo");

        } catch (SQLException ex) {
            System.out.println("Something wrong");
        }

 */

        Subor subor = new Subor();
        List<Data> list = subor.allData();

        for(Data data : list){
            System.out.println(data.getDate() + " " + data.getTemperature());
        }

        Database database = new Database();
        //database.insertData(list);
        //database.selectData();
        //database.insertData2(list);
        database.selectData2();

    }
}
