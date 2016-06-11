/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bp2bd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/**
 *
 * @author Habib Rahman
 */
public class ConvertProcessor {

    /**
     * @param args the command line arguments
     */
    public static void Run(String args, String str2) throws IOException {
        // TODO code application logic here
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath(args);
//        System.out.print(pdfManager.ToText());

        File file = new File(str2 + "/Doc_Converted.doc");
        // creates the file
        file.createNewFile();
        // creates a FileWriter Object

        CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPORT);
        encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoder));
        // Writes the content to the file

        out.write(pdfManager.ToText());
        out.flush();
        out.close();

//        PDFTextPerser uPerser = new PDFTextPerser();
//        System.out.print(PDFTextPerser.pdftoText("E:/topcoder.pdf"));
    }
}
