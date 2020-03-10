package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        if (password.length()<8) {
            status.addError("password should have at least 8 characters");
        }
        
        if (!password.endsWith(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        
        if (invalid(username, password)) {
            status.addError("invalid username or password");
        }
        

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    
    private boolean invalid(String username, String password) {
        // validity check of username and password
        String name = username.trim();
        String pw = password.trim();
        char[] pw_palat = pw.toCharArray();
        // test that name only have small characters
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
