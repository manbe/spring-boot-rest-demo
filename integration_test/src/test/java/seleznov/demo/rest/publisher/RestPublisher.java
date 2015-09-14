package seleznov.demo.rest.publisher;

/**
 * Created by illcko
 */
public interface RestPublisher {

    <T> T doGet(Class<T> clazz, String resourceURL);

    <T> T doPost(String resourceURL, Object requestBody,  Class<T> clazz);




}
