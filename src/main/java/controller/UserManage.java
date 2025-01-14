package controller;

import java.util.List;

public class UserManage {
    private List<User> users;

    public UserManage() {
    loadUsers();
    }

    public static String getUsers(String username)
    {
        return username;
    }

    private void loadUsers() {
         this.users = JDBIConnector.getJdbi().withHandle(handle->{
            return handle.createQuery("SELECT * FROM USERS").mapToBean(User.class).list();
        });

    }

    public List<User> getUsers() {

        return this.users;
    }
    public User findUser(String username){

        for(User user : users){
            if(user.getUsername()!= null && user.getUsername().equalsIgnoreCase(username)){
                return user;
            }

        }
        return null;
    }
}
