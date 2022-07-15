package com.muller.devincars.repository;

import com.muller.devincars.model.Dev;
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
public class DevRepositoryTest {

    @Mock
    DevRepository devRepository;

    private Dev devToCompare;

    @BeforeEach
    public void setUp(){
        devToCompare = new Dev(UUID.fromString("5b027c2e-0482-11ed-b939-0242ac120002"), "Java Orientado a Objetos", "DEVINHOUSE", "Senior Sistemas", 2021);
    }

    @Test
    public void findById_shouldReturnDevWhenIdIsValid(){
        //Arrange
        when(devRepository.findById(devToCompare.getId())).thenReturn(Optional.of(devToCompare));

        //Act
        Optional<Dev> devReturned = devRepository.findById(devToCompare.getId());

        //Assert
        assertEquals(devReturned.get(), devToCompare);
    }

    @Test
    public void saveDev_shouldReturnDevWhenSaveSuccessfully(){
        //Arrange
        Dev devToSave = new Dev(UUID.randomUUID(), "Testes Unitários com Karma e Jasmine", "DEVINHOUSE", "Senior Sistemas", 2022);
        when(devRepository.save(devToSave)).thenReturn(devToSave);

        //Act
        Dev devReturned = devRepository.save(devToSave);

        //Assert
        assertEquals(devToSave, devReturned);
    }

}
