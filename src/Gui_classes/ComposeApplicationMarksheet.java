package Gui_classes;

import static DBM_classes.DatabaseOperations.retrieveUserDataFromDatabase;
import Other.UserInfo;
import Other.UserSession;
import Test_classes.Converter;
import Test_classes.PDFWithImages;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Monzur Elahi Shamim
 */
public class ComposeApplicationMarksheet extends javax.swing.JFrame {

	final String fontPath = "Fonts/Nikosh.ttf";
	final Font customFont = loadCustomFont(fontPath, 18);
	final Font boldCustomFont = loadCustomFont(fontPath, 18, Font.BOLD);

	private static Font loadCustomFont(String fontPath, float fontSize) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Font loadCustomFont(String fontPath, int fontSize, int fontStyle) {
		try {
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
			return baseFont.deriveFont(fontStyle, fontSize);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ComposeApplicationMarksheet() {
		initComponents();
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

                buttonGroup1 = new javax.swing.ButtonGroup();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                msYear = new javax.swing.JComboBox<>();
                jLabel2 = new javax.swing.JLabel();
                msTerm = new javax.swing.JComboBox<>();
                newChkBox = new javax.swing.JRadioButton();
                oldChkBox = new javax.swing.JRadioButton();
                jLabel3 = new javax.swing.JLabel();
                currentYear = new javax.swing.JComboBox<>();
                jLabel4 = new javax.swing.JLabel();
                currentTerm = new javax.swing.JComboBox<>();
                jLabel8 = new javax.swing.JLabel();
                bankReceiptNo = new javax.swing.JTextField();
                applyBtn = new javax.swing.JButton();
                cancelBtn = new javax.swing.JButton();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Application for Marksheet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Script", 1, 18))); // NOI18N

                jLabel1.setText("Marksheet of  Year");

                msYear.setFont(new java.awt.Font("Siyam Rupali", 0, 11)); // NOI18N
                msYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "১", "২", "৩", "৪" }));
                msYear.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                msYearActionPerformed(evt);
                        }
                });

                jLabel2.setText("Term");

                msTerm.setFont(new java.awt.Font("Siyam Rupali", 0, 11)); // NOI18N
                msTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "১", "২" }));

                buttonGroup1.add(newChkBox);
                newChkBox.setFont(new java.awt.Font("Siyam Rupali", 0, 11)); // NOI18N
                newChkBox.setText("নতুন");

                buttonGroup1.add(oldChkBox);
                oldChkBox.setFont(new java.awt.Font("Siyam Rupali", 0, 11)); // NOI18N
                oldChkBox.setText("পুনরায়");

                jLabel3.setText("Your Current  Year");

                currentYear.setFont(new java.awt.Font("Siyam Rupali", 1, 11)); // NOI18N
                currentYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "১", "২", "৩", "৪" }));
                currentYear.setToolTipText("");

                jLabel4.setText("Term");

                currentTerm.setFont(new java.awt.Font("Siyam Rupali", 1, 11)); // NOI18N
                currentTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "১", "২" }));

                jLabel8.setText("Bank Receipt No");

                bankReceiptNo.setFont(new java.awt.Font("Siyam Rupali", 0, 11)); // NOI18N

                applyBtn.setText("Apply");
                applyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                applyBtnMouseClicked(evt);
                        }
                });

                cancelBtn.setText("Cancel");
                cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                cancelBtnMouseClicked(evt);
                        }
                });

                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/student-grades.png"))); // NOI18N
                jLabel9.setText("jLabel9");

                jLabel10.setText("Mark Sheet Type");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(msYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(msTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(newChkBox)
                                                .addGap(18, 18, 18)
                                                .addComponent(oldChkBox))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(bankReceiptNo))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(currentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(currentTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(152, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(msYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(msTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newChkBox)
                                                        .addComponent(oldChkBox)
                                                        .addComponent(jLabel10))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(currentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(currentTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(bankReceiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(38, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                setSize(new java.awt.Dimension(1076, 737));
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void applyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyBtnMouseClicked
		try {
			// Get info from database to a user object
			String studentEmail = UserSession.getInstance().getUser();
			//UserInfo student = retrieveUserDataFromDatabase(studentEmail);
			UserInfo student = retrieveUserDataFromDatabase("shamim1114@student.nstu.edu.bd"); // remove this line and uncomment previous line
			
			String stNameBn = student.getStNameBn();
			String stNameEn = student.getStNameEn();
			String stRoll = student.getStId();
			String session = Converter.toBanglaNumerals(student.getSession());
			String fatherNameBn = student.getFatherNameBn();
			String fatherNameEn = student.getFatherNameEn();
			String mobile = student.getMobile();

			//Derived
			String stGender = stRoll.toUpperCase().endsWith("M") ? "ছাত্র" : "ছাত্রী";

			// Getting input from the form
			String mYear = msYear.getSelectedItem().toString();
			String mTerm = msTerm.getSelectedItem().toString();
			String cYear = currentYear.getSelectedItem().toString();
			String cTerm = currentTerm.getSelectedItem().toString();
			String type;
			if (newChkBox.isSelected()) {
				type = "নতুন";
			} else if (oldChkBox.isSelected()) {
				type = "পুনরায়";
			} else {
				type = "";
				JLabel messageLabel = new JLabel("মার্কশিটের ধরন সিলেক্ট করুন");
				messageLabel.setFont(customFont);

				// Show the message dialog with the custom label
				JOptionPane.showMessageDialog(null, messageLabel, "Warning!", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String receiptNo = bankReceiptNo.getText();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String str_date = formatter.format(date);
			str_date = Converter.toBanglaNumerals(str_date);

			//
			// Document creation
			//
			float font_size = 14;
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			int yPos = (int) page.getMediaBox().getHeight() - 115;
			int leftMargin = 68;

			PDFWithImages.addLine(document, page, leftMargin, yPos, "তারিখ: " + str_date);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 25, "বরাবর");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "চেয়ারম্যান");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "নোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "নোয়াখালী-৩৮১৪");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 30, 13, "বিষয়: বর্ষ-" + mYear + ", টার্ম-" + mTerm + " এর (" + type + ") মার্কশিট প্রদানের জন্য আবেদন।", 'b');
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 30, "জনাব,");

			String body = "সবিনয় নিবেদন এই যে, আমি, " + stNameBn + ", আপনার ডিপার্টমেন্টের সেশন-" + session + ", বর্ষ-"
				+ cYear + " টার্ম-" + cTerm + " এর একজন নিয়মিত " + stGender + "। আমার ব্যক্তিগত কারণে উল্লেখিত "
				+ "মার্কশিট প্রয়োজন। নিম্নে আমার প্রয়োজনীয় তথ্যাবলী প্রদান করা হলো। অতএব জনাবের নিকট আকুল "
				+ "আবেদন এই যে, আমাকে উল্লেখিত মার্কশিট প্রদান করে বাধিত করবেন।";

			yPos = PDFWithImages.addParagraph(document, page, yPos -= 20, body);

			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "নাম: " + stNameBn);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, 10, "Name: " + stNameEn);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "পিতার নাম: " + fatherNameBn);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, 10, "Father's Name: " + fatherNameEn);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, 13, "ব্যাংক রশিদ নং - " + receiptNo, 'b');
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 60, 13, "   বিনীত নিবেদক", 'b');
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "আপনার একান্ত অনুগত");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, 13, stNameBn, 'b');
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "রোল: " + stRoll.toUpperCase());
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "বর্তমান বর্ষ: " + cYear + ", টার্ম: " + cTerm + "    শিক্ষাবর্ষ: " + session);
			//PDFWithImages.addLine(document, page, leftMargin, yPos-=20, "    শিক্ষাবর্ষ: " + session);
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "ইনফরমেশন এন্ড কমিউনিকেশন ইঞ্জিনিয়ারিং বিভাগ");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "নোয়াখালী বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়");
			PDFWithImages.addLine(document, page, leftMargin, yPos -= 20, "মোবাইল: " + mobile);
			//PDFWithImages.drawLine(document, page, 50, 700, 500, 700);

			// Save the results and ensure that the document is properly closed:
			String fileName = "PDFs/MarkSheet/" + str_date.replace('/', '-') + ".pdf";
			document.save(fileName);
			document.close();

			pdf_Preview object = new pdf_Preview(fileName,"student", this, true);
			object.setVisible(true);
			//setVisible(false);
		} catch (IOException ex) {
			Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(Level.SEVERE, null, ex);
		}

    }//GEN-LAST:event_applyBtnMouseClicked

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
		// TODO add your handling code here:
		setVisible(false);
		Home_Stu object = new Home_Stu();
		object.setVisible(true);
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void msYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msYearActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_msYearActionPerformed

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
			java.util.logging.Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ComposeApplicationMarksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//                if (!UserSession.getInstance().isAuthenticated()) {
//                    JOptionPane.showMessageDialog(null, "You need to login first!");
//                } else {
//                    new ComposeApplicationMarksheet().setVisible(true);
//                }
				new ComposeApplicationMarksheet().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton applyBtn;
        private javax.swing.JTextField bankReceiptNo;
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JButton cancelBtn;
        private javax.swing.JComboBox<String> currentTerm;
        private javax.swing.JComboBox<String> currentYear;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JComboBox<String> msTerm;
        private javax.swing.JComboBox<String> msYear;
        private javax.swing.JRadioButton newChkBox;
        private javax.swing.JRadioButton oldChkBox;
        // End of variables declaration//GEN-END:variables
}