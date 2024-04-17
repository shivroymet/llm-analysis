package constants;

/**
 * This class contains constant values used throughout the application.
 * It defines URLs, error messages, request prompts, and other constants.
 * @author Shivani Roy
 */
public class Constants {
  /**
   * Base URL for the application.
   */
  public static final String URL = "http://44.208.166.213:5000/";

  /**
   * Key for the model.
   */
  public static final String MODEL = "model";

  /**
   * Key for the prompt.
   */
  public static final String PROMPT = "prompt";

  /**
   * File name for error responses.
   */
  public static final String RESPONSE_FILE = "error";

  /**
   * Error message for failed processing.
   */
  public static final String ERROR_FAILED_PROCESSING = "response.error.failedProcessing";

  /**
   * Error message for processing request failure.
   */
  public static final String ERROR_PROCESSING_REQUEST = "response.error.processingRequest";

  /**
   * Success message for no content.
   */
  public static final String ERROR_NO_CONTENT = "response.success.noContent";

  /**
   * Error message for no models found.
   */
  public static final String ERROR_NO_MODELS_FOUND = "response.error.noModelsFound";

  /**
   * Error message for missing or invalid request.
   */
  public static final String BAD_REQUEST_MISSING_INVALID = "request.bad.missing";

  /**
   * Error message for empty or null request.
   */
  public static final String BAD_REQUEST_EMPTY_NULL = "request.bad.empty";
}
