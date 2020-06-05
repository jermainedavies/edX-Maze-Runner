import java.util.Scanner;

import static java.lang.System.exit;

public class MazeRunner {
    static String dirInput;
    static int count = 0;
    static Maze myMap = new Maze();
    static Scanner userInput = new Scanner(System.in);

    public static void intro () {
        System.out.println("Welcome to my cool new maze!\n\nI'd like to show you the current state of the map, along with your position\n");
        myMap.printMap();
    }
    public static String userMove () {

        while (count < 101) {
            if (count == 50) {
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes\n");
            }
            else if (count == 75) {
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.\n");
            }
            else if (count == 90) {
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!\n");
            }
            else if (count == 100) {
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[\n");
                System.out.println("GAME OVER!");
                exit(0);
            }
            else if (myMap.didIWin() & count < 100) {
                System.out.println("Well done! You made it out alive in " + count + " moves.");
                System.out.println("Game over!");
                exit(0);


            }
                System.out.println("which direction would you like to move in? (l, r, u, d)");
                dirInput = new String (userInput.nextLine().toUpperCase());
                if (dirInput.startsWith("L")) {
                    dirInput = "Left";

                    myMap.canIMoveLeft();

                    if(myMap.canIMoveLeft()) {
                        myMap.moveLeft();
                        count++;
                        myMap.printMap();
                    }
                    else if (myMap.isThereAPit(dirInput)) {
                        System.out.println("OH NO, A PIT!!!");
                        navigatePit();
                    }


                    else {
                        System.out.println("Sorry, there's a wall here. Pick a different direction.");
                        myMap.printMap();
                    }
                }
                else if (dirInput.startsWith("R")) {
                    dirInput = "Right";

                    myMap.canIMoveRight();
                    if (myMap.canIMoveRight()) {
                        myMap.moveRight();
                        count++;
                        myMap.printMap();
                    }
                    else if (myMap.isThereAPit(dirInput)) {
                        System.out.println("OH NO, A PIT!!!");
                        navigatePit();
                    }
                    else {
                        System.out.println("Sorry, there's a wall here. Pick a different direction.");
                        myMap.printMap();
                    }

                }
                else if (dirInput.startsWith("U")) {
                    dirInput = "Up";

                    myMap.canIMoveUp();
                    if (myMap.canIMoveUp()) {
                        myMap.moveUp();
                        count++;
                        myMap.printMap();
                    }
                    else if (myMap.isThereAPit(dirInput)) {
                        System.out.println("OH NO, A PIT!!!");
                        navigatePit();
                    }
                    else {
                        System.out.println("Sorry, there's a wall here. Pick a different direction.");
                        myMap.printMap();
                    }
                }
                else if (dirInput.startsWith("D")) {
                    dirInput = "Down";
                    myMap.canIMoveDown();
                    if (myMap.canIMoveDown()) {
                        myMap.moveDown();
                        count++;
                        myMap.printMap();
                    }
                    else if (myMap.isThereAPit(dirInput)) {
                        System.out.println("OH NO, A PIT!!!");
                        navigatePit();
                    }
                    else {
                        System.out.println("Sorry, there's a wall here. Pick a different direction.");
                    }
                    myMap.printMap();
                }
                else {
                    System.out.println("enter one of the options");
                    myMap.printMap();
                }

                System.out.println("you have chosen to move: " + dirInput);

            }
        return dirInput;
        }



        public static void navigatePit() {
            System.out.println("Caution! Pit ahead. Jump it? (Y)");
            String dir = dirInput;
            String jumpInput = userInput.next();
            if (jumpInput.startsWith("y")) {
                myMap.jumpOverPit(dir);
                myMap.printMap();
                System.out.println("You have chosen to jump: " + dirInput);
                count++;
            }
             else {
                 userMove();
                }
            }





    public static void main (String[] args) {
        intro();
        userMove();
            }
        }



