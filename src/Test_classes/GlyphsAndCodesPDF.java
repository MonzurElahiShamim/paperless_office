package Test_classes;

import java.awt.Font;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class GlyphsAndCodesPDF {

    public static void main(String[] args) {
        try {
            // Replace "PathToYourFont.ttf" with the path to your TTF or OTF font file
            String fontPath = "E:\\FONTS\\Shonar.ttf";
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, GlyphsAndCodesPDF.class.getClassLoader().getResourceAsStream(fontPath));

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(font, 12);

            int x = 50, y = 700;

            for (int charCode = 32; charCode <= 126; charCode++) {
                String text = String.valueOf((char) charCode);
                contentStream.beginText();
                contentStream.newLineAtOffset(x, y);
                contentStream.showText(text);
                contentStream.endText();

                System.out.println("Character: " + text + ", Code: " + charCode);

                y -= 15;

                if (y < 50) {
                    // Move to the next column
                    x += 100;
                    y = 700;
                }
            }

            contentStream.close();

            // Save the document
            document.save("GlyphsAndCodes.pdf");
            document.close();

            System.out.println("PDF created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
