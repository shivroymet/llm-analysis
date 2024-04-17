package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a result obtained from a model evaluation.
 * Contains various attributes related to the evaluation result, such as context, timestamps, evaluation counts, response text, etc.
 *
 * @author Shivani Roy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
  @JsonProperty("context")
  private List<Integer> contextData;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("done")
  private boolean isDone;

  @JsonProperty("eval_count")
  private int evalCount;

  @JsonProperty("eval_duration")
  private long evalDuration;

  @JsonProperty("load_duration")
  private long loadDuration;

  @JsonProperty("model")
  private String modelInfo;

  @JsonProperty("prompt_eval_count")
  private int promptEvalCount;

  @JsonProperty("response")
  private String responseText;

  @JsonProperty("total_duration")
  private long totalDuration;

  /**
   * Default constructor.
   */
  public Result() {}

  // Getters for properties with JavaDoc comments

  /**
   * Retrieves the context data from the result.
   *
   * @return The context data list.
   */
  public List<Integer> getContextData() {
    return contextData;
  }

  /**
   * Retrieves the creation timestamp of the result.
   *
   * @return The creation timestamp of the result.
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Checks if the evaluation is completed.
   *
   * @return True if the evaluation is done; otherwise, false.
   */
  public boolean isDone() {
    return isDone;
  }


  /**
   * Retrieves the count of evaluations.
   *
   * @return The count of evaluations.
   */
  public int getEvalCount() {
    return evalCount;
  }

  /**
   * Retrieves the duration of evaluations.
   *
   * @return The duration of evaluations.
   */
  public long getEvalDuration() {
    return evalDuration;
  }

  /**
   * Retrieves the duration of loading.
   *
   * @return The duration of loading.
   */
  public long getLoadDuration() {
    return loadDuration;
  }

  /**
   * Retrieves information about the model.
   *
   * @return Information about the model.
   */
  public String getModelInfo() {
    return modelInfo;
  }

  /**
   * Retrieves the count of prompt evaluations.
   *
   * @return The count of prompt evaluations.
   */
  public int getPromptEvalCount() {
    return promptEvalCount;
  }

  /**
   * Retrieves the response text.
   *
   * @return The response text.
   */
  public String getResponseText() {
    return responseText;
  }

  /**
   * Retrieves the total duration.
   *
   * @return The total duration.
   */
  public long getTotalDuration() {
    return totalDuration;
  }

}
