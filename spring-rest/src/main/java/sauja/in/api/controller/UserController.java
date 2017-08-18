package sauja.in.api.controller;

import org.springframework.web.bind.annotation.*;
import sauja.in.api.entities.Users;
import sauja.in.api.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Users> findAll()
    {
        return userService.findAll();
    }


    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Users getUser(@PathVariable("id") String id)
    {
        System.out.println("User "+id +" "+userService.getUser(id));
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteUser(@PathVariable("id") String id)
    {
        userService.deleteUser(id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public void modifyUser(@PathVariable String id,@RequestBody Users users)
    {
        userService.modifyUser(id, users);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody Users users)
    {
        userService.createUser(users);
    }
}
