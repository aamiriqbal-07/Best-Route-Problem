package com.delivery.model;

import java.util.List;

public class DriverRequest {

  private Location driver;
  private List<RestaurantRequest> restuarants;
  private List<CustomerRequest> customers;

  // Getters and setters
  public Location getDriver() {
    return driver;
  }

  public void setDriver(Location driver) {
    this.driver = driver;
  }

  public List<RestaurantRequest> getRestuarants() {
    return restuarants;
  }

  public void setRestuarants(List<RestaurantRequest> restuarants) {
    this.restuarants = restuarants;
  }

  public List<CustomerRequest> getCustomers() {
    return customers;
  }

  public void setCustomers(List<CustomerRequest> customers) {
    this.customers = customers;
  }
}
