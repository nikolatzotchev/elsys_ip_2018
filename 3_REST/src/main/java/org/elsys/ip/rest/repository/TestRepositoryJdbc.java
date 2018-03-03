//package org.elsys.ip.rest.repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import org.elsys.ip.rest.model.Plane;
//
//public class TestRepositoryJdbc {
//  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//  static final String DB_URL = "jdbc:mysql://localhost/plane";
//
//  public List<Plane> getPlaneList() {
//    List<Plane> planes = new ArrayList<>();
//    Connection conn = null;
//    try {
//      Class.forName(JDBC_DRIVER);
//      conn = DriverManager.getConnection(DB_URL, "root", "nikola12345");
//
//      Statement stmt = null;
//      ResultSet rs = null;
//
//      try {
//        stmt = conn.createStatement();
//        String sql = "SELECT id FROM plane";
//        rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//          Plane p = new Plane();
//          p.setId(rs.getInt("id"));
//          planes.add(p);
//        }
//      }finally {
//        try {
//          if (!stmt.isClosed()) {
//            stmt.close();
//          }
//          if (!rs.isClosed()) {
//            rs.close();
//          }
//        } catch (SQLException e) {
//          e.printStackTrace();
//        }
//      }
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }finally {
//      assert conn != null;
//      try {
//        conn.close();
//      } catch (SQLException e) {
//        e.printStackTrace();
//      }
//    }
//    return planes;
//  }
//
//}
