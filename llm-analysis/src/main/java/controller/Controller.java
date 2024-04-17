package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import constants.Constants;
import model.ChartDataModels;
import model.Model;
import model.LlmRequest;
import model.LlmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LlmService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.ResponseUtil;

/**
 * Controller class handling various endpoints related to model operations.
 *
 * @author Shivani Roy
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/model")
public class Controller {

  @Autowired
  LlmService llmService;

  /**
   * Handles POST requests to retrieve a response based on the provided request.
   *
   * @param request The JSON request body containing specific information.
   * @return ResponseEntity containing the processed response or an error message.
   */
  @PostMapping("/getResponse")
  public ResponseEntity<?> getResponse(@RequestBody String request) {
    try {
      if (request == null || request.isEmpty()) {
        return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_EMPTY_NULL);
      }

      Gson gson = new Gson();
      LlmRequest llmRequest = gson.fromJson(request, LlmRequest.class);
      LlmResponse response = llmService.getResponse(llmRequest);

      if (response != null) {
        return ResponseUtil.ok(response);
      } else {
        return ResponseUtil.internalServerError(Constants.ERROR_FAILED_PROCESSING);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.internalServerError(Constants.ERROR_PROCESSING_REQUEST);
    }
  }

  /**
   * Handles POST requests to retrieve chart data based on provided models and queries.
   *
   * @param request The JSON request body containing model and query information.
   * @return ResponseEntity containing chart data or an error message.
   */
  @PostMapping("/getChartData")
  public ResponseEntity<?> getChartData(@RequestBody String request) {
    try {
      if (request == null || request.isEmpty()) {
        return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_EMPTY_NULL);
      }

      Gson gson = new Gson();
      JsonObject jsonObject = gson.fromJson(request, JsonObject.class);

      JsonArray jsonArrayModel = jsonObject.getAsJsonArray(Constants.MODEL);
      List<Model> modelList = new ArrayList<>();

      if (jsonArrayModel != null && !jsonArrayModel.isEmpty()) {
        jsonArrayModel.forEach(x -> {
          Model model = gson.fromJson(x, Model.class);
          modelList.add(model);
        });
      } else {
        return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_MISSING_INVALID);
      }

      JsonArray jsonArray = jsonObject.getAsJsonArray(Constants.PROMPT);
      List<String> queryList = new ArrayList<>();

      if (jsonArray != null && !jsonArray.isEmpty()) {
        jsonArray.forEach(x -> {
          String query = gson.fromJson(x, String.class);
          queryList.add(query);
        });
      } else {
        return ResponseEntity.badRequest().body(Constants.BAD_REQUEST_MISSING_INVALID);
      }

      HashMap<String, ChartDataModels> chartDataModelsHashMap = llmService.getChartData(modelList, queryList);
      return ResponseUtil.ok(chartDataModelsHashMap);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.internalServerError(Constants.ERROR_PROCESSING_REQUEST);
    }
  }

  /**
   * Handles GET requests to retrieve a list of models.
   *
   * @return ResponseEntity containing the list of models or an error message.
   */
  @GetMapping("/getModels")
  public ResponseEntity<?> getModels() {
    try {
      List<Model> models = llmService.getModels();
      if (models != null && !models.isEmpty()) {
        return ResponseUtil.ok(models);
      } else {
        return ResponseUtil.noContent(Constants.ERROR_NO_CONTENT);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.internalServerError(Constants.ERROR_NO_MODELS_FOUND);
    }
  }
}
