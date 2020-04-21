package com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo;

import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;

public class Aspose implements Algo {
    @Override
    public String getWords(String filename) {
        // create an instance
        OcrEngine engine = new OcrEngine();
        // set image file
        engine.setImage(ImageStream.fromFile(filename));
        // process the image
        engine.process();
        // Image to Text results
        return engine.getText().toString();
    }
}
