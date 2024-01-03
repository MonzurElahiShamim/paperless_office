package Doc_classes;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class MarkSheetApplication {
    
    public static void main(String[] args) throws IOException {
        create("new","1","1","2","1","Monzur Elahi Shamim","ASH1911012M","2018-19","Nur Nabi Chowdhury", "75892345", "016-xxxx-xxxx");
    }

    public static void create(String type, String mYear, String mTerm, String cYear, String cTerm, String stName, String stRoll, String stSession, String FatherName, String BankReceiptNo, String stMobile) throws IOException {
        // Create a document and add a page to it
        float font_size = 14;
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Define a text content stream using the selected font
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
        contentStream.newLineAtOffset(50, 730);
        contentStream.setLeading(1.3f * font_size);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String str_date = formatter.format(date);
        contentStream.showText("Date: " + str_date);
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("To");
        contentStream.newLine();
        contentStream.showText("Chairman");
        contentStream.newLine();
        contentStream.showText("Department of Information and Communication Engineering");
        contentStream.newLine();
        contentStream.showText("Noakhali Science and Technology University");
        contentStream.newLine();
        contentStream.showText("Noakhali-3814");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Sub: Application for issuing " + type + " mark sheet of  Year-0" + mYear + ", Term-0" + mTerm + ".");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Sir,");
        contentStream.newLine();
        contentStream.showText("I beg to state that, I am a regular student of your department of  Year-0" + cYear + ", Term-0" + cTerm + ". For my");
        contentStream.newLine();
        contentStream.showText("personal use I need the above mentioned mark sheet. My details are given below.");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Therefore, I request you to kindly issue my mark sheet as soon as possible and oblige thereby.");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Details Necessary to process the request:");
        contentStream.newLine();
        contentStream.showText("Name: " + stName);
        contentStream.newLine();
        contentStream.showText("Father's Name: " + FatherName);
        contentStream.newLine();
        contentStream.showText("Bank Receipt No: " + BankReceiptNo);
        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Yours Sincerely");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText(stName);
        contentStream.newLine();
        contentStream.showText("ID: " + stRoll);
        contentStream.newLine();
        contentStream.showText("Current Year-0" + cYear + ", Term-0" + cTerm + "          Session: " + stSession);
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Department of Information and Communication Engineering");
        contentStream.newLine();
        contentStream.showText("Noakhali Science and Technology University");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Mobile: " + stMobile);
        
        contentStream.endText();
        
        
        // Make sure that the content stream is closed:
        contentStream.close();
        // Save the results and ensure that the document is properly closed:
        document.save("marksheetApplication.pdf");
        document.close();
    }
}
