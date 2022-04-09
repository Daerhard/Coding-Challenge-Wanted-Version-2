package codingChallengeSpringBoot;

import java.awt.image.BufferedImage;

//Importe
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Meine Klassen
import mainProgram.APIaccess;
import mainProgram.CompleteImage;

//Controller 
@Controller
public class ImageController {
	
	//Processes a GET request from the browser
	//Return TestTemplate
	@GetMapping("/WebWanted")	
	public String getImage() {
		//FBI Rest-API Connection
		APIaccess apiFBI = new APIaccess();
		
		//Create instance of CompleteImage class
		CompleteImage imageWanted = new CompleteImage(233, 400, BufferedImage.TYPE_INT_RGB, apiFBI.getMugshotUrl());
		
		//Create picture with the Background Image and the Mugshot Image frome the FBI API
		imageWanted.createCompleteImage(233, 400);
		
		//Cache image in Images folder for output to browser 
		imageWanted.overwriteImageFile();		
	
	//Calling a Thymeleaf template
	return "TestTemplate";
	}	
}
