package util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class providing an ObjectMapper instance for JSON serialization and deserialization.
 * It offers a method to retrieve the ObjectMapper instance.
 *
 * @author Shivani Roy
 */
public class Utils {

  /**
   * Private constructor to prevent instantiation of Utils class.
   */
  private Utils() {
    // Empty private constructor to prevent instantiation
  }

  /**
   * Retrieves a shared instance of the ObjectMapper used for JSON serialization and deserialization.
   *
   * @return An ObjectMapper instance.
   */
  public static ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }
}
