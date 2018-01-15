<%--
  Created by IntelliJ IDEA.
  User: milko.mitropolitsky
  Date: 11/29/17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  </head>
  <body>
  <script>
    $(document).ready(function () {
      getPlanes()
    })

    function getPlanes() {
      $.ajax({
        method: "get",
        url: "/api/planes",
        error: function () {
          alert("error");
        },
        success: function (data) {
          loadTable(data);
        }
      })
    }

    function loadTable(data) {
          var content = "";
          for(var item in data) {
            var body = "<tr>";
            body += ("<td>" + data[item].id + "</td>");
            body += ("<td>" + data[item].manufacturer + "</td>");
            body += ("<td>" + data[item].model + "</td>");
            body += ("<td>" + data[item].weight + "</td>");
            body += ("<td>" + data[item].cockpitCrew + "</td>");
            body += ("<td>" + data[item].seats + "</td>");
            body += ("<td>" + data[item].length + "</td>");
            body += ("<td>" + data[item].wingspan + "</td>");
            body += ("<td>" + data[item].range + "</td>");
            body += ("<td>" + data[item].fuelCapacity + "</td>");
            body += ("<td>" + data[item].speed + "</td>");
            body += ("<td>" + data[item].price + "</td>");
            body += ("<td> <button onclick='edit(" + data[item].id + ")'>Edit</button> </td>");
            body += ("<td> <button onclick='remove(" + data[item].id + ")'>Delete</button> </td> </tr>");
            content += body
          }
          $("#table").html(content);
    }

    function edit(id) {
        $.ajax({
            method: 'GET',
            url: '/api/planes/' + id,
            success: function (data) {
              $("#id").val(data.id)
              $("#manufacturer").val(data.manufacturer)
              $("#model").val(data.model)
              $("#weight").val(data.weight)
              $("#cockpitCrew").val(data.cockpitCrew);
              $("#seats").val(data.seats)
              $("#length").val(data.length)
              $("#wingspan").val(data.wingspan)
              $("#fuelCapacity").val(data.fuelCapacity)
              $("#speed").val(data.speed)
              $("#price").val(data.price)
              $("#update").show()
        }
      });
    }

    function remove(id) {
      $.ajax({
        method: "DELETE",
        url: "api/planes/" + id,
        success: function() {
          getPlanes();
        }
      })
    }
    function addPlane() {
      var json = {}
      $(".input").each(function () {
        json[$(this).attr('name')] = $(this).val()
      })
      $.ajax({
        method: "POST",
        url: "/api/planes",
        data: JSON.stringify(json),
        headers: {"Content-Type": "application/json"}
      }).done(function () {
        loadTable()
      })
    }
    
    function findPlanes() {
      var json = {}
      $(".input").each(function () {
        if ($(this).val() != "")
          json[$(this).attr('name')] = $(this).val()
      })

      $.ajax({
        method: "GET",
        url: "/api/planes",
        data: $.param(json),
        headers: {"Content-Type": "application/json"},
        success: function (data) {
          loadTable(data)
        }
      })
    }

      function updatePlane() {
        var id = $("#id").val()
        var newPlane = {}
        $(".upd").each(function () {
          newPlane[$(this).attr("id")] = $(this).val();
        });
        $.ajax({
          method: "PUT",
          url: "/api/planes/" + id,
          headers: {"Content-Type" : "application/json"},
          data: JSON.stringify(newPlane),
          success: function () {
            getPlanes()
            $("#update").hide()
          }
        })
      }
  </script>
  <div id="update" hidden>
      <input class="upd" id="id" type="text" name="id" hidden>
      Manufacturer:     <input class="upd" id="manufacturer" type="text" value=""><br>
      Model: <input class="upd" id="model" type="text" name="model" value=""><br>
      Weight:     <input class="upd" id="weight" type="text" name="weight" value=""><br>
      CockpitCrew:   <input class="upd" id="cockpitCrew" type="text" name="cockpitCrew" value=""><br>
      Seats:    <input class="upd" id="seats" type="text" name="seats" value=""><br>
      Length:  <input class="upd" id="length" type="text" name="length" value=""><br>
      WingSpan:  <input class="upd" id="wingspan" type="text" name="wingspan" value=""><br>
      FuelCapacity:  <input class="upd" id="fuelCapacity" type="text" name="fuelCapacity" value=""><br>
      Speed:  <input class="upd" id="speed" type="text" name="speed" value=""><br>
      Price:  <input class="upd" id="price" type="text" name="price" value=""><br>
      <button onclick="updatePlane()">Update</button>
  </div>
  <table>
      <tr>
          <th>id</th>
          <th>Manufacturer</th>
          <th>Model</th>
          <th>Weight</th>
          <th>CockpitCrew</th>
          <th>Seats</th>
          <th>Length</th>
          <th>WingSpan</th>
          <th>range</th>
          <th>FuelCapacity</th>
          <th>Speed</th>
          <th>Price</th>
      </tr>
      <tbody id="table">
      </tbody>
  </table>
  <div>
      Id:       <input class="input" type="text" name="id"><br>
      Manufacturer:     <input class="input" type="text" name="manufacturer"><br>
      Model: <input class="input" type="text" name="model"><br>
      Weight:     <input class="input" type="text" name="weight"><br>
      CockpitCrew:   <input class="input" type="text" name="cockpitCrew"><br>
      Seats:    <input class="input" type="text" name="seats"><br>
      Length:  <input class="input" type="text" name="length"><br>
      WingSpan:  <input class="input" type="text" name="wingspan"><br>
      FuelCapacity:  <input class="input" type="text" name="fuelCapacity"><br>
      Speed:  <input class="input" type="text" name="speed"><br>
      Price:  <input class="input" type="text" name="price"><br>

      <button onclick="findPlanes()">Find</button>
      <button onclick="addPlane()">Create</button>
  </div>
  <form action = "/api/planes" method = "post" enctype = "multipart/form-data">
      <input type = "file" name = "file" accept=".csv" />
      <br/>
      <input type = "submit" value = "Upload File" />
    </form>
  <form action="/api/planes/download" method="GET">
    <input type="submit" value="Download" />
    </form>
  </body>
</html>
