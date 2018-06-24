package hello.con;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import hello.ParkingSpace;
import hello.StrGenerator;

//@RestController
@Path("/state")
@Component
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Random rand = new Random();
    private boolean wantAddingData = false;
    private String data;
    @Autowired
    Environment environment;

    //    @RequestMapping("/state")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response index() {

        ParkingSpace parkingSpace = new ParkingSpace();

        addData(true,1000000);
        String port =environment.getProperty("local.server.port");

//        System.out.println("Current port:" + port);
//        logger.info(String.valueOf(port == "8081"));

        if (port.equals("8081")){
            parkingSpace.setId("1");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
            if(wantAddingData){
                parkingSpace.setData(data);
            }
        }
        else if (port.equals("8082")){
            parkingSpace.setId("2");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
            if(wantAddingData){
                parkingSpace.setData(data);
            }
        }
        else if (port.equals("8083")){
            parkingSpace.setId("3");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
            if(wantAddingData){
                parkingSpace.setData(data);
            }
        }
        else if (port.equals("8084")){
            parkingSpace.setId("4");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
            if(wantAddingData){
                parkingSpace.setData(data);
            }
        }
        else{
            parkingSpace.setId("5");
            parkingSpace.setLat(getRandomLat());
            parkingSpace.setLongti(getRandomLongi());
            if(wantAddingData){
                parkingSpace.setData(data);
            }
        }

        String json = "";
        try{
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(parkingSpace);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(parkingSpace).build();
//        return json;
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

    private void addData(Boolean wantAddingData,int length){
        this.wantAddingData = wantAddingData;
        if(wantAddingData) {
            String data = StrGenerator.createRandomString(length);
            this.data = data;
        }
    }
}
