# Delivery Optimizer

## Overview

Best Route Problem is a Java Spring Boot application designed to calculate the optimal delivery
route for a delivery executive. It considers multiple restaurant and customer locations and
optimizes the route to minimize the total delivery time.


## How It Works

The Delivery Optimizer application calculates the optimal delivery route using the following steps:

1. **Calculate the Haversine distance** between two geographical points.
2. **Compute travel time** based on the distance and a predefined speed.
3. **Generate all valid permutations** of restaurant and customer visits.
4. **Evaluate each permutation** to find the one with the minimum total delivery time.
5. **Return the optimal route and time** in a JSON response.

## API Endpoint

### `GET /api/v1/bestRoute`

This endpoint calculates the optimal delivery route based on the provided driver, restaurant, and
customer locations, as well as preparation times for each restaurant.

#### Request Payload

```json
{
  "driver": {
    "latitude": 1.0,
    "longitude": 1.0
  },
  "restuarants": [
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    },
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    },
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    }
  ],
  "customers": [
    {
      "latitude": 1.0,
      "longitude": 1.0
    },
    {
      "latitude": 1.0,
      "longitude": 1.0
    },
    {
      "latitude": 1.0,
      "longitude": 1.0
    }
  ]
}
```

#### Response

```json
{
  "time": 1.1,
  "path": [
    "R1",
    "C1",
    "R2",
    "R3",
    "C3",
    "C2"
  ]
}
```

### Example Usage

You can test the API using a tool like `curl` or Postman.

#### Using `curl`

```sh
curl -X GET "http://localhost:8080/api/v1/bestRoute" -H "Content-Type: application/json" -d '{
  "driver": {
    "latitude": 1.0,
    "longitude": 1.0
  },
  "restuarants": [
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    },
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    },
    {
      "latitude": 1.0,
      "longitude": 1.0,
      "preptime": 0.3
    }
  ],
  "customers": [
    {
      "latitude": 1.0,
      "longitude": 1.0
    },
    {
      "latitude": 1.0,
      "longitude": 1.0
    },
    {
      "latitude": 1.0,
      "longitude": 1.0
    }
  ]
}'
```

## Classes and Methods

### `DeliveryController`

Handles the `/api/v1/bestRoute` endpoint, converting JSON input into appropriate objects and calling
the `DeliveryService` to calculate the optimal route.

### `DeliveryService`

Contains the `findOptimalRoute` method that uses the `DeliveryOptimizer` utility to compute the
optimal delivery route.

### `DeliveryOptimizer`

Contains all the core logic for calculating distances, travel times, and generating permutations to
find the optimal route.

### Models

- `DriverRequest`
- `RestaurantRequest`
- `CustomerRequest`
- `Location`
- `OptimalRoute`

These classes represent the input and output data structures used by the API.

## Constants

### `DeliveryOptimizerConstants`

Defines constants such as `EARTH_RADIUS` and `SPEED` used in the distance and time calculations.

## Building and Running the Application

1. **Build the project** using Maven:
   ```sh
   mvn clean install
   ```

2. **Run the application**:
   ```sh
   java -jar target/delivery-optimizer-1.0.0.jar
   ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```