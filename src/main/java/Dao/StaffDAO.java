package Dao;

import model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO Staff (staffId, name, position) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getStaffId());
            statement.setString(2, staff.getName());
            statement.setString(3, staff.getPosition());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Staff getStaffById(String staffId) {
        String sql = "SELECT * FROM Staff WHERE staffId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staffId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Staff(
                        resultSet.getString("staffId"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        new StoreDAO().getStoreById(resultSet.getString("storeId"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                staffList.add(new Staff(
                        resultSet.getString("staffId"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        new StoreDAO().getStoreById(resultSet.getString("storeId"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE Staff SET name = ?, position = ?, storeId = ? WHERE staffId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getPosition());
            statement.setString(3, staff.getStore().getStoreId());
            statement.setString(4, staff.getStaffId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(String staffId) {
        String sql = "DELETE FROM Staff WHERE staffId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staffId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
