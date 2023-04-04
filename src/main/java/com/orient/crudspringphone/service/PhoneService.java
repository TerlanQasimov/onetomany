package com.orient.crudspringphone.service;

import com.orient.crudspringphone.model.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneService {

    List<Phone> findAll();

    Phone findById(Long id);

    void create(Phone phone);

    void update(Phone phone,Long id);

    void delete(Long id);
}
