///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package banglapdftobangladoc;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.usermodel.Paragraph;
//
//public class DocCreater {
//
//    public static void createDocFile(String fileName) {
//
//        try {
//            File file = new File(fileName);
//            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
//
//            HWPFDocument doc = new HWPFDocument();
//            Paragraph tempParagraph = doc.createParagraph();
//            HWPFRun tempRun = tempParagraph.createRun();
//
//            tempRun.setText("This is a Paragraph");
//            tempRun.setFontSize(12);
//            doc.write(fos);
//            fos.close();
//
//            System.out.println(file.getAbsolutePath() + " created successfully!");
//
//        } catch (Exception e) {
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        //create docx file
//        createDocFile("C:\\DocxFile.docx");
//
//        //create doc file
//        createDocFile("C:\\DocFile.doc");
//
//    }
//}