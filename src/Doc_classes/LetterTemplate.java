package Doc_classes;

import Test_classes.PDFWithImages;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class LetterTemplate {

    public void run() throws IOException, Exception {
        // Create a document and add a page to it
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//
//        //create image object
//        PDImageXObject image1 = PDImageXObject.createFromFile("src\\Photos\\nstu_logo.png", document);
//
//        // Start a new content stream which will "hold" the to be created content
//        PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//        contentStream.drawImage(image1, 50, 713, 50, 72); // nstu logo
//        
//        
//        //Draw horizontal Line
//        contentStream.moveTo(50, 708); // moves "pencil" to a position
//        contentStream.lineTo(565, 708);     // creates an invisible line to another position
//        contentStream.stroke();
//        
//        // Make sure that the content stream is closed:
//        contentStream.close();
//        
//        // Save the results and ensure that the document is properly closed:
//        document.save("LetterTemplate.pdf");
//        document.close();
    }

}
