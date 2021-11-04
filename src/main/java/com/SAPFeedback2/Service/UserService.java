//package com.SAPFeedback2.Service;
//
//import com.SAPFeedback2.Dao.UserDao;
//import com.SAPFeedback2.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * in our project it does not have sense to have a service and a repository, but in complexer projects here would we have the logic of the applciation
// */
//@Service
//public class UserService {
//
//    private final UserDao userDAO;
//
//    // we use annotations to instantiate beans
//    @Autowired
//    public UserService(@Qualifier("postgres") UserDao userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    public int addUser(User user) {
//        return userDAO.insertUser(user);
//    }
//
//    public List<User> getAll() {
//        return userDAO.selectAll();
//    }
//
//    public Optional<User> getUserById(UUID id) {
//        return userDAO.selectUserById(id);
//    }
//
//    public int deleteUser(UUID id) {
//        return userDAO.deleteUserById(id);
//    }
//
//    public int updateUser(UUID id, User newUser) {
//        return userDAO.updateUserById(id, newUser);
//    }
//}
