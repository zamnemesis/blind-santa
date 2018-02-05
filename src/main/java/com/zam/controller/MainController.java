package com.zam.controller;

import com.zam.model.Party;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * author tarasenko
 * since  12.01.2018
 */
@Controller
public class MainController {

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

    @RequestMapping(value = "/createParty", method = RequestMethod.POST)
    public String createParty(@ModelAttribute("party") Party party, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("errorText", result.toString());
            return "error";
        }
        System.out.println(party.getLocation());
        // add values for model
        model.addAttribute("location", party.getLocation());
        model.addAttribute("message", party.getMessage());
        model.addAttribute("date", party.getDate());
        return "mailPreview";
    }
}
