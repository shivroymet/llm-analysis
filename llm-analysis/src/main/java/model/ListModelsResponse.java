package model;

import java.util.List;

/**
 * Represents a response containing a list of models.
 * This class encapsulates the list of Model objects to be returned in a response.
 *
 * @author Shivani Roy
 */
public class ListModelsResponse {
  private List<Model> models;

  /**
   * Default constructor.
   */
  public ListModelsResponse() {
  }

  /**
   * Retrieves the list of Model objects.
   *
   * @return The list of Model objects.
   */
  public List<Model> getModels() {
    return this.models;
  }

  /**
   * Sets the list of Model objects.
   *
   * @param models The list of Model objects to be set.
   */
  public void setModels(List<Model> models) {
    this.models = models;
  }
}
