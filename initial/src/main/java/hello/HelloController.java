package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.Random;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Random rand = new Random();
    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String index() {

        ParkingSpace parkingSpace = new ParkingSpace();


        String port =environment.getProperty("local.server.port");
//        System.out.println("Current port:" + port);
//        logger.info(String.valueOf(port == "8081"));

        if (port.equals("8081")){
            parkingSpace.setId("1");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
        }
        else if (port.equals("8082")){
            parkingSpace.setId("2");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
        }
        else if (port.equals("8083")){
            parkingSpace.setId("3");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
        }
        else if (port.equals("8084")){
            parkingSpace.setId("4");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
        }
        else{
            parkingSpace.setId("5");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
        }

        String json = "";
        try{
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(parkingSpace);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return json;
    }

    private static double getRandomLat(){
        double lat = -2.25 + rand.nextDouble() * 0.04;
        DecimalFormat df=new DecimalFormat("#.000000");
        double formattedLat = Double.valueOf(df.format(lat));
        return formattedLat;
    }
    private static double getRandomLongi(){
        double longi = 53.46 + rand.nextDouble() * 0.02;
        DecimalFormat df=new DecimalFormat("#.000000");
        double formattedLongi = Double.valueOf(df.format(longi));
        return formattedLongi;
    }
    
}
