package Gui_classes.Student;

import static DB_classes.DatabaseOperations.retrieveUserDataFromDatabase;
import DB_classes.PdfDatabaseManager;
import Gui_classes.pdf_Preview;
import static Other.Utility.loadCustomFont;
import Other.PDFWithImages;
import Other.UserInfo;
import Other.UserSession;
import Other.Utility;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class Compose_SC_Application extends javax.swing.JFrame {

	/**
	 * Creates new form compose
	 */
	final int fontSize = 13;
	final String fontPath = "Fonts/Nikosh.ttf";
	final Font customFont = loadCustomFont(fontPath, fontSize);
	final Font boldCustomFont = Utility.NIKOSH_BOLD;

	public Compose_SC_Application() {
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

        ProgClubApplication = new javax.swing.JPanel();
        previewBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        applicationForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        postName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        motivation = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cause = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sportingSkills = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        extraCurr = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        expTLeader = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        expTMember = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        expSprtContest = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        goalFuturePlan = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProgClubApplication.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Programming Club", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Script", 1, 18))); // NOI18N

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

        jScrollPane1.setPreferredSize(new java.awt.Dimension(892, 1780));

        applicationForm.setBackground(new java.awt.Color(255, 255, 255));
        applicationForm.setPreferredSize(new java.awt.Dimension(890, 1750));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Application Form");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ICE  Sports Club Committee Member Selection");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("If any section is not applicable to you, then simply type 'N/A'. You must fill up the form for a particular position only once.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Several responses for the same student will readily disqualify that particular student for any post.");

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setText("Applied for the Post:");

        postName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel7.setText("Motivation for Application:");

        motivation.setColumns(10);
        motivation.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        motivation.setLineWrap(true);
        motivation.setRows(6);
        motivation.setTabSize(4);
        motivation.setToolTipText("");
        motivation.setWrapStyleWord(true);
        motivation.setPreferredSize(new java.awt.Dimension(130, 130));
        motivation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motivationKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                motivationKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(motivation);

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel8.setText("Why you should be chosen");

        cause.setColumns(20);
        cause.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        cause.setLineWrap(true);
        cause.setRows(6);
        cause.setWrapStyleWord(true);
        cause.setPreferredSize(new java.awt.Dimension(130, 130));
        cause.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                causeKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(cause);

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel9.setText("Sporting Skills");

        sportingSkills.setColumns(20);
        sportingSkills.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        sportingSkills.setLineWrap(true);
        sportingSkills.setRows(6);
        sportingSkills.setWrapStyleWord(true);
        sportingSkills.setPreferredSize(new java.awt.Dimension(130, 130));
        sportingSkills.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sportingSkillsKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(sportingSkills);

        extraCurr.setColumns(20);
        extraCurr.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        extraCurr.setLineWrap(true);
        extraCurr.setRows(6);
        extraCurr.setWrapStyleWord(true);
        extraCurr.setPreferredSize(new java.awt.Dimension(130, 130));
        extraCurr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                extraCurrKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(extraCurr);

        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel18.setText("Achievements in Extra-curricular activities:");

        expTLeader.setColumns(20);
        expTLeader.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        expTLeader.setLineWrap(true);
        expTLeader.setRows(6);
        expTLeader.setWrapStyleWord(true);
        expTLeader.setPreferredSize(new java.awt.Dimension(130, 130));
        expTLeader.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expTLeaderKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(expTLeader);

        jLabel19.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel19.setText("Experience as a team leader:");

        expTMember.setColumns(20);
        expTMember.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        expTMember.setLineWrap(true);
        expTMember.setRows(6);
        expTMember.setWrapStyleWord(true);
        expTMember.setPreferredSize(null);
        expTMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expTMemberKeyTyped(evt);
            }
        });
        jScrollPane8.setViewportView(expTMember);

        jLabel20.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel20.setText("Experience as a team member:");

        expSprtContest.setColumns(20);
        expSprtContest.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        expSprtContest.setLineWrap(true);
        expSprtContest.setRows(6);
        expSprtContest.setWrapStyleWord(true);
        expSprtContest.setPreferredSize(new java.awt.Dimension(130, 130));
        expSprtContest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expSprtContestKeyTyped(evt);
            }
        });
        jScrollPane9.setViewportView(expSprtContest);

        jLabel21.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel21.setText("Experience in Sports contests:");

        goalFuturePlan.setColumns(20);
        goalFuturePlan.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        goalFuturePlan.setLineWrap(true);
        goalFuturePlan.setRows(10);
        goalFuturePlan.setWrapStyleWord(true);
        goalFuturePlan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                goalFuturePlanKeyTyped(evt);
            }
        });
        jScrollPane10.setViewportView(goalFuturePlan);

        jLabel22.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel22.setText("Your Goals and Future-Plans to reach those goals:");

        javax.swing.GroupLayout applicationFormLayout = new javax.swing.GroupLayout(applicationForm);
        applicationForm.setLayout(applicationFormLayout);
        applicationFormLayout.setHorizontalGroup(
            applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationFormLayout.createSequentialGroup()
                .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(applicationFormLayout.createSequentialGroup()
                                    .addGap(352, 352, 352)
                                    .addComponent(jLabel1))
                                .addGroup(applicationFormLayout.createSequentialGroup()
                                    .addGap(159, 159, 159)
                                    .addComponent(jLabel4))
                                .addGroup(applicationFormLayout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(applicationFormLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(postName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22)))
                                .addGroup(applicationFormLayout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(jLabel3))))
                        .addGroup(applicationFormLayout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addComponent(jLabel2))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        applicationFormLayout.setVerticalGroup(
            applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationFormLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addGroup(applicationFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(postName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(applicationForm);

        submitBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitBtn.setText("Save & Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ProgClubApplicationLayout = new javax.swing.GroupLayout(ProgClubApplication);
        ProgClubApplication.setLayout(ProgClubApplicationLayout);
        ProgClubApplicationLayout.setHorizontalGroup(
            ProgClubApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProgClubApplicationLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(ProgClubApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        ProgClubApplicationLayout.setVerticalGroup(
            ProgClubApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProgClubApplicationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProgClubApplicationLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProgClubApplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ProgClubApplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1296, 794));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	private void modifyValues() {

		// Setting custom font for all jLabel and jTextField
		//setCommonFont(applicationForm, Utility.NIKOSH);
	}


    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
		// TODO add your handling code here:
		setVisible(false);
		Home_Stu object = new Home_Stu();
		object.setVisible(true);
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void previewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewBtnMouseClicked
		//remuBillDoc.print(g);
		//printPanel(remuBillDoc);
		String fileName = createPdf();
		pdf_Preview object = new pdf_Preview(fileName, "student", this, true);
		//JOptionPane.showMessageDialog(null, "Motivation: " + motivation.getText().length(), "Success", JOptionPane.INFORMATION_MESSAGE);

		object.setVisible(true);


    }//GEN-LAST:event_previewBtnMouseClicked

    private void previewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBtnActionPerformed

    }//GEN-LAST:event_previewBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
		String fileName = createPdf();

		// Getting userName from Email Address
		String stMail = UserSession.getInstance().getUser();
		String userName = stMail.substring(0, stMail.indexOf('@'));
		//Document save path
		String savePath = "PDFs/Student_Application/Sports_Club_Application_" + userName + ".pdf";

		try {
			File pdfToSave = new File(fileName);
			PDDocument document = PDDocument.load(pdfToSave);
			document.save(savePath);
			document.close();
		} catch (IOException ex) {
			Logger.getLogger(pdf_Preview.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Save as file: " + savePath);
		String pdfType = "Student Application";

		int docId = PdfDatabaseManager.savePDFToDatabase(savePath, pdfType, "Unread");
		//PdfDatabaseManager.saveDocAsText(docId, str_date, "", "", "", bodyText, "Notice", "Unread");

		JOptionPane.showMessageDialog(null, "Application Successfully Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);

		Home_Stu object = new Home_Stu();
		object.setVisible(true);
    }//GEN-LAST:event_submitBtnMouseClicked

    private void motivationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivationKeyTyped
		Utility.setMaxInputLength(motivation, evt, 450);
    }//GEN-LAST:event_motivationKeyTyped

    private void motivationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivationKeyPressed
		// TODO add your handling code here:
    }//GEN-LAST:event_motivationKeyPressed

    private void causeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_causeKeyTyped
		Utility.setMaxInputLength(cause, evt, 450);

    }//GEN-LAST:event_causeKeyTyped

    private void sportingSkillsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sportingSkillsKeyTyped
		// TODO add your handling code here:
		Utility.setMaxInputLength(sportingSkills, evt, 450);
    }//GEN-LAST:event_sportingSkillsKeyTyped

    private void extraCurrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_extraCurrKeyTyped
		// TODO add your handling code here:
		Utility.setMaxInputLength(extraCurr, evt, 450);
    }//GEN-LAST:event_extraCurrKeyTyped

    private void expTLeaderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expTLeaderKeyTyped
        // TODO add your handling code here:
		Utility.setMaxInputLength(expTLeader, evt, 450);
    }//GEN-LAST:event_expTLeaderKeyTyped

    private void expTMemberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expTMemberKeyTyped
        // TODO add your handling code here:
		Utility.setMaxInputLength(expTMember, evt, 450);
    }//GEN-LAST:event_expTMemberKeyTyped

    private void expSprtContestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expSprtContestKeyTyped
        // TODO add your handling code here:
		Utility.setMaxInputLength(expSprtContest, evt, 450);
    }//GEN-LAST:event_expSprtContestKeyTyped

    private void goalFuturePlanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_goalFuturePlanKeyTyped
        // TODO add your handling code here:
		Utility.setMaxInputLength(goalFuturePlan, evt, 750);
    }//GEN-LAST:event_goalFuturePlanKeyTyped

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
			java.util.logging.Logger.getLogger(Compose_SC_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Compose_SC_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Compose_SC_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Compose_SC_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//        -            new Compose_Notice().setVisible(true);
//                }
				UserSession.getInstance().setUser("shamim1114@student.nstu.edu.bd");
				new Compose_SC_Application().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProgClubApplication;
    private javax.swing.JPanel applicationForm;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextArea cause;
    private javax.swing.JTextArea expSprtContest;
    private javax.swing.JTextArea expTLeader;
    private javax.swing.JTextArea expTMember;
    private javax.swing.JTextArea extraCurr;
    private javax.swing.JTextArea goalFuturePlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea motivation;
    private javax.swing.JTextField postName;
    private javax.swing.JButton previewBtn;
    private javax.swing.JTextArea sportingSkills;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables

	private String createPdf() {
		String fileName = "temp/Sports Club Application.pdf";
		int EnFontSize = 9;
		UserInfo user = retrieveUserDataFromDatabase(UserSession.getInstance().getUser());
		String stName, stId, session, email;
		stName = user.getStNameEn();
		stId = user.getStId();
		session = user.getSession();
		email = user.getInstEmail();
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			PDPage page2 = new PDPage(PDRectangle.A4);
			document.addPage(page);
			document.addPage(page2);

			int pageHeight = (int) page.getMediaBox().getHeight();
			int pageWidth = (int) page.getMediaBox().getWidth();

			int yPos = pageHeight - 50;
			int leftMargin = 60;
			int rightMargin = pageWidth - leftMargin;
			float lineThickness = 0.75f;

			// add Form Header
			PDFWithImages.addLine(document, page, pageWidth / 2 - 60, yPos, 13, "Application Form", 'b');
			PDFWithImages.addLine(document, page, leftMargin + 75, yPos -= 20, 13, "ICE Sports Club Committee Member Selection", 'b');

			// Form Body
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos -= 30, 10, "Applied for the post: " + postName.getText(), 'b');
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos -= 20, 10, "Name: " + stName, 'b');
			PDFWithImages.addLine(document, page, rightMargin - 150, yPos, 10, "Id: " + stId, 'b');
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos -= 20, 10, "Email: " + email, 'b');
			PDFWithImages.addLine(document, page, rightMargin - 150, yPos, 10, "Session: " + session, 'b');

			yPos = 675;
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos, 10, "Motivation for Application:", 'b');
			PDFWithImages.drawRect(document, page, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			PDFWithImages.addParagraph(document, page, leftMargin + 5, yPos -= 20, 10, motivation.getText());

			yPos = 515;
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos, 10, "Why You Should be Chosen:", 'b');
			PDFWithImages.drawRect(document, page, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			PDFWithImages.addParagraph(document, page, leftMargin + 5, yPos -= 20, 10, cause.getText());

			yPos = 355;
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos, 10, "Sporting Skills", 'b');
			PDFWithImages.drawRect(document, page, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			PDFWithImages.addParagraph(document, page, leftMargin + 5, yPos -= 20, 10, sportingSkills.getText());

			yPos = 195;
			PDFWithImages.addLine(document, page, leftMargin - 3, yPos, 10, "Achievements in Extra-curricular Activities: ", 'b');
			PDFWithImages.drawRect(document, page, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			PDFWithImages.addParagraph(document, page, leftMargin + 5, yPos -= 20, 10, extraCurr.getText());

			// Page2 begins here
			yPos = 780;
			PDFWithImages.addLine(document, page2, leftMargin - 3, yPos -= 10, 10, "Experience as a Team Leader:", 'b');
			PDFWithImages.drawRect(document, page2, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			yPos = PDFWithImages.addParagraph(document, page2, leftMargin + 5, yPos -= 20, 10, expTLeader.getText());

			yPos = 625;
			PDFWithImages.addLine(document, page2, leftMargin - 3, yPos -= 10, 10, "Experience as a Team Member: ", 'b');
			PDFWithImages.drawRect(document, page2, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			yPos = PDFWithImages.addParagraph(document, page2, leftMargin + 5, yPos -= 20, 10, expTMember.getText());

			yPos = 470;
			PDFWithImages.addLine(document, page2, leftMargin - 3, yPos -= 10, 10, "Experience in Sports Contests: ", 'b');
			PDFWithImages.drawRect(document, page2, leftMargin, yPos, rightMargin, yPos - 125, lineThickness); // Draws a rectangle for response
			yPos = PDFWithImages.addParagraph(document, page2, leftMargin + 5, yPos -= 20, 10, expSprtContest.getText());

			yPos = 315;
			PDFWithImages.addLine(document, page2, leftMargin - 3, yPos -= 10, 10, "Your Goals and Future-Plans to reach those goals: ", 'b');
			PDFWithImages.drawRect(document, page2, leftMargin, yPos, rightMargin, yPos - 200, lineThickness); // Draws a rectangle for response
			yPos = PDFWithImages.addParagraph(document, page2, leftMargin + 5, yPos -= 20, 10, goalFuturePlan.getText());

			//Save document for preview
			document.save(fileName);
			document.close();
		} catch (IOException ex) {
			Logger.getLogger(Compose_SC_Application.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(Compose_SC_Application.class.getName()).log(Level.SEVERE, null, ex);

		}
		return fileName;
	}

}
