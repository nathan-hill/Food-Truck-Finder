package com.software2.foodtruckfinder.secure.service.ImageProcessingAlgo;


import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Google implements Algo {
    @Override
    public String getWords(String fileName) {
        // Instantiates a client

        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

            // Reads the image file into memory
            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);
            ByteString imgBytes = ByteString.copyFrom(data);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
            AnnotateImageRequest request =
                    AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.printf("Error: %s\n", res.getError().getMessage());
                    return "";
                }

                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                    annotation
                            .getAllFields()
                            .forEach((k, v) -> System.out.printf("%s : %s\n", k, v.toString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
