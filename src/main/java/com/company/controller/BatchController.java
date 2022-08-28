package com.company.controller;

import com.company.dao.PersonDAO;
import com.company.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/test")
public class BatchController {
        @Autowired
        private PersonDAO personDAO;

        @GetMapping()
        public String index(){
            return "batch/index";
        }
        @GetMapping("/without")
        public String withoutBatch(){
            personDAO.testUpdate();
            return "redirect:/people";
        }
    @GetMapping("/with")
    public String withBatch(){
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
    }

