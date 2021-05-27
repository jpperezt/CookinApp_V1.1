package com.cooking.accessingdata;

import com.cooking.accessingdata.User;
import com.cooking.accessingdata.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
    private AppUserDAO appUserDAO;
	
	// standard constructors
    
    private final UserRepository userRepository;
    private List<User> users;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //list users
    @GetMapping("/users")
    public List<User> getUsers() {
    	users = (List<User>) userRepository.findAll();
    	return users;
    }
    
    //create operation
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    //for delete operation
    @DeleteMapping("/users/{user_id}")
   	public ResponseEntity<Void> deleteUser(@PathVariable("user_id") int user_id) {	
    	System.out.println("inside delete method User = " + user_id);
    	userRepository.deleteById(user_id);
    	//users.remove(user_id);
    	return ResponseEntity.noContent().build();
    	//return "user deleted successfully!!";
   	}
    
    /*for update operation
    @PutMapping("/users/updateuser/{id}")
    public String updateuserId(@PathVariable("user_id") int  user_id){
        System.out.print("inside update method User = " + user_id);
        Optional<User> testEntity = userRepository.findById(user_id);
        //testEntity.map(s->{s.setCourseName("Angular") ;
        userRepository.save(s);
        return "user updated!!";
        });
        return "updated successfully!!";
    }*/
    
    // Login Operation - get user info
    @GetMapping("/users/{user_name}")
    public User getUser(String user_name) {
    	User user = this.appUserDAO.findUserAccount(user_name);
    	return user;
    }
    
}
