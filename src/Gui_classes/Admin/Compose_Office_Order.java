package Gui_classes.Admin;

import DB_classes.PdfDatabaseManager;
import Gui_classes.pdf_Preview;
import static Other.Utility.loadCustomFont;
import Other.PDFWithImages;
import Other.Utility;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Monzur Elahi Shamim
 */
public class Compose_Office_Order extends javax.swing.JFrame {

	/**
	 * Creates new form compose
	 */
	String fontPath = Utility.NIKOSH_FONT_PATH;
	Font customFont = loadCustomFont(fontPath, 18);
	Font boldCustomFont = loadCustomFont(fontPath, 18, Font.BOLD);

	//Variables for document
	String str_date;
	String bodyText;

	public Compose_Office_Order() {
		initComponents();
		modifyValues();
	}

	/**
	 * This method is called from within
	 * the constructor to initialize the
	 * form. WARNING: Do NOT modify this
	 * code. The content of this method
	 * is always regenerated by the Form
	 * Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        previewBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeBody = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        designation = new javax.swing.JTextArea();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Compose", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Script", 1, 18))); // NOI18N

        previewBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        previewBtn.setText("Preview");
        previewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previewBtnMouseClicked(evt);
            }
        });
        previewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(930, 1315));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/template_header Bn.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N
        jLabel2.setText("তারিখঃ");

        date.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N
        date.setText("৩১/১২/২০২৪ ইং");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Office order title.png"))); // NOI18N

        noticeBody.setColumns(20);
        noticeBody.setFont(new java.awt.Font("Vrinda", 1, 18)); // NOI18N
        noticeBody.setLineWrap(true);
        noticeBody.setRows(5);
        noticeBody.setWrapStyleWord(true);
        jScrollPane2.setViewportView(noticeBody);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        designation.setColumns(20);
        designation.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        designation.setRows(5);
        designation.setText("প্রফেসর ড. মোঃ আশিকুর রহমান খান\nচেয়ারম্যান\nতথ্য ও যোগাযোগ প্রকৌশল বিভাগ\nনোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");
        jScrollPane4.setViewportView(designation);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel3)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        submitBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitBtn.setText("Save & Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1296, 794));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	private void modifyValues() {

		jLabel2.setFont(customFont);
		jLabel2.setText("তারিখঃ");

		date.setFont(customFont);
		date.setText("৩১/১২/২০২৪ ইং");

		noticeBody.setFont(loadCustomFont(fontPath, 20));
		noticeBody.setText("এতদ্বারা");

		designation.setFont(loadCustomFont(fontPath, 20));
	}

	
    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
		// TODO add your handling code here:
		setVisible(false);
		Home_Admin object = new Home_Admin();
		object.setVisible(true);
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void previewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewBtnMouseClicked

    }//GEN-LAST:event_previewBtnMouseClicked

    private void previewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBtnActionPerformed
		String fileName = createPdf();
		//preview doc in pdf-viewer
		pdf_Preview object = new pdf_Preview(fileName, this, true);
		object.setVisible(true);
    }//GEN-LAST:event_previewBtnActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
		String fileName = createPdf();

		// Create a file chooser
		JFileChooser fileChooser = new JFileChooser();

		// Set the file filter to restrict to specific format (e.g., PDF)
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf");
		fileChooser.setFileFilter(filter);

		// Show the save dialog
		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			// Ensure the file has the correct extension
			String savePath = fileToSave.getAbsolutePath();

			if (!savePath.toLowerCase().endsWith(".pdf")) {
				savePath = savePath + ".pdf";
				fileToSave = new File(savePath);
			}

			try {
				File pdfToSave = new File(fileName);
				PDDocument document = PDDocument.load(pdfToSave);
				document.save(fileToSave);
				document.close();
			} catch (IOException ex) {
				Logger.getLogger(pdf_Preview.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println("Save as file: " + savePath);
			String pdfType = "Office Order";

			int docId = PdfDatabaseManager.savePDFToDatabase(savePath, pdfType, "Unread");
			//Save doc as text in Database
			PdfDatabaseManager.saveDocAsText(docId, str_date, "", "", "", bodyText, "Office Order", "Unread");
		} else if (userSelection == JFileChooser.CANCEL_OPTION) {
			System.out.println("Save command canceled by user.");
		}
		JOptionPane.showMessageDialog(null, "Document Successfully Saved & Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);

		Home_Admin object = new Home_Admin();
		object.setVisible(true);
    }//GEN-LAST:event_submitBtnMouseClicked

	/**
	 * @param args the command line
	 * arguments
	 */
	public static void main(String args[]) throws IOException, Exception {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Compose_Office_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Compose_Office_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Compose_Office_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Compose_Office_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//                if (!UserSession.getInstance().isAuthenticated()) {
//                    JOptionPane.showMessageDialog(null, "You need to login first!");
//                } else {
//                    new Compose_Office_Order().setVisible(true);
//                }
				new Compose_Office_Order().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField date;
    private javax.swing.JTextArea designation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea noticeBody;
    private javax.swing.JButton previewBtn;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables

	private String createPdf() {
		String fileName = "temp/OfficeOrder.pdf";
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			// adding header
			PDFWithImages.addHeader(document, page);

			// add Date
			int yPos = (int) page.getMediaBox().getHeight() - 115;
			int leftMargin = 68;
			str_date = date.getText();
			PDFWithImages.addLine(document, page, leftMargin, yPos, "তারিখঃ " + str_date);

			PDFWithImages.addLine(document, page, 245, yPos - 60, 20, "অফিস আদেশ", 'b');

			//Draw Underline 
			PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
			contentStream.moveTo(250, yPos - 55); // moves "pencil" to a position
			contentStream.lineTo(345, yPos - 55);     // creates an invisible line to another position
			contentStream.stroke();
			contentStream.close();

			//Body text
			yPos = 640;
			bodyText = noticeBody.getText();
			PDFWithImages.addParagraph(document, page, yPos, bodyText);

			//Designation
			yPos -= 60;
			PDFWithImages.addDesignation(document, page, yPos);

			document.save(fileName);
			document.close();
		} catch (IOException ex) {
			Logger.getLogger(Compose_Office_Order.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(Compose_Office_Order.class.getName()).log(Level.SEVERE, null, ex);
		}
		return fileName;
	}
}
