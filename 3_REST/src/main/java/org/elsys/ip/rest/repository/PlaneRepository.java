package org.elsys.ip.rest.repository;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import org.elsys.ip.rest.model.Plane;
import org.elsys.ip.rest.persistence.HibernateUtil;
import org.hibernate.Session;

public class PlaneRepository {

  public List<Plane> getAllPlanes() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Plane> planes = session.createQuery("FROM Plane").list();
    session.getTransaction().commit();
    return planes;
  }
  public List<Plane> getPlaneList(MultivaluedMap<String, String> params) {
    List<Plane> allPlanes = getAllPlanes();
    if (params.size() != 0) {
      List<Plane> filterPlanes = new ArrayList<>();
      for (Plane plane : allPlanes) {

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
    return allPlanes;
  }

  public Plane getPlaneById(Integer id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Plane plane = session.get(Plane.class, id);
    session.getTransaction().commit();
    return plane;
  }

  public Plane savePlane(Plane plane) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(plane);
    session.getTransaction().commit();
    return plane;
  }

  public Plane updatePlane(Plane plane) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(plane);
    session.getTransaction().commit();
    return plane;
  }

  public void deletePlane(Integer id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(getPlaneById(id));
    session.getTransaction().commit();
  }
}
