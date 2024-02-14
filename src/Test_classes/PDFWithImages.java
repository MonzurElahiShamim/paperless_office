package Test_classes;

import Test_classes.TextToImage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PDFWithImages {

//    private static final PDFont FONT = PDType1Font.TIMES_ROMAN;
    private static final String BENGALI_FONT_PATH = "E:/FONTS/Nikosh.ttf";  // Adjust the path
    private static final PDFont FONT;

    static {
        try (InputStream inputStream = new FileInputStream(new File(BENGALI_FONT_PATH))) {
            PDDocument tempDocument = new PDDocument();
            FONT = PDType0Font.load(tempDocument, inputStream, false);
            //tempDocument.close();
        } catch (IOException e) {
            throw new RuntimeException("Error loading Bengali font.", e);
        }
    }
    private static final float FONT_SIZE = 12;
    private static final float LEADING = -1.5f * FONT_SIZE;

    public static void main(String[] args) throws Exception {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            String textPara = "হাসিটি হেথায় বাজারে বিকায় গানের বেসাত করি, হেথাকার লোক সুরের পরাণ ধরে মানে লয় ভরি। হয়ত তাহাও জানে না সে মেয়ে জানে না কুসুম-হার, এত যে আদরে গাঁথিছে সে তাহা গলায় দোলাবে কার? মোদের মথুরা টরমল করে পাপ-লালসার ভারে, ভোগের সমিধ জ্বালিয়া আমরা পুড়িতেছি বারে বারে। এখনো আসেনি অলি, মধুর লোভেতে কোমল কুসুম দুপায়েতে দলি দলি। সেথায় তোমার কিশোরী বধূটি মাটির প্রদীপ ধরি, তুলসীর মূলে প্রণাম যে আঁকে হয়ত তোমারে স্মরি।"
                    + "এখনো গোপন আঁধারের তলে আলোকের শতদল, মেঘে মেঘে লেগে বরণে বরণে করিতেছে টলমল। হায়রে করুণ হায়, এখনি যে সবে জাগিয়া উঠিবে প্রভাতের কিনারায়। এখনো পাখিরা উঠেনি জাগিয়া, শিশির রয়েছে ঘুমে, কলঙ্কী চাঁদ পশ্চিমে হেলি কৌমুদী-লতা চুমে। ঘরে ফিরে যাও সোনার কিশোর! এ পাপমথুরাপুরী, তোমার সোনার অঙ্গেতে দেবে বিষবান ছুঁড়ি ছুঁড়ি। সেথায় তোমার কিশোরী বধূটি মাটির প্রদীপ ধরি, তুলসীর মূলে প্রণাম যে আঁকে হয়ত তোমারে স্মরি।"
                    + "এখনো গোপন আঁধারের তলে আলোকের শতদল, মেঘে মেঘে লেগে বরণে বরণে করিতেছে টলমল। ঘরে ফিরে যাও সোনার কিশোর! এ পাপমথুরাপুরী, তোমার সোনার অঙ্গেতে দেবে বিষবান ছুঁড়ি ছুঁড়ি। মোদের মথুরা টরমল করে পাপ-লালসার ভারে, ভোগের সমিধ জ্বালিয়া আমরা পুড়িতেছি বারে বারে। মোদের মথুরা টরমল করে পাপ-লালসার ভারে, ভোগের সমিধ জ্বালিয়া আমরা পুড়িতেছি বারে বারে। আজিও চেননি সোনার আদর, চেননি মুক্তাহার, হাসি মুখে তাই সোনা ঝরে পড়ে তোমাদের যারতার।"
                    + "রঙের কুহেলী তলে, তোমার জীবন ঊষার আকাশে শিশু রবি সম জ্বলে। তুমিও হয়ত জান না কিশোর, সেই কিশোরীর লাগি, মনে মনে কত দেউল গেঁথেছে কত না রজনী জাগি। এখনো গোপন আঁধারের তলে আলোকের শতদল, মেঘে মেঘে লেগে বরণে বরণে করিতেছে টলমল। তুমি ভাই সেই ব্রজের রাখাল, পাতার মুকুট পরি, তোমাদের রাজা আজো নাকি খেলে গেঁয়ো মাঠখানি ভরি। হয়ত তাহারি অলকে বাঁধিতে মাঠের কুসুম ফুল, কতদূর পথ ঘুরিয়া মরিছ কত পথ করি ভুল।"
                    + "আজিও চেননি সোনার আদর, চেননি মুক্তাহার, হাসি মুখে তাই সোনা ঝরে পড়ে তোমাদের যারতার। আজিও চেননি সোনার আদর, চেননি মুক্তাহার, হাসি মুখে তাই সোনা ঝরে পড়ে তোমাদের যারতার। শূন্য হাওয়ার শূন্য ভরিতে বুকখানি করি শুনো, ফুলের দেউল হবে না উজাড় আজিকে প্রভাতে পুন। মোদের মথুরা টরমল করে পাপ-লালসার ভারে, ভোগের সমিধ জ্বালিয়া আমরা পুড়িতেছি বারে বারে। হেথা যৌবন মেলিয়া ধরিয়া জমা-খরচের খাতা, লাভ লেকাসান নিতেছে বুঝিয়া খুলিয়া পাতায় পাতা।";
            addParagraph(document, page, 100, textPara);

            document.save("TextToImageToPdfInBangla.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addLine(PDDocument document, PDPage page, int X, int Y, String line) throws Exception {
        final int defaultFontSize = 12;
        char plainChar = 'p';
        addLine(document, page, X, Y, defaultFontSize, line, plainChar);
    }

    public static void addLine(PDDocument document, PDPage page, int X, int Y, String line, char ch) throws Exception {
        final int defaultFontSize = 12;
        addLine(document, page, X, Y, defaultFontSize, line, ch);
    }

    public static void addLine(PDDocument document, PDPage page, int X, int Y, int fontSize, String line) throws IOException, Exception {
        char plainChar = 'p';
        addLine(document, page, X, Y, fontSize, line, plainChar);
    }

    public static void addLine(PDDocument document, PDPage page, int X, int Y, int fontSize, String line, char ch) throws IOException, Exception {
        PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);
        BufferedImage image = TextToImage.generateImage(line, ch);
        final float imageFontSize = 60;
        float imageScaleFactor = imageFontSize / fontSize;
        float lineWidth = image.getWidth() / imageScaleFactor;
        float lineHeight = image.getHeight() / imageScaleFactor;
        contentStream.drawImage(PDImageXObject.createFromByteArray(document, toByteArray(image), "image/png"),
                X,
                Y,
                lineWidth,
                lineHeight);
        contentStream.close();
    }

    public static void addHeader(PDDocument document, PDPage page) throws Exception {

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //A4: Height=841, Width=595
        int yPos = (int) page.getMediaBox().getHeight() - 50;
        int pageWidth = (int) page.getMediaBox().getWidth();

        //create image object for NSTU Logo
        PDImageXObject image1 = PDImageXObject.createFromFile("src\\Photos\\nstu_logo.png", document);
        contentStream.drawImage(image1, 50, yPos - 37, 50, 72); // nstu logo

        // University Name
        addLine(document, page, 105, yPos, 22, "নোয়াখালী বিজ্ঞান ও প্রযুক্তি", 'B');
        addLine(document, page, 160, yPos - 25, 22, "বিশ্ববিদ্যালয়", 'B');
        addLine(document, page, 150, yPos - 40, 14, "সোনাপুর, নোয়াখালী-৩৮১৪");

        // Contacts
        addLine(document, page, 325, yPos + 12, 10, "ফোনঃ ০৩২১ ৬২৮৩৩");
        addLine(document, page, 325, yPos - 1, 10, "ফ্যাক্সঃ ০৩২১ ৬২৭৮৮");
        addLine(document, page, 325, yPos - 14, 10, "মোবাইলঃ ০১৮৩৬ ৩৫০ ৭১০");
        addLine(document, page, 325, yPos - 27, 7, "Email: ice@office.nstu.edu.bd");
        addLine(document, page, 325, yPos - 40, 7, "Website: www.nstu.edu.bd");

        // Department Name
        addLine(document, page, 430, yPos - 10, 18, "তথ্য ও যোগাযোগ", 'B');
        addLine(document, page, 435, yPos - 30, 18, "প্রকৌশল বিভাগ", 'B');

        //Draw horizontal Line
        contentStream.moveTo(50, yPos - 42); // moves "pencil" to a position
        contentStream.lineTo(pageWidth - 50, yPos - 42);     // creates an invisible line to another position
        contentStream.stroke();

        // Make sure that the content stream is closed:
        contentStream.close();
    }

    //public static void drawLine(int xStart, int yStart, int xEnd, int yEnd){}
    public static void addDesignation(PDDocument document, PDPage page, int yPos) throws Exception {
        //Designation
        //int yPos = 190
        if (yPos >= 80) {
            int leftMargin = 68;
            PDFWithImages.addLine(document, page, leftMargin, yPos, "প্রফেসর ড. মোঃ আশিকুর রহমান খান");
            PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "চেয়ারম্যান");
            PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "তথ্য ও যোগাযোগ প্রকৌশল বিভাগ");
            PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "নোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");
        }
    }

    public static int addParagraph(PDDocument document, PDPage page, int yPos, String text) throws Exception {
        float startY = yPos;
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);
            PDRectangle mediaBox = page.getMediaBox();

            float marginX = 68;
            int widthAdjust = 20;
            float width = mediaBox.getWidth() - 2 * marginX;
            float startX = mediaBox.getLowerLeftX() + marginX;
            //float marginY = 170;
            //float startY = mediaBox.getUpperRightY() - marginY;

            // Existing code for adding paragraphs...
            String[] paragraphs = text.split("\n");  // Split the text at newline characters

            contentStream.setFont(FONT, FONT_SIZE);

            for (String paragraph : paragraphs) {
                java.util.List<String> lines = parseLines(paragraph, width - widthAdjust);
                for (String line : lines) {
                    // Create an image from the text
                    BufferedImage image = TextToImage.generateImage(line);
                    float imageScaleFactor = 5;
                    int lineWidth = (int) (image.getWidth() / imageScaleFactor);
                    int lineHeight = (int) (image.getHeight() / imageScaleFactor);
                    if (Math.abs(lineWidth - width) < 15) {
                        lineWidth = (int) (width);
                    }
                    
                    // Embed the image into the PDF document
                    contentStream.drawImage(PDImageXObject.createFromByteArray(document, toByteArray(image), "image/png"),
                            startX,
                            startY,
                            lineWidth,
                            lineHeight);
                    startY -= 20;
                    //System.out.println(lineWidth);
                }
            }

            contentStream.close();
        } catch (IOException e) {
        }
        return (int)startY;
    }

    private static java.util.List<String> parseLines(String text, float width) throws IOException, FontFormatException {
        java.util.List<String> lines = new ArrayList<>();
        String[] words = text.split("\\s+");

        StringBuilder currentLine = new StringBuilder();
        float currentWidth = 0;

        for (String word : words) {
            float wordWidth = getStringWidth(word);

            if (currentWidth + wordWidth <= width) {
                currentLine.append(word).append(" ");
                currentWidth += wordWidth;
            } else {
                lines.add(currentLine.toString().trim());
                currentLine = new StringBuilder(word + " ");
                currentWidth = wordWidth;
            }
        }

        // Add the last line
        lines.add(currentLine.toString().trim());

        return lines;
    }

// Helper method to get the width of a string
    private static int getStringWidth(String str) throws FontFormatException, IOException {
        String fontPath = "E:/FONTS/Nikosh.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, 12);

        // Get font metrics to calculate text size
        BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D tempG = tempImage.createGraphics();
        tempG.setFont(font);
        FontMetrics metrics = tempG.getFontMetrics();

        int textWidth = metrics.stringWidth(str);
        return textWidth;
    }

    // Helper method to convert BufferedImage to byte array
    private static byte[] toByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}


