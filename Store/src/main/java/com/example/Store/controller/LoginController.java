package com.example.Store.controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

@Controller
@RequestMapping(path="/login")
public class LoginController {
	@RequestMapping("/auth")
   public String authanticateuser(@RequestParam("username") String userName,@RequestParam("password") String password) throws SQLException {
	  System.out.println("Hi this is Springboot project");
	  try {
		  String Query="select * from user_details";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/appstore", "root", "root");
		PreparedStatement ps = conn.prepareStatement(Query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		    System.out.println("user_id: " + rs.getString("user_id")+"password: " + rs.getString("password"));
		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   return "auth";
	   
	   
   }
}
