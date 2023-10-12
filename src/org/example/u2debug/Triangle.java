package org.example.u2debug;
/*
利用三個邊長確認為何種三角形
 */
public class Triangle {

  public static void main(String[] args) throws TriangleException {
    Triangle at = new Triangle();
    //多個案例
    System.out.println(at.checkTriangle(1, 1, 1)); //正三角形
    System.out.println(at.checkTriangle(2, 2, 3)); //等腰三角形
    System.out.println(at.checkTriangle(3, 2, 2)); //等腰三角形
    System.out.println(at.checkTriangle(0, -1, -2)); //非三角形
    System.out.println(at.checkTriangle(10, 23, 11)); //非三角形
  }

  public String checkTriangle(int a, int b, int c) throws TriangleException {

    if (a <= 0 || b <= 0 || c <= 0) {
      throw new TriangleException("三角形邊長不能為負或0");
    }
    assert a > 0 && b > 0 && c > 0 : "三角形邊長有為負或0";
    if (a + b > c && b + c > a && c + a > b) { //所有三角形皆符合 任兩邊相加大於第三邊
      if (a == b) {
        if (b == c) {
          return "正三角形";
        }
        else {
          return "等腰三角形";
        }
      }
      else if (b == c) {
        assert (a != b);
        return "等腰三角形";
      }
      assert (a != b) : "a==b";
      assert (a != c) : "a==c";
      assert (b != c) : "c==b";
      return "三角形";
    }
    throw new TriangleException(a, b, c);
  }
}

// 三角形的例外，並封裝了三邊
class TriangleException extends Exception {
  int wrongA;
  int wrongB;
  int wrongC;

  public TriangleException(String title) {
    super(title);
  }

  public TriangleException(int a, int b, int c) {//封裝三邊長

    super("非三角形");
    this.wrongA = a;
    this.wrongB = b;
    this.wrongC = c;
  }

  public int getWrongA() {
    return wrongA;
  }

  public int getWrongB() {
    return wrongB;
  }

  public int getWrongC() {
    return wrongC;
  }

}
