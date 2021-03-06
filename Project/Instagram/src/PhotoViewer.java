import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author student
 *
 */
public class PhotoViewer extends JFrame {

	//Creating needed insatnces 
	private PhotographContainer imageAlbum;
	private JPanel thumbnails, fullImage, topMenuBar, ratingsBar;
	int currentImage;

	//Constructor for the class
	public PhotoViewer() {
	}

	//Method needed to create and show the GUI
	public void createAndShowGUI() {

		//The JPanels created initially in order for them to store components
		thumbnails = new JPanel(new GridLayout(0, 1, 0, 0));
		topMenuBar = new JPanel(new FlowLayout());
		ratingsBar = new JPanel(new FlowLayout());
		fullImage = new JPanel();


		// what to do when closing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// a title
		this.setTitle("Photo Viewer v0.3");

		//setting up the Menu Bar along the top, including the buttons
		topMenuBar.setSize(new Dimension());
		topMenuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		//Creates the different menu buttons for the user
		JButton exit = new JButton("Exit");
		JButton sortByDate = new JButton("Sort-By-Date");
		JButton sortByCaption = new JButton("Sort-By-Caption");
		JButton sortByRating = new JButton("Sort-By-Rating");

		//Action performed by sort by date button
		sortByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sorts the album
				Collections.sort(imageAlbum.photos);
				//resets the image displayed to the first image in the album
				currentImage = 0;
				fixFullImage();
				getImages();

			}
		});

		//Action performed by sort by caption button
		sortByCaption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sorts the list
				Collections.sort(imageAlbum.photos, new CompareByCaption());
				//resets the image displayed to the first image in the album
				currentImage = 0;
				fixFullImage();
				getImages();

			}
		});

		//Action performed by sort by rating button
		sortByRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(imageAlbum.photos, new CompareByRating());
				//resets the image displayed to the first image in the album
				currentImage = 0;
				fixFullImage();
				getImages();
			}
		});

		//Action performed by exit button
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Closes out of the UI and stops the code
				dispose();
			}
		});

		//adds all of the buttons to the menu bar
		topMenuBar.add(exit);
		topMenuBar.add(sortByRating);
		topMenuBar.add(sortByCaption);
		topMenuBar.add(sortByDate);

		//setting up the radio button bar
		ratingsBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ratingsBar.setAlignmentY((float) 0.2);

		//Creates all of the buttons and labels for the buttons
		JLabel rating = new JLabel("Rate it yourself!");
		JLabel iterating = new JLabel("Go through the list one-by-one: ");
		JRadioButton one = new JRadioButton("1");
		JRadioButton two = new JRadioButton("2");
		JRadioButton three = new JRadioButton("3");
		JRadioButton four = new JRadioButton("4");
		JRadioButton five = new JRadioButton("5");
		JButton next = new JButton("Next >");
		JButton previous = new JButton("< Previous");

		//Creates the button group for the radio buttons and adds all of them to it
		ButtonGroup bg = new ButtonGroup();
		bg.add(one);
		bg.add(two);
		bg.add(three);
		bg.add(four);
		bg.add(five);

		//Action performed on each radio button
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Gets the current photo that is being displayed and sets the rating to 1
					Photograph currentPhoto = imageAlbum.photos.get(currentImage);
					currentPhoto.setRating(1);
					getImages();
					fixFullImage();
				} catch (Exception f) {
					System.out.println("There is no current image displayed!");
				}


			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Gets the current photo that is being displayed and sets the rating to 2
					Photograph currentPhoto = imageAlbum.photos.get(currentImage);
					currentPhoto.setRating(2);
					getImages();
					fixFullImage();
				} catch (Exception f) {
					System.out.println("There is no current image displayed!");
				}


			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Gets the current photo that is being displayed and sets the rating to 3
					Photograph currentPhoto = imageAlbum.photos.get(currentImage);
					currentPhoto.setRating(3);
					getImages();
					fixFullImage();
				} catch (Exception f) {
					System.out.println("There is no current image displayed!");
				}


			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Gets the current photo that is being displayed and sets the rating to 4
					Photograph currentPhoto = imageAlbum.photos.get(currentImage);
					currentPhoto.setRating(4);
					getImages();
					fixFullImage();
				} catch (Exception f) {
					System.out.println("There is no current image displayed!");
				}


			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Gets the current photo that is being displayed and sets the rating to 5
					Photograph currentPhoto = imageAlbum.photos.get(currentImage);
					currentPhoto.setRating(5);
					getImages();
					fixFullImage();
				} catch (Exception f) {
					System.out.println("There is no current image displayed!");
				}


			}
		});

		//Action performed with the Next and Previous buttons *NOTE: Wildly inefficient to do this for both next and previous, will optimize in the future*
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//iterates through the images
					currentImage += 1;

					//gets the next image and sets it as the full image
					Photograph nextPhoto = imageAlbum.photos.get(currentImage);
					BufferedImage p1 = ImageIO.read(nextPhoto.getImageFile());
					JLabel label = new JLabel();
					label.setText(nextPhoto.getCaption() + ", " + nextPhoto.getDateTaken() + ", " + nextPhoto.getRating());
					label.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
					label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					fullImage.removeAll();
					fullImage.add(label);
					fullImage.revalidate();
					fullImage.repaint();
				}catch (IndexOutOfBoundsException f) {
					try {
						//sets the image back to the beginning when going over the max image amount
						currentImage = 0;

						//gets the first image and sets it as the full image
						Photograph nextPhoto = imageAlbum.photos.get(0);
						BufferedImage p1 = ImageIO.read(nextPhoto.getImageFile());
						JLabel label = new JLabel();
						label.setText(nextPhoto.getCaption() + ", " + nextPhoto.getDateTaken() + ", " + nextPhoto.getRating());
						label.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
						label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						fullImage.removeAll();
						fullImage.add(label);
						fullImage.revalidate();
						fullImage.repaint();
					}catch(Exception g) {
						System.out.println("Something else went wrong line: 194");
						g.printStackTrace();
					}
				}catch(Exception f) {
					f.printStackTrace();
				}
			}
		});

		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//iterates backwards through the images
					currentImage -= 1;

					//sets the previous photo as the main displayed picture
					Photograph nextPhoto = imageAlbum.photos.get(currentImage);
					BufferedImage p1 = ImageIO.read(nextPhoto.getImageFile());
					JLabel label = new JLabel();
					label.setText(nextPhoto.getCaption() + ", " + nextPhoto.getDateTaken() + ", " + nextPhoto.getRating());
					label.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
					label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					fullImage.removeAll();
					fullImage.add(label);
					fullImage.revalidate();
					fullImage.repaint();
				}catch (IndexOutOfBoundsException f) {
					try {
						//sets the current image to the last in the album
						currentImage = 4;

						//sets the image as the displayed picture
						Photograph nextPhoto = imageAlbum.photos.get(4);
						BufferedImage p1 = ImageIO.read(nextPhoto.getImageFile());
						JLabel label = new JLabel();
						label.setText(nextPhoto.getCaption() + ", " + nextPhoto.getDateTaken() + ", " + nextPhoto.getRating());
						label.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
						label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						fullImage.removeAll();
						fullImage.add(label);
						fullImage.revalidate();
						fullImage.repaint();
					}catch(Exception g) {
						System.out.println("Something else went wrong line: 194");
						g.printStackTrace();
					}
				}catch(Exception f) {
					f.printStackTrace();
				}
			}
		});

		//Adds all of the required items to the bottom bar
		ratingsBar.add(rating);
		ratingsBar.add(one);
		ratingsBar.add(two);
		ratingsBar.add(three);
		ratingsBar.add(four);
		ratingsBar.add(five);
		ratingsBar.add(iterating);
		ratingsBar.add(previous);
		ratingsBar.add(next);

		//gets the current height and width of the screen, and sets the window to be half of both individual integers
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width/2, height/2);
		this.getContentPane().setLayout(new BorderLayout());

		//Sets up the images to be displayed on screen
		getImages();

		//adds both the menu bar and the rating bar to the north and south, respectively.
		this.getContentPane().add(ratingsBar, BorderLayout.SOUTH);
		this.getContentPane().add(topMenuBar, BorderLayout.NORTH);

		//sets the screen to be visible
		setVisible(true);
	}


	/**
	 * TO-DO: Fix next and previous so that they can call this method as a helper method rather than doing all that work
	 * fixFullImage will take the current photo, trying to get it from its image file, and changes what is displayed on the screen 
	 */
	public void fixFullImage() {
		try {
			//Gets the current photo
			Photograph currentPhoto = this.imageAlbum.photos.get(currentImage);
			//reads the current photo from the images drive
			BufferedImage p1 = ImageIO.read(currentPhoto.getImageFile());

			//Creates a new label for the images caption and picture to be set to it
			JLabel label = new JLabel();
			label.setText(currentPhoto.getCaption() + ", " + currentPhoto.getDateTaken() + ", " + currentPhoto.getRating());
			label.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			//Removes what is displayed on screen and adds the new photos details 
			fullImage.removeAll();
			fullImage.add(label);
			fullImage.revalidate();
			fullImage.repaint();
		} catch (Exception e) {
			System.out.println("Image doesnt exist most likely");
		}

	}

	/**
	 * getImages gets all of the photographs in order as they appear in the album, and displays them to their respective thumbnail
	 */
	public void getImages() {
		//removes everything from before so that it can be reorded appropriately
		thumbnails.removeAll();

		//Gets all of the pictures in order
		Photograph pic1 = this.imageAlbum.photos.get(0);
		Photograph pic2 = this.imageAlbum.photos.get(1);
		Photograph pic3 = this.imageAlbum.photos.get(2);
		Photograph pic4 = this.imageAlbum.photos.get(3);
		Photograph pic5 = this.imageAlbum.photos.get(4);

		try {
			//setting up image 1
			BufferedImage p1 = ImageIO.read(pic1.getImageFile());
			JLabel picLabel1 = new JLabel();
			picLabel1.setText(pic1.getCaption() + ", " + pic1.getDateTaken() + ", " + pic1.getRating());
			picLabel1.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/20, p1.getHeight() /20, 2)));
			picLabel1.setMaximumSize(new Dimension(50,25));
			//adds the button to display the picture on the main screen
			picLabel1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					currentImage = 0;
					getImages();
					fullImage.removeAll();
					picLabel1.setIcon(new ImageIcon(p1.getScaledInstance(p1.getWidth()/5, p1.getHeight() /5, 2)));
					fullImage.add(picLabel1);
				}
			});
			//setting up image 2
			BufferedImage p2 = ImageIO.read(pic2.getImageFile());
			JLabel picLabel2 = new JLabel();
			picLabel2.setText(pic2.getCaption() + ", " + pic2.getDateTaken() + ", " + pic2.getRating());
			picLabel2.setIcon(new ImageIcon(p2.getScaledInstance(p2.getWidth()/20, p2.getHeight() /20, 2)));
			picLabel2.setMaximumSize(new Dimension(50,25));
			//adds the button to display the picture as a full image
			picLabel2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					currentImage = 1;
					getImages();
					fullImage.removeAll();
					picLabel2.setIcon(new ImageIcon(p2.getScaledInstance(p2.getWidth()/5, p2.getHeight() /5, 2)));
					fullImage.add(picLabel2);
				}
			});
			//setting up image 3
			BufferedImage p3 = ImageIO.read(pic3.getImageFile());
			JLabel picLabel3 = new JLabel();
			picLabel3.setText(pic3.getCaption() + ", " + pic3.getDateTaken() + ", " + pic3.getRating());
			picLabel3.setIcon(new ImageIcon(p3.getScaledInstance(p3.getWidth()/20, p3.getHeight() /20, 2)));
			picLabel3.setMaximumSize(new Dimension(50,25));
			//adds the button to display the picture as a full image
			picLabel3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					currentImage = 2;
					getImages();
					fullImage.removeAll();
					picLabel3.setIcon(new ImageIcon(p3.getScaledInstance(p3.getWidth()/5, p3.getHeight() /5, 2)));
					fullImage.add(picLabel3);
				}
			});
			//setting up image 4
			BufferedImage p4 = ImageIO.read(pic4.getImageFile());
			JLabel picLabel4 = new JLabel();
			picLabel4.setText(pic4.getCaption() + ", " + pic4.getDateTaken() + ", " + pic4.getRating());
			picLabel4.setIcon(new ImageIcon(p4.getScaledInstance(p4.getWidth()/20, p4.getHeight() /20, 2)));
			picLabel4.setMaximumSize(new Dimension(50,25));
			//adds the button to display the picture as a full image
			picLabel4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					currentImage = 3;
					getImages();
					fullImage.removeAll();
					picLabel4.setIcon(new ImageIcon(p4.getScaledInstance(p4.getWidth()/5, p4.getHeight() /5, 2)));
					fullImage.add(picLabel4);
				}
			});
			//setting up image 5
			BufferedImage p5 = ImageIO.read(pic5.getImageFile());
			JLabel picLabel5 = new JLabel();
			picLabel5.setText(pic5.getCaption() + ", " + pic5.getDateTaken() + ", " + pic5.getRating());
			picLabel5.setIcon(new ImageIcon(p5.getScaledInstance(p5.getWidth()/20, p5.getHeight() /20, 2)));
			picLabel5.setMaximumSize(new Dimension(50,25));
			//adds the button to display the picture as a full image
			picLabel5.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					currentImage = 4;
					getImages();
					fullImage.removeAll();
					picLabel5.setIcon(new ImageIcon(p5.getScaledInstance(p5.getWidth()/5, p5.getHeight() /5, 2)));
					fullImage.add(picLabel5);
				}
			});

			//adds all of the pictures to the thumbnails label, and creates a border around it
			thumbnails.add(picLabel1);
			thumbnails.add(picLabel2);
			thumbnails.add(picLabel3);
			thumbnails.add(picLabel4);
			thumbnails.add(picLabel5);
			thumbnails.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			//repaints the full image in case something went wrong
			fullImage.revalidate();
			fullImage.repaint();

			//adds everything to the main panel, and refreshes it
			this.getContentPane().add(thumbnails, BorderLayout.WEST);
			this.getContentPane().add(fullImage, BorderLayout.CENTER);
			this.getContentPane().revalidate();
			this.getContentPane().repaint();

		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		PhotoViewer myViewer = new PhotoViewer();

		// relative path for PCs:
		String imageDirectory = "images\\";

		Photograph p1 = new Photograph(imageDirectory + "image1.png", "chung bigus", "2016-05-25", 1);
		Photograph p2 = new Photograph(imageDirectory + "image2.jpg", "Nyananananan", "2017-07-21", 4);
		Photograph p3 = new Photograph(imageDirectory + "image3.jpg", "minions lol", "2014-03-04", 2);
		Photograph p4 = new Photograph(imageDirectory + "image4.jpg", "spoderman", "2018-06-16", 3);
		Photograph p5 = new Photograph(imageDirectory + "image5.png", "corn", "2019-03-26", 5);

		// four more photographs like the line above
		myViewer.imageAlbum = new PhotoLibrary("Test Library", 1);

		myViewer.imageAlbum.addPhoto(p1);
		myViewer.imageAlbum.addPhoto(p2);
		myViewer.imageAlbum.addPhoto(p3);
		myViewer.imageAlbum.addPhoto(p4);
		myViewer.imageAlbum.addPhoto(p5);

		// four more photographs added like the line above
		Collections.sort(myViewer.imageAlbum.photos);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				myViewer.createAndShowGUI();
			}
		}
				);


	}
}

