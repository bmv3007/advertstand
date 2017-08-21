package service.ws;

import dto.ProductDTO;
import sockets.WebSocketServerEndPoint;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maria on 19.08.2017.
 */
@Singleton
@Startup
public class ProductWSClient {
    // Default URL
    private String BASE_URL = "http://localhost:7777/intbuffetproject/rs/json";

    @Inject
    private WebSocketServerEndPoint webSocketServerEndPoint;
   // private Properties properties = new Properties();


    /*private void initProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties");

        if (is != null) {
            try {
                properties.load(is);

                BASE_URL = (String)properties.getProperty("student.restws.url");

            } catch (IOException e) {
                logger.error("Error when reading properties: ", e);
                throw new RuntimeException("Can not load application.properties file.");
            }
        } else {
            logger.error("Error when finding application.properties.");
            throw new RuntimeException("Error when finding application.properties.");
        }
    }*/

    /**
     * Retrieve over 20 years
     * @param anAge
     * @return
     */
   /* public List<Student> getStudentsOverAge(String anAge) {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URL + "/overAge").path(anAge);

        StudentWrapper wrapper = null;
        try {

            wrapper = myResource.request(MediaType.APPLICATION_JSON).get( StudentWrapper.class);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return wrapper.getList();
    }
*/


    /**
     * Students by name
     * @param studentNames
     * @return
     */
  /*  public List<Student> getStudentsByName(List<String> studentNames) {

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(BASE_URL + "/studentsByName").queryParam( "names", converter.toString(studentNames));

        StudentWrapper wrapper = null;
        try {

            wrapper = myResource.request(MediaType.APPLICATION_JSON).get( StudentWrapper.class);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return wrapper.getList();
    }*/

    /**
     *
     * @param studentNames
     * @return
     */
    public List<ProductDTO> loadProductsJson() {

        Client client = ClientBuilder.newClient();
       // String nameJson = converter.toJson(studentNames);
        WebTarget myResource = client.target(BASE_URL + "/products");

        List<ProductDTO> response = null;
        try {


                response = myResource.request(MediaType.APPLICATION_JSON).get(new GenericType<List<ProductDTO>>() {});

        }catch (NotAcceptableException notAcceptable) {
        }catch (NotFoundException notFound) {
        }catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace();
        }finally {
              client.close();
        }

        if(response!=null && response.size()>1){
            for(ProductDTO product: response){
                System.out.println("product"+product);
            }
        }

        try {
            webSocketServerEndPoint.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}