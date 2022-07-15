package com.muller.devincars.service;

import com.muller.devincars.model.Dev;
import com.muller.devincars.repository.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DevService {

    private final DevRepository devRepository;

    @Autowired
    public DevService(DevRepository devRepository) {
        this.devRepository = devRepository;
    }

    public Dev saveDev(Dev newDev){
        return devRepository.save(newDev);
    }

    public Optional<Dev> findById(UUID id){
        return devRepository.findById(id);
    }

}
