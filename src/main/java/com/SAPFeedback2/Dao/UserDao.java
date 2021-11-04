//package com.SAPFeedback2.Dao;
//
//import com.SAPFeedback2.Model.User;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public interface UserDao {
//    // here will we define the operations allowed for the User model
//
//    int insertUser(UUID id, User user);
//
//    default int insertUser(User user) {
//        UUID id = UUID.randomUUID();
//        return insertUser(id, user);
//    }
//
//    List<User> selectAll();
//
//    Optional<User> selectUserById(UUID id);
//
//    int deleteUserById(UUID id);
//
//    int updateUserById(UUID id, User newUser);
//}
