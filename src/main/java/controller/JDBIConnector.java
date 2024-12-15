package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


public class JDBIConnector {
    public  static Jdbi jdbi;
    public static Jdbi getJdbi() {
        if (jdbi == null) {
            connect();
        }
        return jdbi;
    }
    public static void connect() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://"+Property.HOST+":"+Property.POST+"/"+Property.DBNAME);
        dataSource.setUser(Property.USER);
        dataSource.setPassword(Property.PASSWORD);
        try {
            dataSource.setAutoReconnect(true);
            dataSource.setUseCompression(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbi = Jdbi.create(dataSource);
    }

    public static void main(String[] args) {
List<User> users = JDBIConnector.getJdbi().withHandle(handle->{
    return handle.createQuery("SELECT * FROM USERS").mapToBean(User.class).list();
});
    System.out.println(users);
    }
}
