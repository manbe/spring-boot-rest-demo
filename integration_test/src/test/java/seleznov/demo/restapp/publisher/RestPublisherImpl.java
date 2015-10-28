package seleznov.demo.restapp.publisher;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by illcko on 13.09.15.
 */
public class RestPublisherImpl  implements RestPublisher{

    private String serverUrl;

    private RequestSpecification requestSpecification;

    public RestPublisherImpl(String serverUrl, String login, String password) {
        this.serverUrl = serverUrl;
        requestSpecification = given().authentication().basic(login, password).contentType(ContentType.JSON);

    }

    public <T> T doGet(Class<T> clazz, String resourceURL) {
        Response response = requestSpecification.get(serverUrl + resourceURL);
        return response.as(clazz);
    }

    public <T> T doPost(String resourceURL, Object requestBody, Class<T> clazz) {
        return requestSpecification.body(requestBody).post(resourceURL).as(clazz);
    }

}
