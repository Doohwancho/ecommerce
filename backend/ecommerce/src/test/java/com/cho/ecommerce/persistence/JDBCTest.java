package com.cho.ecommerce.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
public class JDBCTest {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("MySQL Connection Test")
    public void testConnection() {
        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=Asia/Seoul",
                            "root",
                            "")){
            System.out.println(con);
            Assertions.assertThat(con).isNotNull();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
