package Gui_classes;

import Gui_classes.Student.Home_Stu;
import static DB_classes.DatabaseOperations.retrieveUserDataFromDatabase;
import DB_classes.PdfDatabaseManager;
import Gui_classes.Admin.ReceipientSelection;
import static Other.PDFPrinter.printPDF;
import Other.UserInfo;
import Other.UserSession;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Monzur Elahi Shamim
 */
public class pdf_Preview extends javax.swing.JDialog {

	private JFrame parentFrame;
	String oldFilePath;
	String callerClassName;
	String userType;

	public pdf_Preview() {
		initComponents();
	}

	public pdf_Preview(String fileName) {
		this.oldFilePath = fileName;
		initComponents();
		openpdf(fileName);
	}

	public pdf_Preview(String fileName, JFrame parent, boolean modal) {
		super(parent, modal);
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		callerClassName = stackTraceElements[2].getClassName();
		this.parentFrame = parent;
		this.oldFilePath = fileName;
		initComponents();
		openpdf(fileName);
	}

	public pdf_Preview(String fileName, String userType, JFrame parent, boolean modal) {
		super(parent, modal);
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		callerClassName = stackTraceElements[2].getClassName();
		this.parentFrame = parent;
		this.oldFilePath = fileName;
		this.userType = userType;
		initComponents();
		if (userType.equalsIgnoreCase("admin")){
			submitBtn.setVisible(false);
			correctionBtn.setVisible(false);
			publishBtn.setVisible(true);
		} else if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("teacher")) {
			submitBtn.setVisible(false);
			correctionBtn.setVisible(false);
			publishBtn.setVisible(false);
		} else if (userType.equals("super")) {
			submitBtn.setVisible(false);
			correctionBtn.setVisible(false);
			publishBtn.setVisible(false);
		}
		openpdf(fileName);
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        submitBtn = new javax.swing.JButton();
        correctionBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        publishBtn = new javax.swing.JButton();

