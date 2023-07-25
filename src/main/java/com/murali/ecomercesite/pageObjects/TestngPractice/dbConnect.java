package com.murali.ecomercesite.pageObjects.TestngPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnect {

    public static void main(String[] args) {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "XXXXXX";
        String password = "XXXXXX";
        String query = "select * from XXXXXX";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        }catch (Exception e){
            System.out.println("Exception caught");
        }



    }
}
