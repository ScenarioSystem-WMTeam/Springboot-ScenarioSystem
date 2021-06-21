package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.repo.ManageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageController {
    @Autowired
    private ManageRepo manageRepo;

}
