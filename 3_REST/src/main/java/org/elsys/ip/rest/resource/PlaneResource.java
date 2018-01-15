package org.elsys.ip.rest.resource;

import au.com.bytecode.opencsv.CSVReader;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;
import org.elsys.ip.rest.model.Plane;
import org.elsys.ip.rest.service.PlaneService;

@Path("planes")
public class PlaneResource {

  private PlaneService planeService = new PlaneService();

  @GET
  @Produces("application/json")
  public List<Plane> getPlaneList(@Context UriInfo info) {
    MultivaluedMap<String, String> params = info.getQueryParameters();
    List<Plane> testList = planeService.getPlaneList(params);
    return testList;
  }

  @GET
  @Path("/{planeId}")
  @Produces("application/json")
  public Plane getPlane(@PathParam("planeId") int id) {
    return planeService.getPlane(id);
  }
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Plane> postCsv(@FormDataParam("file") File file)
      throws IOException {

    List<Plane> planeList = new ArrayList<>();
    CSVReader reader = new CSVReader(new FileReader(file));
    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
      if (nextLine.length == 1) {
        continue;
      }
      Plane plane;
      plane = new Plane(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2],
          Double.parseDouble(nextLine[3]), Integer.parseInt(nextLine[4]),
          Integer.parseInt(nextLine[5]), Double.parseDouble(nextLine[6]),
          Double.parseDouble(nextLine[7]), Double.parseDouble(nextLine[8]), Double.parseDouble(nextLine[9]),
          Double.parseDouble(nextLine[10]), Double.parseDouble(nextLine[11]));
      planeService.savePlane(plane);
      planeList.add(plane);
    }
    return planeList;
  }

  @GET
  @Path("download")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response downloadCsv() {
    StreamingOutput fileStream = output -> {
      for (Plane plane : planeService.getAllPlanes()) {
          output.write(String.format("%d,", plane.getId()).getBytes());
          output.write(String.format(plane.getManufacturer()+',').getBytes());
          output.write(String.format(plane.getModel()+',').getBytes());
          output.write(String.format("%d,", plane.getCockpitCrew()).getBytes());
          output.write(String.format("%d,", plane.getSeats()).getBytes());
          output.write(String.format("%f,", plane.getLength()).getBytes());
          output.write(String.format("%f,", plane.getWingspan()).getBytes());
          output.write(String.format("%f,", plane.getRange()).getBytes());
          output.write(String.format("%f,", plane.getFuelCapacity()).getBytes());
          output.write(String.format("%f,", plane.getSpeed()).getBytes());
          output.write(String.format("%f\n", plane.getPrice()).getBytes());
          output.flush();
      }
    };
    return Response.ok(fileStream).header("content-disposition","attachment; filename = myfile.csv").build();
  }

  @POST
  @Path("multiple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Plane> saveJsonPlane(List<Plane> planes) {
    for(Plane plane : planes) {
      planeService.savePlane(plane);
    }
    return planeService.getAllPlanes();
  }

  @Path("/{planeId}")
  @DELETE
  public void deletePlane(@PathParam("planeId") int id) {
    planeService.deletePlane(id);
  }

  @POST
  public Plane addPlane(Plane plane){
    return planeService.savePlane(plane);
  }

  @PUT
  @Path("/{planeId}")
  @Produces("application/json")
  @Consumes("application/json")
  public Plane updatePlane(@PathParam("planeId") int id, Plane plane) {
    return planeService.updatePlane(id, plane);
  }
}


