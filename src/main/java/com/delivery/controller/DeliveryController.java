package com.delivery.controller;

import com.delivery.model.DriverRequest;
import com.delivery.model.Location;
import com.delivery.model.RestaurantRequest;
import com.delivery.service.DeliveryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class DeliveryController {
//  public static void main(String[] args) {
//    Location deliveryExecutiveLocation = new Location(12.9715987, 77.594566);
//    List<Location> restaurantLocations = new ArrayList<>();
//    restaurantLocations.add(new Location(12.9611159, 77.6362214));
//    restaurantLocations.add(new Location(12.9889055, 77.574044));
//
//    List<Location> customerLocations = new ArrayList<>();
//    customerLocations.add(new Location(12.935192, 77.6244807));
//    customerLocations.add(new Location(12.9538477, 77.3507442));
//
//    List<Double> prepTimes = new ArrayList<>();
//    prepTimes.add(10.0);
//    prepTimes.add(15.0);
//
//    DeliveryService deliveryService = new DeliveryService();
//    Double optimalRoute = deliveryService.findOptimalRoute(deliveryExecutiveLocation,
//        restaurantLocations, customerLocations, prepTimes);
//
//    System.out.println(optimalRoute);
//  }

  //  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
////    readCoordinates()
//    Location deliveryExecutiveLocation = new Location(12.9715987, 77.594566);
//    List<Location> restaurantLocations = new ArrayList<>();
//    restaurantLocations.add(new Location(12.9611159, 77.6362214));
//    restaurantLocations.add(new Location(12.9889055, 77.574044));
//
//    List<Location> customerLocations = new ArrayList<>();
//    customerLocations.add(new Location(12.935192, 77.6244807));
//    customerLocations.add(new Location(12.9538477, 77.3507442));
//
//    List<Double> prepTimes = new ArrayList<>();
//    prepTimes.add(10.0);
//    prepTimes.add(15.0);
//
//    DeliveryService deliveryService = new DeliveryService();
//    Double optimalRoute = deliveryService.findOptimalRoute(deliveryExecutiveLocation,
//        restaurantLocations, customerLocations, prepTimes);
//
//    System.out.println(optimalRoute);
//  }
//
//  public static Pair<Double, Double> readCoordinates(Scanner scanner, String prompt) {
//    System.out.println(prompt);
//    System.out.print("Longitude: ");
//    double lat = scanner.nextDouble();
//    System.out.print("Longitude: ");
//    double lon = scanner.nextDouble();
//    return new Pair<>(lat, lon);
//  }
//
  @Autowired
  private DeliveryService deliveryService;

  @PostMapping("/bestRoute")
  public Double getBestRoute(@RequestBody DriverRequest driverRequest) {
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
