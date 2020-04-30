package com.software2.foodtruckfinder.service;

import com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo.Tess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TessTest {
    @DisplayName("Tess Test")
    @Test
    void tessTest(){
        byte[] buf = new byte[]{0x1, 0x2, 0x4e, 0x5a};
        Tess t = new Tess();

        assertNotNull(t.getWords(buf));
    }
}
