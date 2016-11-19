package ru.naumen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.model.StudentDao;

/**
 * @author aarkaev
 */
@Controller
public class HomeController {

    @Autowired
    private StudentDao storage;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        model.addAttribute("allStudents", storage.findAll());
        return "index";
    }
}
