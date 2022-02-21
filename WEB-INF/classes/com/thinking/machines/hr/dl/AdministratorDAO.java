package com.thinking.machines.hr.dl;
import java.sql.*;
public class AdministratorDAO {
    public AdministratorDTO getByUsername(String username) throws DAOException{
        try {
            Connection connection = DAOConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from administrator where username = ?");
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
                rs.close();
                statement.close();
                connection.close();
                throw new DAOException("Invalid Username");
            }
            String password = rs.getString("password").trim();
            rs.close();
            statement.close();
            connection.close();
            AdministratorDTO administrator = new AdministratorDTO();
            administrator.setPassword(password);
            administrator.setUsername(username);
            return administrator;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}
