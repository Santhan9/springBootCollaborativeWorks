package com.start.springboot.springBoot;

import java.sql.*;


public class dataStorage {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/creativeworks",
                "root", "1234");
    }

    private void closeConnection(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    public void storeUserDetails(String firstName,String lastName,long phone,String email,String password) throws ClassNotFoundException {
        String sql = "INSERT INTO userdetails (firstName,lastName,phoneNumber,email,password) VALUES ('"+firstName+"','"+lastName+"','"+phone+"','"+email+"','"+password+"');";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            int resultSet = statement.executeUpdate();
           // System.out.println("Executed"+email);
            System.out.println("Fine");

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    public void storeUserCourseDetails(String id, String email,String course) throws ClassNotFoundException {
        String sql = "INSERT INTO usercourse (id,email,course) VALUES ('"+id+"','"+email+"','"+course+"');";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            int resultSet = statement.executeUpdate();
            System.out.println("Executed"+email);
            System.out.println("Fine");

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }



    public cusInfo validateUserDetails(String email,String password) throws ClassNotFoundException {

        String dbUsername, dbPassword;
        boolean login = false;
        String sql = "SELECT * FROM userdetails;";
        cusInfo ci = new cusInfo();

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection();
            //Statement stmt = (Statement) con.createStatement();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery(sql);
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
                dbUsername = rs.getString("email");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(email) && dbPassword.equals(password)){
                    System.out.println("OK");
                    login = true;
                    ci = new cusInfo(rs.getString("firstName"),rs.getString("lastName"),rs.getLong("phoneNumber"),rs.getString("email"),rs.getString("password"));
                }
                //System.out.println(email + password + " " + dbUsername + dbPassword);
            }
            //System.out.println("Executed"+email);
            //System.out.println("Fine");

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        System.out.println(login);

        return ci;
    }

}
