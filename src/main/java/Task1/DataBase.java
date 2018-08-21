package Task1;

import java.sql.*;

public class DataBase {
    private Connection connection;
    private Statement statement;


    public DataBase(){

//        try {
////            init();
////            System.out.println("init 1");
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        } catch (SQLException e) {
////            System.out.println("Error! DataBase is not connected.");
////            e.printStackTrace();
////        }
////        finally {
////            try {
////                disconnect();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
        System.out.println("Data Base is connected");
//        try {
//            init();
//            System.out.println("init 2");
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
    }


    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection=DriverManager.getConnection("jdbc:sqlite:main.db");
        statement=connection.createStatement();

    }

    private void disconnect() throws SQLException {
        connection.close();
    }

    public void createTable() throws SQLException {

        try {
            init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'goods' (" +
                    "'id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "'prodid' TEXT NOT NULL," +
                    "'title' TEXT NOT NULL," +
                    "'coast' INTEGER NOT NULL" +
                    ");");

            System.out.println("ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAllFromTable(String a) throws SQLException {
        statement.execute("DELETE * FROM "+a);

    }

    public void printFromDB() throws SQLException {
        statement.execute("SELECT * FROM Goods");
        ResultSet resultSet=statement.getResultSet();
        System.out.println(resultSet);

    }

    public void addToDB() throws SQLException {
        statement.execute("INSERT INTO Goods(prodid, title, coast) VALUES(1010,'radiator',1000");

    }




}
