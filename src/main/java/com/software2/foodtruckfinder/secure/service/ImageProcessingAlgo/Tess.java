package com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Tess implements Algo {
    @Override
    public String getWords(byte[] fileData) {
        ITesseract instance = new Tesseract();
        try
        {
            InputStream in = new ByteArrayInputStream(fileData);
            BufferedImage bImageFromConvert = ImageIO.read(in);

            return instance.doOCR(bImageFromConvert)
                    .replaceAll("[^a-zA-Z0-9()]", "");
        }
        catch (TesseractException | IOException e)
        {
            e.getMessage();
            return "Error while reading image";
        }
    }
}
