package com.muller.devincars.service;

import com.muller.devincars.model.Dev;
import com.muller.devincars.repository.DevRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DevServiceTest {

    @InjectMocks
    DevService devService;

    @Mock
    DevRepository devRepository;

    private Dev devToCompare;

    @BeforeEach
    public void setUp(){
        devToCompare = new Dev(UUID.randomUUID(), "Desenvolvedor Java", "DEVINHOUSE", "Senior Sistemas", 2021);
    }

    @Test
    public void findById_shouldReturnDevWhenIdIsValid(){
        //Arrange
        when(devRepository.findById(devToCompare.getId())).thenReturn(Optional.of(devToCompare));

        //Act
        Optional<Dev> devReturned = devService.findById(devToCompare.getId());

        //Assert
        assertEquals(devReturned.get(), devToCompare);
    }

    @Test
    public void saveDev_shouldSaveWhenDevIsValid(){
        //Arrange
        when(devRepository.save(devToCompare)).thenReturn(devToCompare);

        //Act
        Dev devReturned = devService.saveDev(devToCompare);

        //Assert
        assertEquals(devReturned, devToCompare);
    }

}
