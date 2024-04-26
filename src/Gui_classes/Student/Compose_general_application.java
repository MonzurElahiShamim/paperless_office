package Gui_classes.Student;

import DB_classes.PdfDatabaseManager;
import Gui_classes.pdf_Preview;
import static Other.Utility.createPlaceholderText;
import static Other.Utility.loadCustomFont;
import Other.PDFWithImages;
import Other.UserSession;
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
public class Compose_general_application extends javax.swing.JFrame {

	/**
	 * Creates new form compose
	 */
	final String fontPath = "Fonts/Nikosh.ttf";
	final Font customFont = loadCustomFont(fontPath, 18);
	final Font boldCustomFont = loadCustomFont(fontPath, 18, Font.BOLD);

	//Variables for document
	String str_date;
	String receipient;
	String dept;
	String subject;
	String bodyText;

	public Compose_general_application() {
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
        jLabel2 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        letterBody = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        uni_name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        personnel = new javax.swing.JTextField();
        department = new javax.swing.JTextField();
        medium = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        subject_letter = new javax.swing.JTextField();
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
        jPanel2.setPreferredSize(new java.awt.Dimension(930, 1100));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        jLabel2.setText("তারিখঃ");

        date.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        date.setText("৩১/১২/২০২৪ ইং");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        letterBody.setColumns(20);
        letterBody.setFont(customFont);
        letterBody.setLineWrap(true);
        letterBody.setRows(5);
        letterBody.setText("মহোদয়, \n");
        letterBody.setWrapStyleWord(true);
        jScrollPane2.setViewportView(letterBody);

        jLabel3.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        jLabel3.setText("বরাবর");

        uni_name.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        uni_name.setBorder(subject_letter.getBorder());

        jLabel7.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        jLabel7.setText("নোয়াখালী-৩৮১৪");

        personnel.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personnelActionPerformed(evt);
            }
        });

        department.setFont(new java.awt.Font("Siyam Rupali", 0, 12)); // NOI18N
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });

        medium.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Siyam Rupali", 1, 12)); // NOI18N
        jLabel9.setText("বিষয়ঃ");

        subject_letter.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(personnel)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(uni_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(subject_letter, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(department)
                        .addComponent(medium, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(uni_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medium, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(subject_letter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        submitBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitBtn.setText("Save & Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1296, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	private void modifyValues() {
		jLabel2.setFont(customFont);
		jLabel2.setText("তারিখঃ");

		date.setFont(customFont);
		date.setText("৩১/১২/২০২৪ ইং");

		letterBody.setFont(loadCustomFont(fontPath, 20));
		letterBody.setText("মহোদয়,");

		jLabel3.setFont(customFont);
		jLabel3.setText("বরাবর");

		uni_name.setFont(customFont); // NOI18N
		uni_name.setText("নোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");

		jLabel7.setFont(customFont);
		jLabel7.setText("নোয়াখালী-৩৮১৪");

		personnel.setFont(customFont);
		createPlaceholderText(personnel, "প্রাপকের পদবি ");

		department.setFont(customFont);
		createPlaceholderText(department, "ডিপার্টমেন্টের নাম");

		medium.setFont(customFont);
		medium.setText("মাধ্যমঃ যথাযথ কর্তৃপক্ষ");

		jLabel9.setFont(boldCustomFont);
		jLabel9.setText("বিষয়ঃ");

		subject_letter.setFont(boldCustomFont);

	}

	private String createPdf() {
		String fileName = "temp/Student general application.pdf";
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			// Office Letter TopMatter
			int yPos = (int) page.getMediaBox().getHeight() - 50;
			int leftMargin = 68;
			str_date = date.getText();
			receipient = personnel.getText();
			dept = department.getText();
			subject = subject_letter.getText();
			PDFWithImages.addLine(document, page, leftMargin, yPos, "তারিখঃ " + str_date);
			PDFWithImages.addLine(document, page, leftMargin, yPos - 25, "বরাবর");
			PDFWithImages.addLine(document, page, leftMargin, yPos - 40, receipient);
			PDFWithImages.addLine(document, page, leftMargin, yPos - 55, dept);
			PDFWithImages.addLine(document, page, leftMargin, yPos - 70, "নোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");
			PDFWithImages.addLine(document, page, leftMargin, yPos - 85, "নোয়াখালী-৩৮১৪");
			PDFWithImages.addLine(document, page, leftMargin, yPos - 105, "মাধ্যমঃ যথাযথ কর্তৃপক্ষ");
			PDFWithImages.addLine(document, page, leftMargin, yPos - 125, 13, "বিষয়ঃ " + subject, 'b');

			//Body text
			bodyText = letterBody.getText();
			yPos = PDFWithImages.addParagraph(document, page, yPos - 155, bodyText);

			//Save file for pdf_Preview
			document.save(fileName);
			document.close();

		} catch (Exception ex) {
			Logger.getLogger(Compose_general_application.class.getName()).log(Level.SEVERE, null, ex);
		}
		return fileName;
	}

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
		// TODO add your handling code here:
		setVisible(false);
		Home_Stu object = new Home_Stu();
		object.setVisible(true);
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void previewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewBtnMouseClicked

		String fileName = createPdf();
		pdf_Preview object = new pdf_Preview(fileName, "student", this, true);
		object.setVisible(true);
    }//GEN-LAST:event_previewBtnMouseClicked

    private void previewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBtnActionPerformed

    }//GEN-LAST:event_previewBtnActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_departmentActionPerformed

    private void personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personnelActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_personnelActionPerformed

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
		String fileName = createPdf();

		// Getting userName from Email Address
		String stMail = UserSession.getInstance().getUser();
		String userName = stMail.substring(0, stMail.indexOf('@'));
		//Document save path
		String savePath = "PDFs/Student_Application/General_Application_" + userName + ".pdf";

		try {
			File pdfToSave = new File(fileName);
			PDDocument document = PDDocument.load(pdfToSave);
			document.save(savePath);
			document.close();
		} catch (IOException ex) {
			Logger.getLogger(pdf_Preview.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Save as file: " + savePath);
		String pdfType = "Letter";

		int docId = PdfDatabaseManager.savePDFToDatabase(savePath, pdfType, "Unread");
		PdfDatabaseManager.saveDocAsText(docId, str_date, receipient, dept, subject, bodyText, "letter", "Unread");

		JOptionPane.showMessageDialog(null, "Document Successfully Saved & Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);

		Home_Stu object = new Home_Stu();
		object.setVisible(true);
    }//GEN-LAST:event_submitBtnMouseClicked

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_submitBtnActionPerformed

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
			java.util.logging.Logger.getLogger(Compose_general_application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Compose_general_application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Compose_general_application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Compose_general_application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//                if (!UserSession.getInstance().isAuthenticated()) {
//                    JOptionPane.showMessageDialog(null, "You need to login first!");
//                } else {
//                    new Compose_Letter().setVisible(true);
//                }
				new Compose_general_application().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField date;
    private javax.swing.JTextField department;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea letterBody;
    private javax.swing.JLabel medium;
    private javax.swing.JTextField personnel;
    private javax.swing.JButton previewBtn;
    private javax.swing.JTextField subject_letter;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel uni_name;
    // End of variables declaration//GEN-END:variables
}