/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test_classes;

/**
 *
 * @author Monzur Elahi Shamim
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TextToImage {

    public static void main(String[] args) throws IOException, Exception {
        // Example usage
        String text = "পিডিএফ ক্ষ জ্ঞ শ্রাবণ\n বাংলাদেশ";
        generateImage(text);
    }

    public static BufferedImage generateImage(String text) throws Exception {
        BufferedImage tempImage;
        String fontPath = "E:/FONTS/Nikosh.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, 60);
        tempImage = generateImage(text, font);
        return tempImage;
    }
    
    public static BufferedImage generateImage(String text, char ch) throws Exception {
        BufferedImage tempImage;
        String fontPath = "E:/FONTS/Nikosh.ttf";
        if (ch == 'B' || ch =='b') {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.BOLD, 60);
            tempImage = generateImage(text, font);
            return tempImage;
        }
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, 60);
        tempImage = generateImage(text, font);
        return tempImage;
    }

    public static BufferedImage generateImage(String text, Font font) throws Exception {

        // Get font metrics to calculate text size
        BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D tempG = tempImage.createGraphics();
        tempG.setFont(font);
        FontMetrics metrics = tempG.getFontMetrics();

        // Calculate text dimensions with padding
        int padding = 15; // Adjust the padding as needed
        int textWidth = metrics.stringWidth(text) + 2 * padding;
        int textHeight = metrics.getHeight() + 2 * padding;

        // Set image size to match text size with padding
        int width = textWidth;
        int height = textHeight;

        // Create a BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get graphics context
        Graphics2D g = image.createGraphics();

        // Set rendering hints for quality
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Set background color
//        Color background = Color.WHITE;
//        g.setColor(background);
//        g.fillRect(0, 0, width, height);
        
        // Set a transparent background
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, width, height);
        g.setComposite(AlphaComposite.SrcOver);

        // Set font and color for text
        g.setFont(font);
        g.setColor(Color.BLACK);

        // Draw text centered in the image with padding
        g.drawString(text, padding, height / 2 + padding);

        // Dispose graphics context
        g.dispose();

        // Save image as JPEG (Optional: You can skip saving and return the BufferedImage directly)
        //ImageIO.write(image, "JPEG", new File("text_with_newline.jpg"));
        //System.out.println("Image saved as text_with_padding.jpg");
        // Return the generated BufferedImage
        return image;
    }

}
