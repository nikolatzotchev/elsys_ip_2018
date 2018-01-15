package org.elsys.ip.rest.model;

import com.sun.javafx.beans.IDProperty;
import java.io.Serializable;
import javax.annotation.Generated;

public class Plane implements Serializable{
  private int id;
  private String manufacturer;
  private String model;
  private double weight;
  private int cockpitCrew;
  private int seats;
  private double length;
  private double wingspan;
  private double range;
  private double fuelCapacity;
  private double speed;
  private double price;

  public Plane(int id, String manufacturer, String model, double weight, int cockpitCrew, int seats,
      double lenght, double wingspan, double range, double fuelCapacity, double speed, double price) {
    this.id = id;
    this.manufacturer = manufacturer;
    this.model = model;
    this.weight = weight;
    this.cockpitCrew = cockpitCrew;
    this.seats = seats;
    this.length = lenght;
    this.wingspan = wingspan;
    this.range = range;
    this.fuelCapacity = fuelCapacity;
    this.speed = speed;
    this.price = price;
  }

  public Plane() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getCockpitCrew() {
    return cockpitCrew;
  }

  public void setCockpitCrew(int cockpitCrew) {
    this.cockpitCrew = cockpitCrew;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double lenght) {
    this.length = lenght;
  }

  public double getWingspan() {
    return wingspan;
  }

  public void setWingspan(double wingspam) {
    this.wingspan = wingspam;
  }

  public double getRange() {
    return range;
  }

  public void setRange(double range) {
    this.range = range;
  }

  public double getFuelCapacity() {
    return fuelCapacity;
  }

  public void setFuelCapacity(double fuelCapacity) {
    this.fuelCapacity = fuelCapacity;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
