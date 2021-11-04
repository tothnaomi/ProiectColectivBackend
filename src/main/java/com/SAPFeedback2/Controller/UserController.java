package com.SAPFeedback2.Controller;

//import com.SAPFeedback2.Model.User;
//import com.SAPFeedback2.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;

/**
 * HERE WE WILL CALL ONLY THE HTTPCLIENT IN EVERY FUNCTION !!
 * POST: add
 * PUT: update, delete
 * GET: read
 * DELETE: delete
 * here will we have the actual links: localhost.getAllUsers... HTTPClient
 */
//@RestController
//public class UserController {
//    private final UserService userService;
//
//    // dependency injection
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // --------------------------------- HTTP CLIENT ---------------------------------
//
//    @GetMapping("api/person/getAll")
//    public List<User> getAll() {
//        return userService.getAll();
//    }
//
//    @PostMapping("api/person/addPerson")
//    public void addUser(@RequestBody User user) {
//        System.out.println(user.getName());
//        userService.addUser(user);
//    }
//
//    @GetMapping("api/person/getPersonById/{id}")
//    public User getUserById(@PathVariable("id") UUID id) {
//        return userService.getUserById(id).orElse(null);
//    }
//
//    @DeleteMapping("api/person/deletePersonById/{id}")
//    public int deleteUserById(@PathVariable("id") UUID id) {
//        return userService.deleteUser(id);
//    }
//
//    @PutMapping("api/person/updatePerson/{id}")
//    public int updatePerson(@PathVariable("id") UUID id, @RequestBody User newUser) {
//        return userService.updateUser(id, newUser);
//    }
//}
