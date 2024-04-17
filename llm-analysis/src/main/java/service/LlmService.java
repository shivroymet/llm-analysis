package service;

import java.util.HashMap;
import java.util.List;
import model.ChartDataModels;
import model.Model;
import model.LlmRequest;
import model.LlmResponse;

/**
 * Service interface for Language Model (Llm) operations.
 * Provides methods to retrieve responses, models, and chart data.
 *
 * @author Shivani Roy
 */
public interface LlmService {

  /**
   * Gets the response based on the provided LlmRequest.
   *
   * @param llmRequest The request object containing information for the response.
   * @return The LlmResponse generated based on the request.
   */
  LlmResponse getResponse(LlmRequest llmRequest);

  /**
   * Retrieves a list of available models.
   *
   * @return The list of Model objects representing available models.
   */
  List<Model> getModels();

  /**
   * Gets chart data based on the provided list of models and query strings.
   *
   * @param modelList  The list of models for which chart data needs to be generated.
   * @param queryList  The list of query strings used for chart data generation.
   * @return A HashMap containing chart data mapped with corresponding model names.
   */
  HashMap<String, ChartDataModels> getChartData(List<Model> modelList, List<String> queryList);
}
