package Dao;

import model.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {
    public boolean addStore(Store store) {
        String sql = "INSERT INTO Store (storeId, name, address, revenue) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, store.getStoreId());
            statement.setString(2, store.getName());
            statement.setString(3, store.getAddress());
            statement.setLong(4, store.getRevenue());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Store getStoreById(String storeId) {
        String sql = "SELECT * FROM Store WHERE storeId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, storeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Store(
                        resultSet.getString("storeId"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getLong("revenue")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT * FROM Store";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                stores.add(new Store(
                        resultSet.getString("storeId"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getLong("revenue")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }

    public boolean updateStore(Store store) {
        String sql = "UPDATE Store SET name = ?, address = ?, revenue = ? WHERE storeId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, store.getName());
            statement.setString(2, store.getAddress());
            statement.setLong(3, store.getRevenue());
            statement.setString(4, store.getStoreId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStore(String storeId) {
        String sql = "DELETE FROM Store WHERE storeId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, storeId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
