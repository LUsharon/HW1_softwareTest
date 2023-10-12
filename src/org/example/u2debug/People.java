package org.example.u2debug;

public class People {

  public static void main(String[] args) throws Exception {

    int height = 300; //cm
    int weight = 60; //kg
    Person sam = new Person(2005, "Sam");
    sam.setHW(height, weight);//如果身高體重有問題 在這裡會丟出exception
    assert (height >= 40 && height <= 260 && weight >= 1 && weight <= 700) : "身高體重有問題";//斷言以下身高體重正常
    double bmi = sam.getBMI();
    System.out.println("name: " + sam.getName());
    System.out.printf("BMI: %.2f\n", bmi);
    System.out.println("age: " + sam.age(sam.getBirthdayYear()));
    System.out.printf("\n");

    Person john = new Person(2300, "John");
    try {
      john.setHW(150, 80);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    assert (height >= 40 && height <= 260 && weight >= 1 && weight <= 700); //斷言以下身高體重正常
    bmi = john.getBMI();
    System.out.println("name: " + john.getName());
    System.out.printf("BMI: %.2f\n", bmi);
    System.out.println("age: " + john.age(john.getBirthdayYear()));
    System.out.printf("\n");

    Person nick = null;
    try {
      nick = new Person(1990, "name", 1.7f, 60);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    nick.setHW(1.7f, 60);
    bmi = nick.getBMI();
    System.out.println("name: " + nick.getName());
    System.out.printf("BMI: %.2f\n", bmi);
    System.out.println("age: " + nick.age(nick.getBirthdayYear()));
    System.out.printf("\n");
  }
}

class Person {
  int birthdayYear;
  String name;
  double height; //cm
  double weight; //kg
  double BMI;

  public Person(int birthdayYear, String name) throws Exception {
    if (birthdayYear > 2023 || birthdayYear < 0) {
      throw new Exception("Invalid birthdayYear");
    }
    this.birthdayYear = birthdayYear;
    this.name = name;
  }

  public Person(int birthdayYear, String name, double height, double weight) throws Exception {
    if (birthdayYear > 2023 || birthdayYear < 0) {
      throw new Exception("Invalid birthdayYear");
    }
    if (height < 40 || height > 260) {
      throw new Exception("Invalid height");
    }
    if (weight < 1 || weight > 700) {
      throw new Exception("Invalid weight");
    }
    this.birthdayYear = birthdayYear;
    this.name = name;
    this.height = height;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getBirthdayYear() {
    return birthdayYear;
  }

  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }

  public double BMI(double height, double weight) {
    double bmi = weight / ((0.01 * height) * (0.01 * height));
    return bmi;
  }

  public double getBMI() {
    return BMI(height, weight);
  }

  public int age(int birthdayYear){
    return 2023 - birthdayYear;
  }

  public void setHW(double height, double weight) throws Exception {
    if (height < 40 || height > 260) {
      throw new Exception("Invalid height");
    }
    if (weight < 1 || weight > 700) {
      throw new Exception("Invalid weight");
    }
    this.height = height;
    this.weight = weight;
    this.BMI = weight / (height * height);
  }
}
