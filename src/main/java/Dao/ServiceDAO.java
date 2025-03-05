//package Dao;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ServiceDAO {
//    public boolean addService(Service service) {
//        String sql = "INSERT INTO Service (id, nameService, price, describe, executionTime) VALUES (?, ?, ?, ?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, service.getId());
//            statement.setString(2, service.getNameService());
//            statement.setDouble(3, service.getPrice());
//            statement.setString(4, service.getDescribe());
//            statement.setTime(5, Time.valueOf(service.getExecutionTime()));
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public Service getServiceById(long id) {
//        String sql = "SELECT * FROM Service WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return new Service(
//                        resultSet.getLong("id"),
//                        resultSet.getString("nameService"),
//                        resultSet.getDouble("price"),
//                        resultSet.getString("describe"),
//                        resultSet.getTime("executionTime").toLocalTime()
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<Service> getAllServices() {
//        List<Service> services = new ArrayList<>();
//        String sql = "SELECT * FROM Service";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                services.add(new Service(
//                        resultSet.getLong("id"),
//                        resultSet.getString("nameService"),
//                        resultSet.getDouble("price"),
//                        resultSet.getString("describe"),
//                        resultSet.getTime("executionTime").toLocalTime()
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return services;
//    }
//
//    public boolean updateService(Service service) {
//        String sql = "UPDATE Service SET nameService = ?, price = ?, describe = ?, executionTime = ? WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, service.getNameService());
//            statement.setDouble(2, service.getPrice());
//            statement.setString(3, service.getDescribe());
//            statement.setTime(4, Time.valueOf(service.getExecutionTime()));
//            statement.setLong(5, service.getId());
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean deleteService(long id) {
//        String sql = "DELETE FROM Service WHERE id = ?";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
