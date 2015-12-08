
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @author {Miguel Angel Garcia Garcia y José Augusto Camacho Fernández}
 *
 */

public class WeatherMethod {

	/**
	 * Metodo conexion a la api de json por parametro url
	 * Connection method API as parameter json url
	 * @param URL
	 * @return
	 */
	// UTF-8 de la codificación. EL conjunto de caracteres que desea que los bytes codificados
	// UTF -8 encoding. The character set that you want the encoded bytes
	final private static String CODIFICATION="UTF-8";
	
	
	//Metodo conexion con nuestra url
	//Method connection to our url

	public InputStream showConnection(String URL) {

		try {

			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();

			InputStream stream = connection.getInputStream();
			return stream;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException ex) {
			System.err.println(ex);
			return null;
		} catch (IOException ex) {
			System.err.println(ex);
			return null;
		} catch (NullPointerException ex) {
			System.err.println(ex);
			return null;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	
	//Metodo de retornar el objeto
   //Method  return the object
	
	public Weather getObjet(String name, String country, Double temp, Double temp_max, Double temp_min, Long humidity,
			String desc_temp,Double speed) {
		Weather weather = new Weather(name,country,temp,temp_max,temp_min,humidity,desc_temp,speed);
		return weather;
	}

	//Metodo para recorrerme el fichero Json para mostrar los datos solicitados
	// Method to recorrerme the JSON file to display the requested data
	
	public Weather json(InputStream stream) {

		try {

			BufferedReader streamReader;
			streamReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			StringBuilder responseStrbuilder = new StringBuilder();
			String inputStr;

			while ((inputStr = streamReader.readLine()) != null)
				responseStrbuilder.append(inputStr);

			String reponseData = responseStrbuilder.toString();

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reponseData);

			// Recojo nombre
			// Pick name
			String name = (String) jsonObject.get("name");
			
			// Recojo Pais
			// Pick Country
			JSONObject root = (JSONObject) jsonObject.get("sys");
			String country = (String) root.get("country");
	
			// Recojo coordenada
			// Pick coordinate
			JSONObject root1 = (JSONObject) jsonObject.get("coord");
			
			// Dentro de coordenada cojo long y lat
			// With in coordinate lame long and lat
			Double lon = (Double) root1.get("lon");
			Double lat = (Double) root1.get("lat");

			// Recojo el main
			// Pick the main
			JSONObject root2 = (JSONObject) jsonObject.get("main");
			Double temp = (Double) root2.get("temp");
			Long humidity = (Long) root2.get("humidity");
			Double temp_max = (Double) root2.get("temp_max");
			Double temp_min = (Double) root2.get("temp_min");

			
			// Recojo wheather
			// Pick wheather
			JSONArray root3 = (JSONArray) jsonObject.get("weather");

			String tiempo = "";

			for (int i = 0; i < root3.size(); i++) {

				JSONObject jsonPost = (JSONObject) root3.get(i);
				tiempo = (String) jsonPost.get("description");
				
			}
			
			//recojo wind y speed
			//Pick wind and speed
			JSONObject root5=(JSONObject)jsonObject.get("wind");
			double speed=(Double)root5.get("speed");

			
			Weather weather = getObjet(name,country,temp,temp_max,temp_min,humidity,
					tiempo,speed);
			FileXml file = new FileXml();
			file.createFileXml(weather);
			return weather;

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
