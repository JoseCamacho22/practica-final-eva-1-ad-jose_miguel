import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @author {Miguel Angel Garcia Garcia y José Augusto Camacho Fernández}
 *
 */

public class FileXml {

	public FileXml() {
		// TODO Auto-generated constructor stub
	}

	//metodo que en el que sobreescribimos en el xml los climas que buscamos
	// Method in which we overwrite the xml climates we seek
	
	public void createFileXml(Weather weather){
		
		//Me creo la instancia de xstream 
		// I believe instance xstream
		 XStream xstream1 = new XStream(new DomDriver());
		 
		 //Me creo una variable string que recojo los datos de objeto weather
		 // I created a string variable that gather weather data object
		String xml=xstream1.toXML(weather);
		
		
		//Me creo un flujo de salida
		// I think an outflow
		FileOutputStream fos=null;
		try {
			
			//crea un fichero xml llamado weather
			// create an XML file named weather
			fos = new FileOutputStream("res/weather.xml");
			byte[] bytes=null;
			bytes = xml.getBytes("UTF-8");
			
			//Escribe nuestros datos
			// Write your data
			fos.write(bytes);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
