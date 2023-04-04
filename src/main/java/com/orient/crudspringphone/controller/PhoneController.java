package com.orient.crudspringphone.controller;

import com.orient.crudspringphone.model.Phone;
import com.orient.crudspringphone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/phone")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/all")
    public List<Phone> findAll() {

        List<Phone> cc = phoneService.findAll();
        return cc;

    }

    @GetMapping(value = "/{id}")
    public Phone findByID(@PathVariable Long id){

        Phone phone = phoneService.findById(id);
        return phone;

    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){

        phoneService.delete(id);

    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Phone phone){

        phoneService.create(phone);

    }

    @PutMapping(value = "/update/{id}")
    public void update(@RequestBody Phone phone, @PathVariable Long id){

        phoneService.update(phone,id);

    }

}
