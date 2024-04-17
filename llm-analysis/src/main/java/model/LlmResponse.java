package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a response obtained from Language Model (Llm) evaluation.
 * Contains information regarding CPU usage change, memory usage, response time, result data, and energy.
 *
 * @author Shivani Roy
 */
public class LlmResponse {

  @JsonProperty("cpu_usage_change")
  private double cpuUsageChange;

  @JsonProperty("memory_usage")
  private double memoryUsage;

  @JsonProperty("response_time")
  private double responseTime;

  @JsonProperty("result")
  private Result resultData;

  @JsonProperty("energy")
  private double energy;

  /**
   * Retrieves the CPU usage change.
   *
   * @return The CPU usage change value.
   */
  public double getCpuUsageChange() {
    return cpuUsageChange;
  }

  /**
   * Retrieves the memory usage.
   *
   * @return The memory usage value.
   */
  public double getMemoryUsage() {
    return memoryUsage;
  }

  /**
   * Retrieves the response time.
   *
   * @return The response time value.
   */
  public double getResponseTime() {
    return responseTime;
  }

  /**
   * Retrieves the result data.
   *
   * @return The Result object containing result data.
   */
  public Result getResultData() {
    return resultData;
  }

  /**
   * Retrieves the energy value.
   *
   * @return The energy value.
   */
  public double getEnergy() {
    return energy;
  }

  /**
   * Sets the CPU usage change value.
   *
   * @param cpuUsageChange The CPU usage change value to set.
   */
  public void setCpuUsageChange(double cpuUsageChange) {
    this.cpuUsageChange = cpuUsageChange;
  }

  /**
   * Sets the memory usage value.
   *
   * @param memoryUsage The memory usage value to set.
   */
  public void setMemoryUsage(double memoryUsage) {
    this.memoryUsage = memoryUsage;
  }

  /**
   * Sets the response time value.
   *
   * @param responseTime The response time value to set.
   */
  public void setResponseTime(double responseTime) {
    this.responseTime = responseTime;
  }

  /**
   * Sets the result data.
   *
   * @param resultData The Result object containing result data to set.
   */
  public void setResultData(Result resultData) {
    this.resultData = resultData;
  }

  /**
   * Sets the energy value.
   *
   * @param energy The energy value to set.
   */
  public void setEnergy(double energy) {
    this.energy = energy;
  }

  /**
   * Default constructor.
   */
  public LlmResponse() {
  }

  /**
   * Overrides the toString() method to represent LlmResponse object as a string.
   *
   * @return String representation of LlmResponse object.
   */
  @Override
  public String toString() {
    return "LlmResponse{" +
      "cpuUsageChange=" + cpuUsageChange +
      ", memoryUsage=" + memoryUsage +
      ", responseTime=" + responseTime +
      ", resultData=" + resultData +
      ", energy=" + energy +
      '}';
  }
}
