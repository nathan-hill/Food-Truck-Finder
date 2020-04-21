package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo.Aspose;
import com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo.Google;
import com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo.Tess;
import net.sourceforge.tess4j.*;
import java.io.*;
public class MenuService {


    public static void main ( String[] args)
    {
        Tess t = new Tess();
        Aspose a = new Aspose();
        Google g = new Google();
        String filePath = "./images/Sergios.jpg";
//        System.err.println(t.getWords(filePath));
//        System.err.println(a.getWords(filePath));
        System.err.println(g.getWords(filePath));
    }
}