import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 * @author {Miguel Angel Garcia Garcia y José Augusto Camacho Fernández}
 *
 */

//Nuestra clase main desde donde gestionamos todo el menu 
//Our main class from which to manage the entire menu

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WeatherMethod parse =new WeatherMethod();
		 
		 String city="";
		 String URL="";
		 InputStream connection;
		 Weather weather;
		 
		 Scanner sc=new Scanner(System.in);
		 int option;
		 int option1;
		 boolean menu=true;
		 do{
			 System.out.println("******Menu Wheater*****\n");
			 System.out.println("1.-Check weather:");
			 System.out.println("2.-Exit: ");
			 option=sc.nextInt();
			 
			switch(option){
			
			case 1:
				boolean menu1=true;
				do{
				System.out.println("What would consult climate??");
				System.out.println("1.--week weather---");
				System.out.println("2.-current Weather----");
				System.out.println("3.-Exit");
		
				
				
				option1=sc.nextInt();
				
				switch(option1){
				case 1:
				System.out.println("Insert city:");
				System.out.println("Week weather");
				city=sc.next();
				URL= "http://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=json&APPID=509d01144970a7757c25f9ef9999ea1e";
				connection=parse.showConnection(URL);
				weather=parse.json(connection);
				System.out.println(weather.toString());	
				break;
				case 2:
					System.out.println("--Current Weather---");
					System.out.println("Insert city:");
					city=sc.next();
					URL= "http://api.openweathermap.org/data/2.5/weather?q="+city+",us&appid=509d01144970a7757c25f9ef9999ea1e";
					connection=parse.showConnection(URL);
					weather=parse.json(connection);
					System.out.println(weather.toString());
					break;
				case 3:
					menu1=false;
				}
				break;
				
				}while(option1!=2);
				
			case 2:
				System.out.println("thank you for trusting us\n");
				menu=false;
			default:
				break;
			} 
			 
		 }while(option!=2);
	}
}

