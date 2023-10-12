package org.example.u2debug;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @BeforeEach
  void init() {
    System.out.println("\t Here is Triangle test...");
  }
  @Test
  void testCheckTriangle() throws TriangleException {

    Triangle c = new Triangle();
    String expectedValue = "正三角形";
    String actualValue = c.checkTriangle(10, 10, 10);
    System.out.println("\t Here is checkTriangle test...");
    assertAll("CheckTriangle",
        () -> assertEquals(expectedValue, actualValue),
        ()-> assertEquals("等腰三角形", c.checkTriangle(15, 10, 10)),
        ()-> assertEquals("三角形", c.checkTriangle(17, 10, 8))
    );
  };
}
