package lesson1;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            connect();

            createTable();
            insertObjectToDB();
            System.out.println("DB after added record");
            readFromDB();
            System.out.println("DB after updated record and added another one");
            updateObjectInDB();
            insertObjectToDB();
            readFromDB();
            deleteObjectFromDB();
            System.out.println("DB after deleted record");
            readFromDB();
            deleteTable();

        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS lesson (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER);");
    }

    private static void insertObjectToDB() throws SQLException {
        statement.executeUpdate("INSERT INTO lesson (name,score) VALUES ('Mark',100);");
    }

    private static void readFromDB() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM lesson;");
        int colCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= colCount; i++) {
                System.out.print(resultSet.getObject(i) + " ");
            }
            System.out.println("");
        }
    }

    private static void updateObjectInDB() throws SQLException {
        statement.executeUpdate("UPDATE lesson SET score = 50 WHERE id = 1");
    }

    private static void deleteObjectFromDB() throws SQLException {
        statement.executeUpdate("DELETE FROM lesson WHERE id = 1;");
    }

    private static void deleteTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS lesson;");
    }


    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:lesson2.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
