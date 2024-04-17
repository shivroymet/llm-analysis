package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.ChartDataModels;
import model.LlmRequest;
import model.LlmResponse;
import model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.LlmUtility;

/**
 * Implementation of the LlmService interface providing Language Model (Llm) operations.
 * Handles retrieval of responses, models, and chart data using LlmUtility.
 *
 * @author Shivani Roy
 */
@Service
public class LlmServiceImpl implements LlmService {

  @Autowired
  LlmUtility llmUtility;

  /**
   * Retrieves a response based on the provided LlmRequest.
   *
   * @param llmRequest The request object containing information for the response.
   * @return The LlmResponse generated based on the request.
   */
  public LlmResponse getResponse(LlmRequest llmRequest) {
    try {
      return llmUtility.response(llmRequest);
    } catch (Exception e) {
      e.printStackTrace();
      return null; // Or handle null response appropriately
    }
  }

  /**
   * Retrieves a list of available models.
   *
   * @return The list of Model objects representing available models.
   */
  public List<Model> getModels() {
    try {
      return llmUtility.listModels();
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  /**
   * Generates chart data based on the provided list of models and query strings.
   *
   * @param modelList The list of models for which chart data needs to be generated.
   * @param queryList The list of query strings used for chart data generation.
   * @return A HashMap containing chart data mapped with corresponding model names.
   */
  public HashMap<String, ChartDataModels> getChartData(List<Model> modelList, List<String> queryList) {
    HashMap<String, ChartDataModels> llmResponseHashMap = new HashMap<>();
    try {
      for (Model model : modelList) {
        List<LlmResponse> llmResponseList = new ArrayList<>();
        for (String query : queryList) {
          LlmRequest llmRequest = new LlmRequest(model, query);
          LlmResponse llmResponse = llmUtility.response(llmRequest);
          llmResponseList.add(llmResponse);
        }
        ChartDataModels chartDataModels = compute(llmResponseList);
        llmResponseHashMap.put(model.getName(), chartDataModels);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return llmResponseHashMap;
  }

  /**
   * Computes the average response time, memory usage, and energy usage from a list of LlmResponse objects.
   *
   * @param llmResponseList The list of LlmResponse objects to compute chart data.
   * @return The ChartDataModels object containing computed chart data.
   */
  public ChartDataModels compute(List<LlmResponse> llmResponseList) {
    double responseTime = 0;
    double memoryUsage = 0;
    double energyUsage = 0;

    for (LlmResponse llmResponse : llmResponseList) {
      responseTime += llmResponse.getResponseTime();
      memoryUsage += llmResponse.getMemoryUsage();
      energyUsage += llmResponse.getEnergy();
    }
    energyUsage /= llmResponseList.size();
    memoryUsage /= llmResponseList.size();
    responseTime /= llmResponseList.size();

    return new ChartDataModels(llmResponseList, responseTime, memoryUsage, energyUsage);
  }
}
