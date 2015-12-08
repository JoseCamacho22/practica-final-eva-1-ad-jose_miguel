import java.io.InputStream;

/**
 * 
 * @author {Miguel Angel Garcia Garcia y José Augusto Camacho Fernández}
 *
 */

//Clase  weather con sus atributos y constructor
//Class with its attributes and weather builder

public class Weather {


		String name;
		String country;
		double temp_max;
		double temp_min;
		long humidity;
		double speed;
				
		public Weather() {
			super();
		}
		
		
		public Weather(String name, String country, Double temp, Double temp_max, Double temp_min, Long humidity,
				String desc_temp,double speed) {
			super();
			this.name = name;
			this.country = country;
			this.temp_max = temp_max;
			this.temp_min = temp_min;
			this.humidity= humidity;
			this.speed=speed;
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public double getTemp_max() {
			return temp_max;
		}
		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
		public double getTemp_min() {
			return temp_min;
		}
		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}


		public long getHumidity() {
			return humidity;
		}


		public void setHumidity(long humidity) {
			this.humidity = humidity;
		}


		public double getSpeed() {
			return speed;
		}


		public void setSpeed(double speed) {
			this.speed = speed;
		}
	

		@Override
		public String toString() {
			return " --WEATHER--\n"
					+ "NAME=" + name +"\n"+ 
					"COUNTRY=" + country + "\n"+
					"TEMP_MAX=" + temp_max+"\n"+
					"TEMP_MIN="+ temp_min +"\n"+ 
					"HUMIDITY=" + humidity +"\n"+ 
					"SPEED=" + speed +"\n";					
		}


		


		
	
		
}
