package com.orient.crudspringphone.service.impl;

import com.orient.crudspringphone.model.Phone;
import com.orient.crudspringphone.repository.PhoneRepository;
import com.orient.crudspringphone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServicelmpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        List<Phone> pp = phoneRepository.findAll();
        return pp;
    }

    @Override
    public Phone findById(Long id) {

        Phone phone = null;

        try {

            phone = phoneRepository.findById(id).get();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return phone;

    }

    @Override
    public void create(Phone phone) {

        phoneRepository.save(phone);

    }

    @Override
    public void update(Phone phone, Long id) {

        Phone oldPhone = findById(id);
        oldPhone.setName(phone.getName());
        oldPhone.setMark(phone.getMark());
        oldPhone.setId(phone.getId());
        oldPhone.setPrice(phone.getPrice());
        phoneRepository.save(oldPhone);

    }

    @Override
    public void delete(Long id) {

        Phone phone = findById(id);

        if (phone != null){
            phoneRepository.delete(phone);
        }

    }
}
