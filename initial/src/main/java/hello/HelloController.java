package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String index() {

        ParkingSpace parkingSpace = new ParkingSpace();


        String port =environment.getProperty("local.server.port");
        System.out.println("Current port:" + port);
        logger.info(String.valueOf(port == "8081"));

        if (port.equals("8081")){
            parkingSpace.setId("1");
            parkingSpace.setName("Velvet House");
            parkingSpace.setLat(53.476303);
            parkingSpace.setLongti(-2.235134);
        }
        else if (port.equals("8082")){
            parkingSpace.setId("2");
            parkingSpace.setName("The Assembly Apartments");
            parkingSpace.setLat(53.474018);
            parkingSpace.setLongti(-2.243838);
        }
        else if (port.equals("8083")){
            parkingSpace.setId("3");
            parkingSpace.setName("Cotswold Outdoor Manchester Deansgate");
            parkingSpace.setLat(53.481575);
            parkingSpace.setLongti(-2.247807);
        }
        else if (port.equals("8084")){
            parkingSpace.setId("4");
            parkingSpace.setName("University of Salford");
            parkingSpace.setLat(53.486979);
            parkingSpace.setLongti(-2.271241);
        }
        else{
            parkingSpace.setId("5");
            parkingSpace.setName("National Football Museum");
            parkingSpace.setLat(53.487840);
            parkingSpace.setLongti(-2.242093);
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
    
}
