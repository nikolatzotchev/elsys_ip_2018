package org.elsys.ip.rest.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.core.MultivaluedMap;
import org.elsys.ip.rest.model.Plane;

public class PlaneRepository {
  private static List<Plane> planeList = new ArrayList<>(
      Arrays.asList(
          new Plane(1, "boing", "f14", 23.4, 3, 5, 1400.2, 500.0, 30000.0, 17600.0, 800.0, 144000000),
          new Plane(2, "airbus", "a331", 23.4, 3, 5, 1400.2, 500.0, 30000.0, 17600.0, 800.0, 144000000),
          new Plane(3, "airbus", null, 23.4, 3, 5, 1400.2, 500.0, 30000.0, 17600.0, 800.0, 144000000)

      )
  );

  public List<Plane> getAllPlanes() {
    return planeList;
  }
  public List<Plane> getPlaneList(MultivaluedMap<String, String> params) {
    if (params.size() != 0) {
      List<Plane> filterPlanes = new ArrayList<>();
      for (Plane plane : planeList) {

        if (params.get("id") != null &&
            !params.get("id").contains(String.valueOf(plane.getId()))) {
          continue;
        }
        if (params.get("manufacturer") != null &&
            !params.get("manufacturer").contains(plane.getManufacturer())) {
          continue;
        }
        if (params.get("model") != null &&
            !params.get("model").contains(plane.getModel())) {
          continue;
        }
        if (params.get("weight") != null &&
            params.get("weight").contains(String.valueOf(plane.getWeight()))) {
          continue;
        }
        if (params.get("cockpitCrew") != null &&
            params.get("cockpitCrew").contains(String.valueOf(plane.getCockpitCrew()))) {
          continue;
        }
        if (params.get("seats") != null &&
            params.get("seats").contains(String.valueOf(plane.getSeats()))) {
          continue;
        }
        if (params.get("lenght") != null &&
            params.get("lenght").contains(String.valueOf(plane.getLength()))) {
          continue;
        }
        if (params.get("wingspan") != null &&
            params.get("wingspan").contains(String.valueOf(plane.getWingspan()))) {
          continue;
        }
        if (params.get("range") != null &&
            params.get("range").contains(String.valueOf(plane.getRange()))) {
          continue;
        }
        if (params.get("fuelCapacity") != null &&
            params.get("fuelCapacity").contains(String.valueOf(plane.getFuelCapacity()))) {
          continue;
        }
        if (params.get("speed") != null &&
            params.get("speed").contains(String.valueOf(plane.getSpeed()))) {
          continue;
        }
        if (params.get("price") != null &&
            params.get("price").contains(String.valueOf(plane.getPrice()))) {
          continue;
        }
        filterPlanes.add(plane);
      }
      return filterPlanes;
    }
    return planeList;
  }

  public Optional<Plane> getPlaneById(Integer id) {
    return planeList.stream().filter(test -> test.getId() == id).findFirst();
  }

  public Plane savePlane(Plane plane) {
    planeList.add(plane);
    return plane;
  }

  public Plane updatePlane(Integer id, Plane plane) {
    int realId = id - 1;
    planeList.set(realId, plane);
    return plane;
  }

  public void deletePlane(Integer id) {
    planeList.removeIf(it -> it.getId() == id);
  }
}
