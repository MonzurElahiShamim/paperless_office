package Other;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;

public class PDFPrinter {

	public static void printPDF(String filePath){
		// Load the PDF document
		try (PDDocument document = PDDocument.load(new File(filePath))) {
			printPDF(document);			
		} catch (IOException ex) {
			Logger.getLogger(PDFPrinter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void printPDF(String filePath, float paperWidth, float paperHeight){
		// Load the PDF document
		try (PDDocument document = PDDocument.load(new File(filePath))) {
			printPDF(document, paperWidth, paperHeight);			
		} catch (IOException ex) {
			Logger.getLogger(PDFPrinter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void printPDF(PDDocument document) {
		try {
			// Get the default printer
			PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
			
			// Create a PrinterJob
			PrinterJob printerJob = PrinterJob.getPrinterJob();
			printerJob.setPrintService(defaultPrinter);
			
			// Set the number of copies
			PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
			attributes.add(new Copies(1)); // Change the number of copies as needed
			
			// Set the document to be printed
			printerJob.setPageable(new PDFPageable(document));
			
			// Open the print dialog
			if (printerJob.printDialog(attributes)) {
				// Print the document
				printerJob.print(attributes);
			}
		} catch (PrinterException ex) {
			Logger.getLogger(PDFPrinter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void printPDF(PDDocument document, float paperWidth, float paperHeight) throws IOException {
		try {
			// Get the default printer
			PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
			
			// Create a PrinterJob
			PrinterJob printerJob = PrinterJob.getPrinterJob();
			printerJob.setPrintService(defaultPrinter);
			
			// Set print attributes for custom paper size
			PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
			MediaSizeName mediaSizeName = MediaSize.findMedia(paperWidth, paperHeight, MediaPrintableArea.INCH);
			MediaSize mediaSize = MediaSize.getMediaSizeForName(mediaSizeName);
			if (mediaSize != null) {
				attributes.add(mediaSize.getMediaSizeName());
				attributes.add(new MediaPrintableArea(0, 0, paperWidth, paperHeight, MediaPrintableArea.INCH));
			}
			
			// Set the number of copies
			attributes.add(new Copies(1)); // Change the number of copies as needed
			
			// Set the document to be printed
			printerJob.setPageable(new PDFPageable(document));
			
			// Open the print dialog
			if (printerJob.printDialog(attributes)) {
				// Print the document
				printerJob.print(attributes);
			}
		} catch (PrinterException ex) {
			Logger.getLogger(PDFPrinter.class.getName()).log(Level.SEVERE, null, ex);
		}
    }


	public static void main(String[] args) throws PrinterException {
		// Replace "path/to/your/pdf/file.pdf" with the actual path to your PDF file
		printPDF("Bill_20240427_165828.pdf");
	}
}
