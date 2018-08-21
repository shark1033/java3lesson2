package Task1;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        DataBase dataBase=new DataBase();
        try {
            dataBase.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            dataBase.addToDB();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            dataBase.printFromDB();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }



}
