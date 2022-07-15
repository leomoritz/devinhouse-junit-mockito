package com.muller.devincars.service;

import com.muller.devincars.model.Car;
import com.muller.devincars.repository.CarRepository;
import com.muller.devincars.util.CreateCar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepositoryMock;

    private final Car carToCompare = CreateCar.carValid();
    private final List<Car> carList = CreateCar.createListCar();

    @Test
    public void findById_shouldReturnCarWhenIdIsValid(){
        //Arrange
        when(carRepositoryMock.findById(carToCompare.getId())).thenReturn(Optional.of(carToCompare));

        //Act
        Optional<Car> carReturned = carService.findById(carToCompare.getId());

        //Assert
        assertEquals(carReturned.get(), carToCompare);
    }

    @Test
    public void findAll_shouldReturnAllCars(){
        //Arrange
        when(carRepositoryMock.findAll()).thenReturn(carList);

        //Act
        List<Car> carListReturned = carService.findAllCars();

        //Assert
        assertEquals(carListReturned, carList);
        assertEquals(carListReturned.size(), carList.size());
    }




}