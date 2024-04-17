package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a model for storing chart data information.
 * Contains details about response list, average response time, average memory usage, and average energy usage.
 *
 * @author Shivani Roy
 */
public class ChartDataModels {

  @JsonProperty("response_list")
  public List<LlmResponse> llmResponseList;

  @JsonProperty("average_response_time")
  public double averageResponseTime;

  @JsonProperty("average_memory_usage")
  public double averageMemoryUsage;

  @JsonProperty("average_energy_usage")
  public double averageEnergyUsage;

  /**
   * Default constructor.
   */
  public ChartDataModels() {}

  /**
   * Parameterized constructor to initialize ChartDataModels object with values.
   *
   * @param llmResponseList     List of LlmResponse objects.
   * @param averageResponseTime Average response time.
   * @param averageMemoryUsage  Average memory usage.
   * @param averageEnergyUsage  Average energy usage.
   */
  public ChartDataModels(List<LlmResponse> llmResponseList, double averageResponseTime, double averageMemoryUsage, double averageEnergyUsage) {
    this.llmResponseList = llmResponseList;
    this.averageResponseTime = averageResponseTime;
    this.averageMemoryUsage = averageMemoryUsage;
    this.averageEnergyUsage = averageEnergyUsage;
  }

  /**
   * Gets the list of LlmResponse objects.
   *
   * @return List of LlmResponse objects.
   */
  public List<LlmResponse> getLlmResponseList() {
    return llmResponseList;
  }

  /**
   * Gets the average response time.
   *
   * @return Average response time.
   */
  public double getAverageResponseTime() {
    return averageResponseTime;
  }

  /**
   * Gets the average memory usage.
   *
   * @return Average memory usage.
   */
  public double getAverageMemoryUsage() {
    return averageMemoryUsage;
  }

  /**
   * Gets the average energy usage.
   *
   * @return Average energy usage.
   */
  public double getAverageEnergyUsage() {
    return averageEnergyUsage;
  }

  /**
   * Overrides the toString() method to represent ChartDataModels object as a string.
   *
   * @return String representation of ChartDataModels object.
   */
  @Override
  public String toString() {
    return "ChartDataModels{" +
      "llmResponseList=" + llmResponseList +
      ", averageResponseTime=" + averageResponseTime +
      ", averageMemoryUsage=" + averageMemoryUsage +
      ", averageEnergyUsage=" + averageEnergyUsage +
      '}';
  }
}
