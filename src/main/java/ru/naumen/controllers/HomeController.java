package ru.naumen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.model.StudentDao;

import javax.inject.Named;

/**
 * @author aarkaev
 */
@Controller
public class HomeController {

    @Autowired @Qualifier("jpaStudentDao")
    private StudentDao storage;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        model.addAttribute("allStudents", storage.findAll());
        return "index";
    }
}
