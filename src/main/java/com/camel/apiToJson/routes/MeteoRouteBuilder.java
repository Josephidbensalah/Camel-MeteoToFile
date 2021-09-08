package com.camel.apiToJson.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MeteoRouteBuilder extends RouteBuilder {
	
	private final String API_URL="https://api.openweathermap.org/data/2.5/";
	private final String API_KEY="a254ded6fb00bfa8a3b94cae59d46fd7";
	private final String BY_CITY=API_URL+"weather?q=paris&appid="+API_KEY;
	private final String MODE = "xml";

	@Override
	public void configure() throws Exception {
		
		
        from("timer:aTimer?fixedRate=true&period=120s")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .to("https://api.openweathermap.org/data/2.5/weather?q=paris&appid=a254ded6fb00bfa8a3b94cae59d46fd7&mode="+MODE)
        .routeId("TEST")
        .to("file:/E:/camel/?fileName=Méteo."+MODE);
        
		// pour recevoir les données sous format JSON il suffit de changer la valeur du parametre "mode" du xml vers json . 
        // changer le chemin du fichier que tu veux enregistrer . 

		
	}

}
