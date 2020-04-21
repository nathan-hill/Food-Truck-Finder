package com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Tess implements Algo {
    @Override
    public String getWords(String filename) {
        ITesseract instance = new Tesseract();
        try
        {
            String imgText = instance.doOCR(new File(filename))
                    .replaceAll("[^\\x00-\\x7F]", "")
                    .replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "")
                    .replaceAll("\\p{C}", "");
            return imgText;
        }
        catch (TesseractException e)
        {
            e.getMessage();
            return "Error while reading image";
        }
    }
}
