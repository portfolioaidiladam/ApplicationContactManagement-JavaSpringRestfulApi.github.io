package BelajarSpringbootRestfullAPIaidil.restful.controller;

import BelajarSpringbootRestfullAPIaidil.restful.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import BelajarSpringbootRestfullAPIaidil.restful.entity.User;


import BelajarSpringbootRestfullAPIaidil.restful.model.RegisterUserRequest;
import BelajarSpringbootRestfullAPIaidil.restful.model.UpdateUserRequest;
import BelajarSpringbootRestfullAPIaidil.restful.model.WebResponse;
import BelajarSpringbootRestfullAPIaidil.restful.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }



    @PatchMapping(
            path = "/api/users/current",

            // karena ada bodynya
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request) {
        UserResponse userResponse = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }
}
