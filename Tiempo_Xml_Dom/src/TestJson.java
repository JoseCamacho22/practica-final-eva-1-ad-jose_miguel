import static org.junit.Assert.*;

import java.io.InputStream;

import org.junit.Test;

/**
 * 
 * @author {Miguel Angel Garcia Garcia y José Augusto Camacho Fernández}
 *
 */

//nuestra clase desde donde realizamos todas las pruebas 
//our class where we made all tests

public class TestJson {

	WeatherMethod weather=new WeatherMethod();
	String city="London";
	InputStream input;
	
	//Prueba de conexion no valida
	// Invalid Connection Test
	@Test
	public void testConnection() {		
		String URL="http://www.austrolepiteco.com";
		assertNull(weather.showConnection(URL));
	}

	//Prueba de conexion valida de nuestra api
	// Test Connection validates our api
	@Test
	public void testConnectiontrue() {		
		String URL="http://api.openweathermap.org/data/2.5/weather?q=Madrid,us&appid=509d01144970a7757c25f9ef9999ea1e";
		assertNotNull(weather.showConnection(URL));
	}
	
	//prueba de insertar ciudad 
	// insert test city
	@Test
	public void testJson(){		
		String URL="http://api.openweathermap.org/data/2.5/weather?q="+city+",us&appid=509d01144970a7757c25f9ef9999ea1e";
		input=weather.showConnection(URL);
		assertNotNull(weather.json(input));		
	}
	
	// prueba de insertar ciudad nula
	// Insert null City test
	@Test
	public void testJsonfalse(){		
		String URL="http://www.austrolepiteco.com"+city;
		input=weather.showConnection(URL);
		assertNull(weather.json(input));		
	}
}
