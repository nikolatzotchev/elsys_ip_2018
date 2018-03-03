package org.elsys.ip.rest.service;

import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import org.elsys.ip.rest.model.Plane;
import org.elsys.ip.rest.repository.PlaneRepository;

public class PlaneService {

  private PlaneRepository planeRepository = new PlaneRepository();


  public List<Plane> getPlaneList(MultivaluedMap<String, String> params) {
    return planeRepository.getPlaneList(params);
  }

  public List<Plane> getAllPlanes()
  {
    return planeRepository.getAllPlanes();
  }
  public Plane savePlane(Plane plane) {
    return planeRepository.savePlane(plane);
  }

  public void deletePlane(int id) {
    planeRepository.deletePlane(id);
  }

  public Plane getPlane(int id) {
    return planeRepository.getPlaneById(id);
  }

  public Plane updatePlane(int id, Plane plane) {
    return planeRepository.updatePlane(plane);
  }
}
