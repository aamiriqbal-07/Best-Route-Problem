package com.delivery.controller;

import com.delivery.model.DriverRequest;
import com.delivery.model.Location;
import com.delivery.model.OptimalRoute;
import com.delivery.model.RestaurantRequest;
import com.delivery.service.DeliveryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class DeliveryController {

  @Autowired
  private DeliveryService deliveryService;

  @GetMapping("/bestRoute")
  public OptimalRoute getBestRoute(@RequestBody DriverRequest driverRequest) {
    Location driverLocation = new Location(driverRequest.getDriver().getLatitude(),
        driverRequest.getDriver().getLongitude());

    List<Location> restaurantLocations = driverRequest.getRestuarants().stream()
        .map(r -> new Location(r.getLatitude(), r.getLongitude()))
        .collect(Collectors.toList());

    List<Location> customerLocations = driverRequest.getCustomers().stream()
        .map(c -> new Location(c.getLatitude(), c.getLongitude()))
        .collect(Collectors.toList());

    List<Double> prepTimes = driverRequest.getRestuarants().stream()
        .map(RestaurantRequest::getPreptime)
        .collect(Collectors.toList());

    return deliveryService.findOptimalRoute(driverLocation, restaurantLocations, customerLocations,
        prepTimes);
  }
}
