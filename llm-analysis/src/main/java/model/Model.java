package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a model entity used in the system.
 * Contains information about a machine learning model, such as its name, modification timestamp, digest, and size.
 *
 * @author Shivani Roy
 */
public class Model {
  private String name;

  @JsonProperty("modified_at")
  private String modifiedAt;

  private String digest;
  private long size;

  /**
   * Default constructor.
   */
  public Model() {
  }

  /**
   * Retrieves the name of the model.
   *
   * @return The name of the model.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name of the model.
   *
   * @param name The name to set for the model.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the model name from the full name (assuming format: modelName:modelVersion).
   *
   * @return The model name extracted from the full name.
   */
  public String getModelName() {
    return this.name.split(":")[0];
  }

  /**
   * Retrieves the model version from the full name (assuming format: modelName:modelVersion).
   *
   * @return The model version extracted from the full name.
   */
  public String getModelVersion() {
    return this.name.split(":")[1];
  }

  /**
   * Retrieves the modification timestamp of the model.
   *
   * @return The modification timestamp of the model.
   */
  public String getModifiedAt() {
    return this.modifiedAt;
  }

  /**
   * Sets the modification timestamp of the model.
   *
   * @param modifiedAt The modification timestamp to set for the model.
   */
  public void setModifiedAt(String modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  /**
   * Retrieves the digest of the model.
   *
   * @return The digest of the model.
   */
  public String getDigest() {
    return this.digest;
  }

  /**
   * Sets the digest of the model.
   *
   * @param digest The digest to set for the model.
   */
  public void setDigest(String digest) {
    this.digest = digest;
  }

  /**
   * Retrieves the size of the model.
   *
   * @return The size of the model.
   */
  public long getSize() {
    return this.size;
  }

  /**
   * Sets the size of the model.
   *
   * @param size The size to set for the model.
   */
  public void setSize(long size) {
    this.size = size;
  }
}
