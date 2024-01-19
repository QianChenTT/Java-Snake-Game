import java.util.Scanner;
public class App {
  
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
          Game game = new Game();
            System.out.print("press enter to start game");
            scanner.nextLine();
            game.start(); 
        }
    
  }
}

