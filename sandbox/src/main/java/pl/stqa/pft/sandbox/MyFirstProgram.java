package pl.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args){

    Square s = new Square(2);
    System.out.println("Pole kwadratu długości" + s.a + "wynosi" + s.squareArea());

    Rectangle r = new Rectangle(2, 3);
    System.out.println("Pole prostokąta o bokach" + r.a + r.b + "wynosi" + r.rectangleArea());


  }





}