package com.delivery.service;

import com.delivery.model.Location;
import com.delivery.util.DeliveryOptimizer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

  public Double findOptimalRoute(
      Location deliveryExecutiveLocation,
      List<Location> restaurantLocations,
      List<Location> customerLocations,
      List<Double> prepTimes
  ) {
    return DeliveryOptimizer.findOptimalRoute(deliveryExecutiveLocation, restaurantLocations,
        customerLocations, prepTimes);
  }
}

