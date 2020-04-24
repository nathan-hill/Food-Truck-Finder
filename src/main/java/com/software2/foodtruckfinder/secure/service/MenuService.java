package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo.Tess;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuService {

    public static ByteArrayOutputStream convertFormat(byte[] data, String formatName) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // reads input image from array
        BufferedImage inputImage = ImageIO.read(inputStream);

        // writes to the output image in specified format
        boolean result = ImageIO.write(inputImage, formatName, outputStream);

        outputStream.toByteArray();

        // needs to close the streams
        outputStream.close();
        inputStream.close();

        return outputStream;
    }

    public static void main ( String[] args)
    {
        Tess t = new Tess();
//        byte[] data = new File("./images/menu.jpg");
//        System.err.println(t.getWords("./images/menu.jpg"));
//        System.err.println(a.getWords(filePath));
        //System.err.println(g.getWords(filePath));
    }
}