package coursework.howwiki.controller;



import coursework.howwiki.model.User;
import coursework.howwiki.repository.UserRepository;
import coursework.howwiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/getUser", method = RequestMethod.GET)
    public void getUser() {
        userRepository.findAll();
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public void getVoid(){
        System.out.println("Hello");
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public Boolean registrationPut(@RequestBody User user){
        return userService.registration(user) ;
    }

}
