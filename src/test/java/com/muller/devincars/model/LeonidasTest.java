package com.muller.devincars.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class LeonidasTest {

    private LeonidasEntity leonidasEntity;
    private UUID leonidasId = UUID.fromString("a974b67e-0473-11ed-b939-0242ac120002");

    @Before
    public void setUp() {
        leonidasEntity = new LeonidasEntity(leonidasId, "Leônidas Guilherme Moritz Pereira Rosa", 27, "Blumenau", "Desenvolvedor");
    }


    @Test
    public void findLeonidas_shouldReturnSuccessWhenLeonidasIsValid() {
        // Arrange
        LeonidasEntity leonidasReturn = new LeonidasEntity(leonidasId, "Leônidas Guilherme Moritz Pereira Rosa", 27, "Blumenau","Desenvolvedor");

        //Assert
        assertEquals(leonidasEntity, leonidasReturn);
    }

}