        setSize(new java.awt.Dimension(1300, 700));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Script", 1, 18))); // NOI18N

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitBtn.setText("Save & Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });

        correctionBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        correctionBtn.setText("Correction");
        correctionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correctionBtnMouseClicked(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        printBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printBtn.setText("Print");
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
        });
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        publishBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        publishBtn.setText("Publish");
        publishBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publishBtnMouseClicked(evt);
            }
        });
        publishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(correctionBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(publishBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(correctionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(publishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1268, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked

		if (userType.equals("student")) {

			String studentEmail = UserSession.getInstance().getUser();
			UserInfo student = retrieveUserDataFromDatabase(studentEmail);

			String stRoll = student.getStId();

			// Get the current date and time
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmm");
			// Format the date and time using the formatter
			String strDateTime = formatter.format(date);

			String savePath = stRoll + callerClassName + strDateTime + ".pdf";
			File fileToSave = new File(savePath);

			try {
				File pdfToSave = new File(oldFilePath);
				PDDocument document = PDDocument.load(pdfToSave);
				document.save(fileToSave);
				document.close();
			} catch (IOException ex) {
				Logger.getLogger(pdf_Preview.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println("Save as file: " + savePath);
			String pdfType = "";
			if (callerClassName.equals("Gui_classes.ComposeProshongsha")) {
				pdfType = "Proshongshapotro Application";
			} else if (callerClassName.equals("Gui_classes.ComposeProttoyon")) {
				pdfType = "Prottoyonpottro Application";
			} else if (callerClassName.equals("Gui_classes.ComposeApplicationMarksheet")) {
				pdfType = "Marksheet Application";
			}
			System.out.println("Pdf type is: " + pdfType);
			PdfDatabaseManager.savePDFToDatabase(savePath, pdfType, "Unread");
			JOptionPane.showMessageDialog(null, "Application Successfully Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			Home_Stu object = new Home_Stu();
			object.setVisible(true);
//		} else {
//			// Create a file chooser
//			JFileChooser fileChooser = new JFileChooser();
//
//			// Set the file filter to restrict to specific format (e.g., PDF)
//			FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf");
//			fileChooser.setFileFilter(filter);
//
//			// Show the save dialog
//			int userSelection = fileChooser.showSaveDialog(null);
//
//			if (userSelection == JFileChooser.APPROVE_OPTION) {
//				File fileToSave = fileChooser.getSelectedFile();
//				// Ensure the file has the correct extension
//				String savePath = fileToSave.getAbsolutePath();
//
//				if (!savePath.toLowerCase().endsWith(".pdf")) {
//					savePath = savePath + ".pdf";
//					fileToSave = new File(savePath);
//				}
//
//				try {
//					File pdfToSave = new File(oldFilePath);
//					PDDocument document = PDDocument.load(pdfToSave);
//					document.save(fileToSave);
//					document.close();
//				} catch (IOException ex) {
//					Logger.getLogger(pdf_Preview.class.getName()).log(Level.SEVERE, null, ex);
//				}
//				System.out.println("Save as file: " + savePath);
//				String pdfType = "";
//				if (callerClassName.equals("Gui_classes.Compose_Notice")) {
//					pdfType = "Notice";
//				} else if (callerClassName.equals("Gui_classes.Compose_Letter")) {
//					pdfType = "Letter";
//				} else if (callerClassName.equals("Gui_classes.Compose_Office_Order")) {
//					pdfType = "Office Order";
//				} else if (callerClassName.equals("Gui_classes.ComposeApplicationMarksheet")) {
//					pdfType = "Marksheet Application";
//				}
//				System.out.println("Pdf type is: " + pdfType);
//				PdfDatabaseManager.savePDFToDatabase(savePath, pdfType, "Unread");
//			} else if (userSelection == JFileChooser.CANCEL_OPTION) {
//				System.out.println("Save command canceled by user.");
//			}
//			JOptionPane.showMessageDialog(null, "Document Successfully Saved & Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
//			this.setVisible(false);
//
//			Home_Admin object = new Home_Admin();
//			object.setVisible(true);
		}

    }//GEN-LAST:event_submitBtnMouseClicked

    private void correctionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correctionBtnMouseClicked
		this.setVisible(false); // Close the preview dialog
		parentFrame.setEnabled(true); // Enable the caller frame
    }//GEN-LAST:event_correctionBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
		this.setVisible(false); // Close the preview dialog
		parentFrame.setEnabled(true); // Enable the caller frame
    }//GEN-LAST:event_backBtnMouseClicked

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnMouseClicked

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        // TODO add your handling code here:
		printPDF(oldFilePath);
    }//GEN-LAST:event_printBtnActionPerformed

    private void publishBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publishBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_publishBtnMouseClicked

    private void publishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishBtnActionPerformed
        // TODO add your handling code here:
		ReceipientSelection object = new ReceipientSelection();
		object.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_publishBtnActionPerformed

	/**
	 * @param args the command line
	 * arguments
	 */
	public static void main(String args[]) {
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
			java.util.logging.Logger.getLogger(pdf_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(pdf_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(pdf_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(pdf_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//                if (!UserSession.getInstance().isAuthenticated()) {
//                    JOptionPane.showMessageDialog(null, "You need to login first!");
//                } else {
//                    new pdf_Preview().setVisible(true); 
//                }
				new pdf_Preview().setVisible(true);
			}

		});
	}

	void openpdf(String file) {
		try {
			SwingController control = new SwingController();
			SwingViewBuilder factry = new SwingViewBuilder(control);
			JPanel viewerCompntpnl = factry.buildViewerPanel();
			ComponentKeyBinding.install(control, viewerCompntpnl);
			control.getDocumentViewController().setAnnotationCallback(
				new org.icepdf.ri.common.MyAnnotationCallback(
					control.getDocumentViewController()));
			control.openDocument(file);
//			control.getDocumentViewController().setZoom(1.72f);
			control.getDocumentViewController().setViewType(2);
			control.getDocumentViewController().setFitMode(4);

			// Set the preferred size of the viewerCompntpnl
			viewerCompntpnl.setPreferredSize(new Dimension(800, 600));

			jScrollPane2.setViewportView(viewerCompntpnl);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Cannot Load Pdf");
		}

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton correctionBtn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton publishBtn;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
