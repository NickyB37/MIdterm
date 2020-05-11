package com.grandcircus.library.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.grandcircus.library.service.LibraryService;

/**
 * Provides a GUI for the user to donate a movie to the library.
 */
public class DonateMovieGUI extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Displays the DonateMovieGUI.
	 * @param libraryApp An instance of the library.
	 */
	public DonateMovieGUI(LibraryService libraryApp) {
		JLabel directorNameLabel = new JLabel("Enter the directors name of the movie you would like to donate");
		JTextField directorNameTextField = new JTextField(30);
		JLabel titleNameLabel = new JLabel("Enter the title of the movie you would like to donate");
		JTextField titleNameTextField = new JTextField(30);
		JLabel runTimeLabel = new JLabel("Enter the runtime of the movie");
		JTextField runTimeTextField = new JTextField(30);
		JButton donateBookButton = new JButton("Add movie");

		this.setSize(400, 200);
		this.setModal(true);
		this.setTitle("Donate a Movie");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		this.add(directorNameLabel);
		this.add(directorNameTextField);
		this.add(titleNameLabel);
		this.add(titleNameTextField);
		this.add(runTimeLabel);
		this.add(runTimeTextField);
		this.add(donateBookButton);
		this.setLocationRelativeTo(null);

		donateBookButton.addActionListener(event -> {
			String directorName = directorNameTextField.getText();
			String titleName = titleNameTextField.getText();
			String runTime = runTimeTextField.getText();

			if (libraryApp.addMovie(titleName, directorName, runTime)) {
				JOptionPane.showMessageDialog(this, "Thank you for your donation!");
			} else {
				JOptionPane.showMessageDialog(this, "Please check your author name and title.");
			}
		});
		
		this.setVisible(true);
	}
}
