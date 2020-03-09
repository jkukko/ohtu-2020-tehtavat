package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        String name = username.trim();
        String pw = password.trim();
        char[] pw_palat = pw.toCharArray();
        if (name.length() < 3 || pw.length() < 8) {
            return true;
        }
        
        if (name.matches(".*[^a-z].*")) {
            return true;
        }
        
        boolean specialCase = false;
        // Here we test that pw includes either number or special character
        for (int i = 0; i < pw_palat.length; i++) {
 
            if (pw.charAt(i) < 64 || pw.charAt(i) > 122 || 
               (pw.charAt(i) > 90 && pw.charAt(i) < 97)) {
                specialCase = true;
            }
        }
        
        if (specialCase == false) {
            return true;
        }
        
        return false;
    }
}
