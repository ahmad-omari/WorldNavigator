package Database;

import java.sql.*;

public class MySqlDB {
    private Connection connection;
    private java.sql.PreparedStatement preparedStatement;

    public MySqlDB(){
        inizializeJDBC();
    }

    private void inizializeJDBC(){
        try {

            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            // Create a Statement
            preparedStatement = connection.prepareStatement("insert into players " +
                    "(username, password) values (?, ?)");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean addPlayer(String username,String password){
        if (isPlayerExist(username)) {
            System.out.println("yessss");
            return false;
        }
        try {
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("yessss2");
            return false;
        }
        System.out.println("yessss3");
        return false;
    }

    public boolean isValidPlayer(String username,String password){
        if (connection == null){
            System.out.println("null database ");
            return false;
        }
        String query = "select * from players";//" where username="+username;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                if (dbUsername.equals(username) && dbPassword.equals(password)){
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean isPlayerExist(String username){
        String query = "SELECT username FROM players";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String dbUsername = resultSet.getString("username");
                if (dbUsername.equals(username)){
                    System.out.println("nooooo");
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }

}
