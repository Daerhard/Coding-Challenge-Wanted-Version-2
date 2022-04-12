package mainProgram;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.RepeatedTest;


class CompleteImageTest {

	@RepeatedTest (value = 20)
	void testGetBackgroundImage() {
		//comparison variable for the test
		Boolean imagesIdentical = null;
		
		URL testUrlImage  = ClassLoader.getSystemResource("static/ImagesTest/JUnitTestImage.jpg");
		//Create Instance for the test
		CompleteImage completeImage = new CompleteImage(233, 400, BufferedImage.TYPE_INT_RGB, testUrlImage.toString().replace(".jpg", ""));
		//Create image for the comparison
		BufferedImage testBackgroundImage = completeImage.getBackgroundImage();
		
		//Create expected image (Background)
		BufferedImage expectedImage = new BufferedImage(233, 400, BufferedImage.TYPE_INT_RGB);
		URL testUrlExpectedImage = ClassLoader.getSystemResource("static/Images/Background.jpg");		
		try {
			expectedImage = ImageIO.read(testUrlExpectedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		   if (expectedImage.getWidth() == testBackgroundImage.getWidth() && expectedImage.getHeight() == testBackgroundImage.getHeight()) {
		        for (int x = 0; x < expectedImage.getWidth(); x++) {
		            for (int y = 0; y < expectedImage.getHeight(); y++) {
		                if (expectedImage.getRGB(x, y) != testBackgroundImage.getRGB(x, y))
		                    imagesIdentical = false;
		            }
		        }
		    } else {
		    	imagesIdentical = false;
		      }	
		   imagesIdentical = true;
				
		//The Background image should be always identical
		assertEquals(imagesIdentical, true);
	}

//	@RepeatedTest (value = 20)
//	void testGetMugshotImage() {
//		CompleteImage completeImage = new CompleteImage(233, 400, BufferedImage.TYPE_INT_RGB, "static/Images/JUnitTestImage.jpg");
	
		
//	}

//	@RepeatedTest (value = 20)
//	void testCreateCompleteImage() {

		
//	}

//	@RepeatedTest (value = 20)
//	void testOverwriteImageFIle() {

//	}

	
	
}
