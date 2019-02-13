
package com.client.app.springangular.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * LoginController
 */
@RestController
public class WebLoginController {

    @RequestMapping(value="my/login")
    public String login() {
        return "My login Page";
    }
    @RequestMapping(value="my/logout")
    public String logout() {
        return "logout";
    }
    @RequestMapping(value="my/login/error")
    public String error() {
        return "Error Page";
    }
    
}