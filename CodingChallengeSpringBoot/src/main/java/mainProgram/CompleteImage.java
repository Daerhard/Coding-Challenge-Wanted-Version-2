package mainProgram;

//Importe
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.springframework.core.io.ClassPathResource;

public class CompleteImage extends BufferedImage {
	//Variables for the processed images
	private BufferedImage backgroundImage;
	private BufferedImage mugshotImage;

	//Konstructor for the BufferedImage
	public CompleteImage(int width, int height, int imageType, String url) {
		super(width, height, imageType);
		
		//The required images are read in
		try {
			   URL imgURL = ClassLoader.getSystemResource("static/Images/Background.jpg");
			   backgroundImage = ImageIO.read(imgURL);
			   mugshotImage = ImageIO.read(new URL(url + ".jpg"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Die Dateien konnten nicht gelesen werden.", "Meldung", JOptionPane.INFORMATION_MESSAGE);  
			} 		
	   }
	
	//The method for checking the correct image (not actually needed for the application to work correctly).
	//Method for the output of the background image
	//Returns backgroundImage
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	
	//The method for checking the correct image (not actually needed for the application to work correctly).
	//Method for the output of the mugshot image
	//Returns mughsotImage
	public BufferedImage getMugshotImage() {
		return mugshotImage;
	}
	
	//Method for generating the complete image
	public void createCompleteImage(int width, int height) {
		this.getGraphics().drawImage(backgroundImage, 0, 0, width, height, null);
		this.getGraphics().drawImage(mugshotImage, 20, 123, 195, 155, null);				
	}
	
	//Method for caching in a file
	public void overwriteImageFile() {		
		try {
			File imageFile = new ClassPathResource("static/Images/BackgroundMugshot.jpg").getFile();
			ImageIO.write(this, "jpg", imageFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
	}		
}

	
	

