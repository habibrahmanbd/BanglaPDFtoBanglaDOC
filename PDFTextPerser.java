///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package banglapdftobangladoc;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.pdfbox.cos.COSDocument;
//import org.apache.pdfbox.pdfparser.FDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//
//public class PDFTextPerser {
//
//    // Extract text from PDF Document
//    static String pdftoText(String fileName) {
//        FDFParser parser;
//        String parsedText = null;;
//        PDFTextStripper pdfStripper = null;
//        PDDocument pdDoc = null;
//        COSDocument cosDoc = null;
//        File file = new File(fileName);
//        if (!file.isFile()) {
//            System.err.println("File " + fileName + " does not exist.");
//            return null;
//        }
//        try {
//            parser = new FDFParser(new FileInputStream(file));
//        } catch (IOException e) {
//            System.err.println("Unable to open PDF Parser. " + e.getMessage());
//            return null;
//        }
//        try {
//            parser.parse();
//            cosDoc = parser.getDocument();
//            pdfStripper = new PDFTextStripper();
//            pdDoc = new PDDocument(cosDoc);
//            pdfStripper.setStartPage(1);
//            pdfStripper.setEndPage(5);
//            parsedText = pdfStripper.getText(pdDoc);
//        } catch (Exception e) {
//            System.err.println("An exception occured in parsing the PDF Document."
//                    + e.getMessage());
//        } finally {
//            try {
//                if (cosDoc != null) {
//                    cosDoc.close();
//                }
//                if (pdDoc != null) {
//                    pdDoc.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//        return parsedText;
//    }
//}