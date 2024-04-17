package util;

import com.google.gson.Gson;
import constants.Constants;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import model.ListModelsResponse;
import model.LlmRequest;
import model.LlmResponse;
import model.Model;
import org.springframework.stereotype.Component;

/**
 * Utility class for Language Model (Llm) operations using HTTP requests.
 * Handles requests to obtain a list of models and to retrieve responses based on LlmRequest.
 *
 * @author Shivani Roy
 */
@Component
public class LlmUtility {

  private final String host;

  /**
   * Constructs the LlmUtility object with the specified host URL for LLM operations.
   */
  public LlmUtility() {
    String host = Constants.URL;
    if (host.endsWith("/")) {
      this.host = host.substring(0, host.length() - 1);
    } else {
      this.host = host;
    }
  }

  /**
   * Retrieves a list of available models.
   *
   * @return The list of Model objects representing available models.
   * @throws OllamaBaseException When an OllamaBaseException occurs.
   * @throws IOException         When an IOException occurs.
   * @throws InterruptedException When an InterruptedException occurs.
   * @throws URISyntaxException   When a URISyntaxException occurs.
   */
  public List<Model> listModels() throws OllamaBaseException, IOException, InterruptedException, URISyntaxException {
    String url = this.host + "/getList";
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url))
      .header("Accept", "application/json")
      .header("Content-type", "application/json")
      .GET().build();
    System.out.println(url);
    HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    int statusCode = response.statusCode();

    if (statusCode == 200) {
      String responseString = response.body();
      if (responseString != null && !responseString.isEmpty()) {
        return Utils.getObjectMapper().readValue(responseString, ListModelsResponse.class).getModels();
      }
    }
    return Collections.emptyList();
  }

  /**
   * Retrieves a response based on the provided LlmRequest.
   *
   * @param llmRequest The request object containing information for the response.
   * @return The LlmResponse generated based on the request.
   * @throws IOException          When an IOException occurs.
   * @throws InterruptedException When an InterruptedException occurs.
   */
  public LlmResponse response(LlmRequest llmRequest) throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();
    URI uri = URI.create(this.host + "/getResponse");
    Gson gson = new Gson();
    HttpRequest request = HttpRequest.newBuilder(uri)
      .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(llmRequest)))
      .header("Content-Type", "application/json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    int statusCode = response.statusCode();

    if (statusCode == 200) {
      String responseBody = response.body();
      if (responseBody != null && !responseBody.isEmpty()) {
        return Utils.getObjectMapper().readValue(responseBody, LlmResponse.class);
      }
    }
    return new LlmResponse();
  }
}
