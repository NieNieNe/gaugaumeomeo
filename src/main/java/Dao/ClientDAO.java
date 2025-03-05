package Dao;

import model.Client;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    public Client login (String username, String pass){
        String sql = "select * from Client where name = ? and pass = ?";
        try (Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, username);
       statement.setString(2, pass);
           ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
               Client user = new Client();
               user.setId(resultSet.getInt("id"));
               user.setName(resultSet.getString("name"));
               user.setPass(resultSet.getString("pass"));
               user.setEmail(resultSet.getString("email"));
               user.setPhoneNumber(resultSet.getString("phoneNumber"));
               return user;
           }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public boolean registerClient(Client client) {
        String sql = "INSERT INTO Client (id, name, pass, email, phoneNumber) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()){
             PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getPass());
            statement.setString(4, client.getEmail());
            statement.setString(5, client.getPhoneNumber());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Client getClientById(long id) {
        String sql = "SELECT * FROM Client WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("pass"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("pass"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public boolean updateClient(Client client) {
        String sql = "UPDATE Client SET name = ?, pass = ?, email = ?, phoneNumber = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getPass());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPhoneNumber());
            statement.setLong(5, client.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteClient(long id) {
        String sql = "DELETE FROM Client WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

