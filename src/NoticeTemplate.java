
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class NoticeTemplate {

    String title;

    NoticeTemplate(String title) {
        this.title = title;
    }

    public void run() throws IOException {
        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        //create image object
        PDImageXObject image1 = PDImageXObject.createFromFile("src\\Photos\\nstu_logo.png", document);

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        //contentStream.drawImage(image1, 25, 700);
        contentStream.drawImage(image1, 45, 710, 50, 72);
        contentStream.drawLine(50, 708, 550, 708);
        int xEnd;
        int xBegin;
        if (title == "OFFICE ORDER") {
            xBegin = 252;
            xEnd = xBegin+108;
            
        } else {
            xBegin = 270;
            xEnd = 325;
        }
        contentStream.drawLine(xBegin, 655, xEnd, 655);
        // Define a text content stream using the selected font
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(100, 760);
        contentStream.setLeading(14.5f);

        contentStream.showText("Noakhali Science and Technology");
        contentStream.newLine();
        contentStream.showText("                    University");
        contentStream.newLine();
        contentStream.showText("        Sonapur, Noakhali-3814");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 8);
        contentStream.newLineAtOffset(302, 760);
        contentStream.setLeading(10.5f);
        contentStream.showText("Phone  :  0321 62833");
        contentStream.newLine();
        contentStream.showText("Fax       :  0321 62788");
        contentStream.newLine();
        contentStream.showText("Mobile  : 01836 350 710");
        contentStream.newLine();
        contentStream.showText("Email:ictnstu@gmail.com");
        contentStream.newLine();
        contentStream.showText("Website: www.nstu.edu.bd");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(410, 760);
        contentStream.setLeading(14.5f);
        contentStream.showText("Department of Information");
        contentStream.newLine();
        contentStream.showText("     and Communication");
        contentStream.newLine();
        contentStream.showText("           Engineering");
        contentStream.endText();

        //Date
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.newLineAtOffset(50, 695);
        contentStream.showText("Date: ");
        contentStream.endText();

        //Title
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 14);
        contentStream.newLineAtOffset(xBegin, 660);
        contentStream.showText(title);
        contentStream.endText();

        //Designation
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.newLineAtOffset(50, 250);
        contentStream.setLeading(14.5f);
        contentStream.showText("Prof. Dr. Md. Ashikur Rahman Khan");
        contentStream.newLine();
        contentStream.showText("Chairman");
        contentStream.newLine();
        contentStream.showText("Department of Information and Communication Engineering");
        contentStream.newLine();
        contentStream.showText("Noakhali Science and Technology University");
        contentStream.endText();

        // Make sure that the content stream is closed:
        contentStream.close();
        // Save the results and ensure that the document is properly closed:
        document.save("Office_order_Template.pdf");
        document.close();
    }

}
