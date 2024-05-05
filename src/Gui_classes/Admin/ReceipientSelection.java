/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui_classes.Admin;

import DB_classes.databaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class ReceipientSelection extends javax.swing.JFrame {

	/**
	 * Creates new form SearchPDF
	 */
	DefaultTableModel tableModel1 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false; // Make all cells non-editable
		}
	};
	DefaultTableModel tableModel2 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false; // Make all cells non-editable
		}
	};
	DefaultTableModel tableModel3 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false; // Make all cells non-editable
		}
	};

	public ReceipientSelection() {
		initComponents();
		refreshPdfList();
		setTable1Layout();
		setTable2Layout();
		setTable3Layout();
		getSession();

	}

	private void setTable1Layout() {
		//Setting title font to BOLD
		table1.getTableHeader().setFont(table1.getTableHeader().getFont().deriveFont(Font.BOLD));
		
		// Setting preferred column Width
		TableColumn column1 = table1.getColumnModel().getColumn(0); // Name column
		column1.setPreferredWidth(300); // Set preferred width for Name column
		TableColumn column2 = table1.getColumnModel().getColumn(1); // Name column
		column2.setPreferredWidth(70); // Set preferred width for Name 
		
	}

	private void setTable2Layout() {
		table2.setModel(tableModel2);
		String[] titles = new String[]{"Email ", "Source"};
		setColumnTitle(titles, table2);
		table2.setSelectionBackground(new java.awt.Color(100, 150, 150));
		
		//Setting title font to BOLD
		table2.getTableHeader().setFont(table2.getTableHeader().getFont().deriveFont(Font.BOLD));
		
		// Setting preferred column Width
		TableColumn column1 = table2.getColumnModel().getColumn(0); // Name column
		column1.setPreferredWidth(300); // Set preferred width for Name column
		TableColumn column2 = table2.getColumnModel().getColumn(1); // Name column
		column2.setPreferredWidth(70); // Set preferred width for Name column
	}

	private void setTable3Layout() {
		table3.setModel(tableModel3);
		String[] titles = new String[]{"Batch"};
		setColumnTitle(titles, table3);
//		table3.setBackground(Color.lightGray);
//		table3.setSelectionBackground(Color.ORANGE);
UIManager.put("TableHeader.background", Color.LIGHT_GRAY);  // Set background color


		//Setting title font to BOLD
		table3.getTableHeader().setFont(table3.getTableHeader().getFont().deriveFont(Font.BOLD));
		TableColumn column1 = table3.getColumnModel().getColumn(0); // Name column
		column1.setPreferredWidth(300); // Set preferred width for Name column
//		TableColumn column2 = table.getColumnModel().getColumn(1); // Name column
//		column2.setPreferredWidth(50); // Set preferred width for Name column
	}

	private void refreshPdfList() {

		String sql = "SELECT email as Email, 'Teacher' AS Source FROM teacher";
		searchEmail(sql);
	}

	private void setColumnTitle(String[] titles, JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] columnIdentifiers = new Object[titles.length];
		for (int i = 0; i < columnIdentifiers.length; i++) {
			columnIdentifiers[i] = titles[i]; // Use getColumnLabel to get column alias if available
		}
		tableModel.setColumnIdentifiers(columnIdentifiers);
		table.setModel(tableModel);
	}

	public void searchEmail(String sql) {
		try (Connection connection = databaseConnection.connection()) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					Object[] columnIdentifiers = new Object[resultSet.getMetaData().getColumnCount()];
					for (int i = 0; i < columnIdentifiers.length; i++) {
						columnIdentifiers[i] = resultSet.getMetaData().getColumnLabel(i + 1); // Use getColumnLabel to get column alias if available
					}
					tableModel1.setColumnIdentifiers(columnIdentifiers);

					// Populate rows
					while (resultSet.next()) {
						Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
						for (int i = 0; i < row.length; i++) {
							row[i] = resultSet.getObject(i + 1);
						}
						tableModel1.addRow(row);
					}
					table1.setModel(tableModel1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getSession() {
		String sql = "SELECT DISTINCT session FROM student";
		try (Connection connection = databaseConnection.connection()) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {

					// Populate rows
					while (resultSet.next()) {
						Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
						for (int i = 0; i < row.length; i++) {
							row[i] = resultSet.getObject(i + 1);
						}
						tableModel3.addRow(row);
					}
					table3.setModel(tableModel3);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// Helper method to scroll a row to visible (adjust as needed)
	private void scrollRowToVisible(JTable table, int row) {
		Rectangle cellRect = table.getCellRect(row, 0, true);
		table.scrollRectToVisible(cellRect);
	}

	public boolean checkMatchingRow(int selectedRow) {
		DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
		DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

		// Loop through rows in table1
		boolean matchFound = false; // Flag to track matching row
		int matchingRow = -1;

		// Loop through rows in table2
		for (int row2 = 0; row2 < model2.getRowCount(); row2++) {
			// Check if data in specific columns matches (adjust column indices as needed)
			if (model1.getValueAt(selectedRow, 0)
				.equals(model2.getValueAt(row2, 0))) {
				matchFound = true;
				matchingRow = row2;
				break; // Exit inner loop once a match is found
			}
		}

		if (matchFound) {
			table2.getSelectionModel().setSelectionInterval(matchingRow, matchingRow); // Highlight row in table1
			scrollRowToVisible(table2, matchingRow);
		} else {
			table2.getSelectionModel().clearSelection();
		}
		return matchFound;
	}

	public void transferRow() {
		int selectedRow = table1.getSelectedRow();
		if (selectedRow >= 0 && !checkMatchingRow(selectedRow)) {
			int numColumns = table1.getModel().getColumnCount();
			Object[] rowData = new Object[numColumns];
			for (int col = 0; col < numColumns; col++) {
				rowData[col] = table1.getModel().getValueAt(selectedRow, col);
			}

			DefaultTableModel destinationModel = (DefaultTableModel) table2.getModel();
			destinationModel.addRow(rowData);
			table2.setModel(destinationModel);

			// Hightlight and make Visible within Viewport
			int newRow = table2.getModel().getRowCount() - 1;
			table2.getSelectionModel().setSelectionInterval(newRow, newRow); // Highlight row in table1
			scrollRowToVisible(table2, newRow);

			// Optional: Remove from source table after transfer
//			DefaultTableModel sourceModel = (DefaultTableModel) table.getModel();
//			sourceModel.removeRow(selectedRow);
		} else {
			// Handle no selection case (e.g., display error message)
		}
	}

	private void addSessionMails() {
		int selectedRow = table3.getSelectedRow();
		
		// RowCount after adding new rows
		int previousRowCount = tableModel2.getRowCount();
		
		// adding mails 
		addSessionMails(selectedRow);
		
		// RowCount after adding new rows
		int newRowCount = tableModel2.getRowCount();
		table2.getSelectionModel().setSelectionInterval(previousRowCount, newRowCount); // Highlight row in table1
		scrollRowToVisible(table2, newRowCount-1);
		System.out.println(newRowCount-previousRowCount);
	}

	private void addSessionMails(int selectedRow) {
		String selectedSession = (String) table3.getModel().getValueAt(selectedRow, 0);
		getSessionMails(selectedSession);
	}

	public void getSessionMails(String session) {
		String sql = "SELECT eduEmail as Email, 'Student' as Source FROM student WHERE session = ?";

		try (Connection connection = databaseConnection.connection()) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, session); // Set session parameter

				try (ResultSet resultSet = statement.executeQuery()) {
					Set<String> existingEmails = new HashSet<>(); // Set to store existing emails

					// Extract existing emails from the table model (optional)
					for (int row = 0; row < tableModel2.getRowCount(); row++) {
						String existingEmail = (String) tableModel2.getValueAt(row, 0); // Assuming email is in column 0
						existingEmails.add(existingEmail);
					}

					// Check existing emails and add new rows from database
					while (resultSet.next()) {
						String email = resultSet.getString("Email");
						if (!existingEmails.contains(email)) {
							existingEmails.add(email);

							Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
							for (int i = 0; i < row.length; i++) {
								row[i] = resultSet.getObject(i + 1);
							}
							tableModel2.addRow(row);
						}
					}
					table2.setModel(tableModel2);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ReceipientSelection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int[] getSelectedRowIndices(JTable selectionTable) {
		ListSelectionModel selectionModel = selectionTable.getSelectionModel();
		int rowCount = selectionTable.getModel().getRowCount();
		int[] selectedIndices = new int[rowCount]; // Allocate space for all rows (optimize if needed)
		int selectedCount = 0; // Counter for actual selected rows

		for (int row = 0; row < rowCount; row++) {
			if (selectionModel.isSelectedIndex(row)) {
				selectedIndices[selectedCount] = row; // Store selected row index
				selectedCount++;
			}
		}

		// Optionally, create a new array with the actual number of selected rows (if needed)
		if (selectedCount < rowCount) {
			int[] trimmedIndices = new int[selectedCount];
			System.arraycopy(selectedIndices, 0, trimmedIndices, 0, selectedCount);
			return trimmedIndices;
		} else {
			return selectedIndices;
		}
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        searchKeyWord = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        batchAddBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        sendBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        table1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        table1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table1.setRowHeight(25);
        table1.setRowMargin(5);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        searchKeyWord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchKeyWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeyWordActionPerformed(evt);
            }
        });
        searchKeyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyWordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyWordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyWordKeyTyped(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        table3.setBackground(new java.awt.Color(240, 240, 240));
        table3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table3.setRowHeight(25);
        table3.setRowMargin(5);
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table3);

        batchAddBtn.setText("ADD");
        batchAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batchAddBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(batchAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(248, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        table2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table2.setRowHeight(25);
        table2.setRowMargin(5);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table2);

        sendBtn.setText("Send Email");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(backBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1121, 613));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
		// TODO add your handling code here:
		if (evt.getClickCount() == 2) {
			transferRow();
		}
    }//GEN-LAST:event_table1MouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
		// TODO add your handling code here:
		String keyWord = searchKeyWord.getText();
		String searchQuery = "SELECT email AS Email, 'Teacher' AS Source " // Add source column for distinction
			+ "FROM teacher "
			+ "WHERE email LIKE '%" + keyWord + "%' "
			+ "UNION " // Combine results with UNION ALL (includes duplicates)
			+ "SELECT eduEmail AS Email, 'Student' AS Source " // Add source column
			+ "FROM student "
			+ "WHERE eduEmail LIKE '%" + keyWord + "%'";
		searchEmail(searchQuery);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchKeyWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeyWordActionPerformed
		// TODO add your handling code here:
//		String keyWord = searchKeyWord.getText();
//		String searchQuery = "SELECT email as Email FROM teacher";
//		searchEmail(searchQuery);

//		String keyWord = searchKeyWord.getText();
//		String searchQuery = "SELECT email as Email FROM teacher"
//			+ "WHERE email LIKE '%" + keyWord + "%'";
//		searchEmail(searchQuery);
//		searchQuery = "SELECT eduEmail as Email FROM student"
//			+ "WHERE eduEmail LIKE '%" + keyWord + "%' ";
//		searchEmail(searchQuery);
    }//GEN-LAST:event_searchKeyWordActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
		// TODO add your handling code here:
		Home_Admin object = new Home_Admin();
		object.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_backBtnMouseClicked

    private void searchKeyWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyWordKeyPressed
		// TODO add your handling code here:

    }//GEN-LAST:event_searchKeyWordKeyPressed

    private void searchKeyWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyWordKeyTyped
		// TODO add your handling code here:

    }//GEN-LAST:event_searchKeyWordKeyTyped

    private void searchKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyWordKeyReleased
		// TODO add your handling code here:
