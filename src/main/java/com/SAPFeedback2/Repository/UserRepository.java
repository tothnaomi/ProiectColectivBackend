//package com.SAPFeedback2.Repository;
//
//import com.SAPFeedback2.Dao.UserDao;
//import com.SAPFeedback2.Model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("postgres")
//public class UserRepository implements UserDao {
//
//    private static List<User> userList = new ArrayList<>();
//
//    @Override
//    public int insertUser(UUID id, User user) {
//        userList.add(new User(id, user.getName()));
//        return 1;
//    }
//
//    @Override
//    public List<User> selectAll() {
//        return userList;
//    }
//
//    @Override
//    public Optional<User> selectUserById(UUID id) {
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public int deleteUserById(UUID id) {
//        Optional<User> person = selectUserById(id);
//
//        if (person.isEmpty()) {
//            // the person with this id is not in the database
//            return 0;
//        }
//        else {
//            userList.remove(person.get());
//            return 1;
//        }
//    }
//
//    @Override
//    public int updateUserById(UUID id, User newUser) {
//        return selectUserById(id)
//                .map(user -> {
//                    int indexUserToUpdate = userList.indexOf(user);
//                    if (indexUserToUpdate >=0 ) {
//                        // we found the person in the database
//                        userList.set(indexUserToUpdate, new User(id, newUser.getName()));
//                        return 1;
//                    }
//                    return 0;
//                }).orElse(0);
//    }
//}

