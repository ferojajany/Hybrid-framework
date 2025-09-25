package com.cucumber.comonServieses;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class PDFReader {
    public List<String> getPDFMathod(String path) throws IOException {
        File file = new File(path);
        //For loading file

        PDDocument pdDocument = PDDocument.load(file);
        //pre define class
        PDFTextStripper stripper = new PDFTextStripper();
        // To get getText
        String stripText = stripper.getText(pdDocument);
        Stream<String> lines = stripText.lines();
        pdDocument.close();
        return lines.toList();
    }
}