//		String keyWord = searchKeyWord.getText();
//		String searchQuery = "SELECT pdf_id as ID, pdf_name as Document, create_time as 'Created Time', type "
//			+ "FROM pdf_storage "
//			+ "WHERE pdf_name LIKE '%" + keyWord + "%' "
//			+ "   OR create_time LIKE '%" + keyWord + "%' "
//			+ "   OR type LIKE '%" + keyWord + "%' "
//			+ "ORDER BY create_time DESC";
//		searchEmail(searchQuery);
    }//GEN-LAST:event_searchKeyWordKeyReleased

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
		// TODO add your handling code here:
    }//GEN-LAST:event_table2MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
		// TODO add your handling code here:
		table1.getSelectionModel().clearSelection();
		table2.getSelectionModel().clearSelection();
		table3.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
		// TODO add your handling code here:
		if (evt.getClickCount() == 2) {
			addSessionMails();
		}

    }//GEN-LAST:event_table3MouseClicked

    private void batchAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchAddBtnMouseClicked

		int[] indices = getSelectedRowIndices(table3);
		if (indices.length > 0) {
			// RowCount before adding new rows
			int previousRowCount = tableModel2.getRowCount();
			for (int index : indices) {
				System.out.println(index);
				addSessionMails(index);
			}
			// RowCount after adding new rows
			int newRowCount = tableModel2.getRowCount();
			table2.getSelectionModel().setSelectionInterval(previousRowCount, newRowCount); // Highlight row in table1
			scrollRowToVisible(table2, newRowCount);
		} else {
			System.out.println("Select Batch/es First!");
		}
    }//GEN-LAST:event_batchAddBtnMouseClicked

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
			java.util.logging.Logger.getLogger(ReceipientSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ReceipientSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ReceipientSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ReceipientSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ReceipientSelection().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton batchAddBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchKeyWord;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables
}
