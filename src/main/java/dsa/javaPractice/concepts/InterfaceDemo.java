package dsa.javaPractice.concepts;

/*
 -> To declare an interface, use the interface keyword.
 -> All the methods in an interface are declared with an empty body and
    are public and abstract by default
 -> All variables are public, static, and final by default.
    example:
*/

public class InterfaceDemo {

    static interface Player
    {
        int id = 10;
        int move();
    }

    static class CricketPlayer implements Player{
        @Override
        public int move(){
            System.out.println("moving like cricket player");
            return 1;
        }
    }

    public static void main(String[] args) {
        CricketPlayer cp = new CricketPlayer();
        System.out.println(cp.move());

        Player p = new Player(){
            @Override
            public int move(){
                System.out.println("moving like a  player : defined using anonymous class");
                return 2;
            }
        };
        System.out.println(p.move());
    }
}

/*
->
    Uses of Interfaces in Java are mentioned below:

    1) It is used to achieve total abstraction.
    2) Since java does not support multiple inheritances in the case of class,
    by using an interface it can achieve multiple inheritances.
    3) Any class can extend only one class, but can implement multiple interfaces.
    4) It is also used to achieve loose coupling.
    5) Interfaces are used to implement abstraction.
*/
