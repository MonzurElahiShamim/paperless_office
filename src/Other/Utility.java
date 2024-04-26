/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class Utility {

	final static int FONT_SIZE = 16;
	public final static String NIKOSH_FONT_PATH = "Fonts/Nikosh.ttf";
	public final static Font NIKOSH = loadCustomFont(NIKOSH_FONT_PATH, FONT_SIZE);
	public final static Font NIKOSH_BOLD = loadCustomFont(NIKOSH_FONT_PATH, FONT_SIZE, Font.BOLD);

	public static Font loadCustomFont(String fontPath, float fontSize) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Font loadCustomFont(String fontPath, int fontSize, int fontStyle) {
		try {
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
			return baseFont.deriveFont(fontStyle, fontSize);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void setCommonFont(JPanel panel, Font font) {
		Component[] components = panel.getComponents();
		for (Component comp : components) {
			if (comp instanceof JLabel) {
				JLabel label = (JLabel) comp;
				label.setFont(font);
			} else if (comp instanceof JTextField) {
				JTextField textField = (JTextField) comp;
				textField.setFont(font);
			} else if (comp instanceof JPanel) {
				setCommonFont((JPanel) comp, font); // Recursive call for nested panels
			}
		}
	}

	public static void createPlaceholderText(JTextField textField, String placeholder) {

		// Set the placeholder text initially
		textField.setText(placeholder);
		textField.setForeground(UIManager.getColor("TextField.inactiveForeground"));

		// Add focus listener to show/hide placeholder text
		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
					textField.setForeground(UIManager.getColor("TextField.foreground"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setText(placeholder);
					textField.setForeground(UIManager.getColor("TextField.inactiveForeground"));
				}
			}
		});

	}

	public static void createPlaceholderText(JTextArea textArea, String placeholder) {

		// Set the placeholder text initially
		textArea.setText(placeholder);
		textArea.setForeground(UIManager.getColor("TextField.inactiveForeground"));

		// Add focus listener to show/hide placeholder text
		textArea.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textArea.getText().equals(placeholder)) {
					textArea.setText("");
					textArea.setForeground(UIManager.getColor("TextField.foreground"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textArea.getText().isEmpty()) {
					textArea.setText(placeholder);
					textArea.setForeground(UIManager.getColor("TextField.inactiveForeground"));
				}
			}
		});

	}

	public static void setMaxInputLength(JTextArea textArea, java.awt.event.KeyEvent evt, int maxInputLength) {
		if (evt.getKeyChar() == '\n') {
			textArea.setText(textArea.getText().substring(0, textArea.getText().length()-1));
		}
		int InputLength = maxInputLength;
		if (textArea.getText().length() >= InputLength) {
			evt.consume(); // Ignore the key event if the limit is reached
			textArea.setText(textArea.getText().substring(0, InputLength));
		}
		textArea.setText(textArea.getText().replace("\n", " "));
		
	}
}
