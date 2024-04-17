package model;

/**
 * Represents a request object for Language Model (Llm) operations.
 * Contains information about a model and a prompt.
 *
 * @author Shivani Roy
 */
public class LlmRequest {
  private Model model;
  private String prompt;

  /**
   * Parameterized constructor to initialize LlmRequest object with model and prompt.
   *
   * @param model  The Model object for the request.
   * @param prompt The prompt associated with the request.
   */
  public LlmRequest(Model model, String prompt) {
    this.model = model;
    this.prompt = prompt;
  }

  /**
   * Default constructor.
   */
  public LlmRequest() {
  }

  /**
   * Retrieves the Model object associated with the request.
   *
   * @return The Model object.
   */
  public Model getModel() {
    return model;
  }

  /**
   * Retrieves the prompt associated with the request.
   *
   * @return The prompt string.
   */
  public String getPrompt() {
    return prompt;
  }

  /**
   * Overrides the toString() method to represent LlmRequest object as a string.
   *
   * @return String representation of LlmRequest object.
   */
  @Override
  public String toString() {
    return "LlmRequest{" +
      "model=" + model +
      ", prompt='" + prompt + '\'' +
      '}';
  }
}
