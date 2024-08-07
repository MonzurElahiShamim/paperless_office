package Other;

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
	
//	static String fontPath = "E:/FONTS/Nikosh.ttf";
	static String fontPath = "E:/FONTS/SolaimanLipi_22-02-2012.ttf";
//	static String fontPath = "E:/FONTS/vrinda.ttf";
	
//	static int fontSize = 60; // For Nikosh
	static int fontSize = 53; // For SolaimanLipi
//	static int fontSize = ; // For Vrinda

	public static void main(String[] args) throws IOException, Exception {
		// Example usage
		String text = "পিডিএফ ক্ষ জ্ঞ শ্রাবণ\n বাংলাদেশ";
		generateImage(text);
	}

	// Takes only text and generates plain font image
	public static BufferedImage generateImage(String text) throws Exception {
		BufferedImage tempImage;
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, fontSize);
		tempImage = generateImage(text, font);
		return tempImage;
	}

	// Takes text and font-style (bold or other)
	public static BufferedImage generateImage(String text, char ch) throws Exception {
		BufferedImage tempImage;
		if (ch == 'B' || ch == 'b') {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.BOLD, fontSize);
			tempImage = generateImage(text, font);
			return tempImage;
		}
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, fontSize);
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

	public static BufferedImage drawLine(int x1, int y1, int x2, int y2, Color color, int thickness) {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.drawLine(x1, y1, x2, y2);
		g.dispose();
		
		return image;
	}

}
