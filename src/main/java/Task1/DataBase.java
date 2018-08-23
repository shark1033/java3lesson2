package Task1;

import java.sql.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;


    public DataBase(){

        System.out.println("Data Base object is created");
//
    }


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection=DriverManager.getConnection("jdbc:sqlite:main.db");
        statement=connection.createStatement();

    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public void createTable(){

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

    public void deleteAllFromTable(String a) {
        try {
            statement.execute("DELETE FROM '"+a+"'");
            statement.execute("DELETE FROM sqlite_sequence WHERE name='goods'"); //id сбрасываем на 1!
        } catch (SQLException e) {
            System.out.println("Такой таблицы не существует или ёё нельзя очистить");
            e.printStackTrace();

        }

    }

    public void printFromDB(){
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM 'goods'");
            System.out.println("taking data from goods...");
            while (resultSet.next()){
                String name=resultSet.getString(1);
                String name1=resultSet.getString(2);
                String name2=resultSet.getString(3);
                System.out.println(name+ " " +name1+ " "+ name2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void addToDB(){  //Самый простой и долгий вариант

        long start= System.currentTimeMillis();
        try {

            for(int i=1;i<=10;i++){
                statement.execute("INSERT INTO goods(prodid, title, coast) VALUES("+i+",'товар"+i+"',"+i+")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        long finish = System.currentTimeMillis();
        System.out.println("===================");
        long time=finish-start;
        System.out.println("Время выполнения: "+time );
    }




}
