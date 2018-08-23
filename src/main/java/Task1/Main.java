package Task1;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        DataBase dataBase=new DataBase();

        try {
            DataBase.connect();
        } catch (ClassNotFoundException e) {
            System.out.println("Class hasn't been found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Problems with sql");
            e.printStackTrace();
        }
        finally {
            try {
                DataBase.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        dataBase.createTable();
        dataBase.deleteAllFromTable("goods");
        dataBase.addToDB();
        dataBase.printFromDB();
        //dataBase.addToDB();


    }



}
