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
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class Utility {

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

}
