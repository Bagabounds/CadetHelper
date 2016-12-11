package org.academiadecodigo.cadetHelper.Controller;

import org.academiadecodigo.cadetHelper.Model.Cadet;
import org.academiadecodigo.cadetHelper.Service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private FakeService fakeService;
    @RequestMapping(value = "/", method ={ RequestMethod.GET})
    public String index(){
            return "index";
    }

    @RequestMapping(method ={RequestMethod.POST})
    public String post(){
        return "register";
    }



}

