package util;

import constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ResourceBundle;

/**
 * Utility class for handling HTTP responses with different status codes and corresponding messages.
 * It provides methods to generate ResponseEntity objects for OK, Bad Request, Internal Server Error, and No Content scenarios.
 *
 * @author Shivani Roy
 */
public class ResponseUtil {

  private static final ResourceBundle messages = ResourceBundle.getBundle(Constants.RESPONSE_FILE);

  /**
   * Creates a ResponseEntity object with OK status and provided data.
   *
   * @param data The data to be included in the response.
   * @return A ResponseEntity object with OK status and provided data.
   */
  public static ResponseEntity<?> ok(Object data) {
    return ResponseEntity.ok(data);
  }

  /**
   * Creates a ResponseEntity object with Bad Request status and the message associated with the provided key.
   *
   * @param key The key associated with the error message.
   * @return A ResponseEntity object with Bad Request status and the corresponding error message.
   */
  public static ResponseEntity<?> badRequest(String key) {
    return ResponseEntity.badRequest().body(messages.getString(key));
  }

  /**
   * Creates a ResponseEntity object with Internal Server Error status and the message associated with the provided key.
   *
   * @param key The key associated with the error message.
   * @return A ResponseEntity object with Internal Server Error status and the corresponding error message.
   */
  public static ResponseEntity<?> internalServerError(String key) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messages.getString(key));
  }

  /**
   * Creates a ResponseEntity object with No Content status and the message associated with the provided key.
   *
   * @param key The key associated with the message.
   * @return A ResponseEntity object with No Content status and the corresponding message.
   */
  public static ResponseEntity<?> noContent(String key) {
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messages.getString(key));
  }
}
