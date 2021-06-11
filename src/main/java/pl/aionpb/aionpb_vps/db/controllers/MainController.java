package pl.aionpb.aionpb_vps.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        return "index";
    }


}