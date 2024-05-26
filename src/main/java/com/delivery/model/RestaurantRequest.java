package com.delivery.model;

public class RestaurantRequest {

  private double latitude;
  private double longitude;
  private double preptime;

  // Getters and setters
  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getPreptime() {
    return preptime;
  }

  public void setPreptime(double preptime) {
    this.preptime = preptime;
  }
}
