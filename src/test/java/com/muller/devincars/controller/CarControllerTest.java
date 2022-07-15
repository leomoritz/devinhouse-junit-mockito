package com.muller.devincars.controller;

import com.muller.devincars.model.Car;
import com.muller.devincars.service.CarService;
import com.muller.devincars.util.CreateCar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CarControllerTest {

    @InjectMocks
    CarController carController;

    @Mock
    CarService carService;

    private final Car carToCompare = CreateCar.carValid();

    @Test
    public void addCar_shouldReturnCarWhenSaveSuccessfully(){
        //Arrange
        when(carService.save(carToCompare)).thenReturn(carToCompare);

        //Act
        Car carReturned = carController.addCar(carToCompare);

        //Assert
        assertEquals(carReturned, carToCompare);
    }

    @Test
    public void deleteCarById_shouldDeleteCarWhenIdIsValid(){
        //Arrange
        carToCompare.setId(222L);
        doNothing().when(carService).remove(carToCompare.getId());

        //Act
        carController.deleteCarById(carToCompare.getId());

        //Assert
        verify(carService).remove(carToCompare.getId());
    }

}
