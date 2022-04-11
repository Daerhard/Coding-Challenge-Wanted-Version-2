package mainProgram;

//Importe
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//In dieser Klasse sehe ich selbst noch einiges an Verbesserungspotenzial.
//Für den Moment werde ich sie aber so beibehalten und mich auf den anderen Teil der Anwendung konzentrieren
public class APIaccess {
	//Reads text from a character input stream and buffers the characters to allow 
	//efficient reading of characters, arrays and rows.
	//Variables for receiving the data
	private static HttpURLConnection connection;
	BufferedReader reader;
	String line;
	StringBuffer fbiContent = new StringBuffer();

	//Variables for processing the received data of the API
	String page;
	JSONObject data, item;
	JSONArray arrayItem, arrayImage;

	//The Constructor
	public APIaccess() {
		
		//Connection
		try {
			URL url = new URL("https://api.fbi.gov/wanted/v1/list" + getRandomPage());
			//Conversion (HttpURLConnection), returns an instance of the connection.
			connection = (HttpURLConnection) url.openConnection();
			//Set requestProperty to JSON
			connection.setRequestProperty("Accept", "application/json");
			//Set request GET
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			//Returns the status of the connection
			int status = connection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					fbiContent.append(line);
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					fbiContent.append(line);
					//Method for Dataprocess
					dataProcess();
				}
				reader.close();
			}
		} catch (MalformedURLException excMal) {
			excMal.printStackTrace();
		} catch (IOException excIO) {
			excIO.printStackTrace();
		} finally {
			connection.disconnect();
		}
	}

	//Method for data processing after successful access to the API.
	private void dataProcess() {
		try {
			//The string content is converted to a JSONObject
			data = new JSONObject(fbiContent.toString());
			//The JSONObject returns a JSONArray
			arrayItem = data.getJSONArray("items");

			//random selection of a criminal
			Random randomGetCr = new Random();
			int randomCriminal = randomGetCr.nextInt(1,arrayItem.length());

			item = arrayItem.getJSONObject(randomCriminal);
			//The JSONArray for the Musghot
			arrayImage = item.getJSONArray("images");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
		
	//Method for random selection of the FBI page
	//Returns FBI Page
	private String getRandomPage() {
		//random Selection of the page
		Random random = new Random();
		int randomValue = random.nextInt(1,49);
		page = "?page=" + randomValue;
		
	return page;
	}
	
	//Method for the random selection of the criminal
	//Returns of a random criminal
	public String getCriminal() {
		String criminal = null;

		try {
			criminal = item.getString("title");
		} catch (JSONException eCriminal) {
			eCriminal.printStackTrace();
		}

	return (criminal);
	}

	//Method for the selection of the mugshot
	//Returns URL of the mugshot in String format
	public String getMugshotUrl() {
		final int index = 0;
		JSONObject image;
		String mugshotUrl = null;

		//Selection of the mugshot
		try {
			image = arrayImage.getJSONObject(index);
			mugshotUrl = image.getString("original");
		} catch (JSONException eMugshot) {
			eMugshot.printStackTrace();
		}

	return (mugshotUrl);
	}

}
