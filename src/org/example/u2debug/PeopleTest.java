package org.example.u2debug;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

  @BeforeEach
  void init() {
    System.out.println("\t Here is People test...");
  }

  @Test
  void ageTest() throws Exception {
    System.out.println("\t Here is age test...");
    Person c = new Person(2000,"Sharon");
    int actualValue = c.age(c.getBirthdayYear());
    int expectedValue = 23;
    assertAll("age calculation",
        ()-> assertEquals(expectedValue, actualValue),
        ()-> assertEquals(43, c.age(1980)),
        ()-> assertEquals(1723, c.age(300))
    );
  }
}