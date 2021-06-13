package org.example;

import java.sql.*;
import java.util.List;

public class Database {

    private Connection getConnection(){
        //https://zetcode.com/java/postgresql/
        String url = "jdbc:postgresql://localhost:5432/SkuskaData";
        String user = "postgres";
        String password = "123456";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
            System.out.println("Something wrong");
        }
        return null;
    }

    private void closeConnection(Connection connection){
        try {
            connection.close();
            System.out.println("Connection hes been closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertData(List<Data> list){
        Connection connection = getConnection();

        for(int i = 0; i < list.size(); i++){
            String query = "INSERT INTO Datas(DateWithTime, Temperature) VALUES(?, ?)";

            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setDate(1, new java.sql.Date(list.get(i).getDate().getTime()));
                pst.setInt(2, list.get(i).getTemperature());
                System.out.println(pst);
                pst.executeUpdate();
                System.out.println("Data number: " + i);
            } catch (SQLException ex) {
                System.out.println("Something wrong");
            }
        }
        closeConnection(connection);
    }

    public void selectData(){
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "select * from Datas" );
            while ( rs.next() ) {

                int id = rs.getInt("Id");


                Date date = rs.getDate("DateWithTime");

                int temperature  = rs.getInt("Temperature");

                System.out.println("Id: " + id + " Datum: " + date.getTime() + " Temperature: " + temperature);
                System.out.println();

            }
        }catch (Exception e){
            System.out.println("Something wrong");
        }

    }

    //varianta aj s casom
    private Connection getConnection2(){
        //https://zetcode.com/java/postgresql/
        String url = "jdbc:postgresql://localhost:5432/SkuskaData";
        String user = "postgres";
        String password = "123456";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
            System.out.println("Something wrong");
        }
        return null;
    }

    private void closeConnection2(Connection connection){
        try {
            connection.close();
            System.out.println("Connection hes been closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertData2(List<Data> list){
        Connection connection = getConnection2();

        for(int i = 0; i < list.size(); i++){
            String query = "INSERT INTO Datas2(Datee, Timee, Temperature) VALUES(?, ?, ?)";

            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setDate(1, new java.sql.Date(list.get(i).getDate().getTime()));
                Time time = new Time(list.get(i).getDate().getTime());
                pst.setTime(2, time);
                pst.setInt(3, list.get(i).getTemperature());
                System.out.println(pst);
                pst.executeUpdate();
                System.out.println("Data number: " + i);
            } catch (SQLException ex) {
                System.out.println("Something wrong");
            }
        }
        closeConnection2(connection);
    }

    public void selectData2(){
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery( "select * from Datas2" );
            while ( rs.next() ) {

                int id = rs.getInt("Id");


                Date date = rs.getDate("Datee");

                Time time = rs.getTime("Timee");

                int temperature  = rs.getInt("Temperature");

                System.out.println("Id: " + id + " Datum: " + date + " Time: " + time + " Temperature: " + temperature);
                System.out.println();

            }
        }catch (Exception e){
            System.out.println("Something wrong");
        }

    }


}
