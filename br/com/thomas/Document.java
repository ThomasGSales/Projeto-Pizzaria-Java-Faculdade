package br.com.thomas;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class Document {
	
	public static void writee(String text) {
		System.out.println(text);
	}
	public static void writee(int num) {
		System.out.println(num);
	}
	public static void writee(Object text) {
		System.out.println(text);
	}
	public static String prompt(String text) {
		return JOptionPane.showInputDialog(null, text);
	}
	public static void alert(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	public static void confirm(String text) {
		JOptionPane.showConfirmDialog(null, text);
	}
	
}
