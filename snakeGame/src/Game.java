import java.io.BufferedOutputStream;
import java.util.Random;

public class Game {
    private Input input;
    private char[][] grid;
    private BufferedOutputStream buffer;
    private Snake snake;
    private Random rand = new Random();

    public Game() {
        this.input = new Input();
        this.grid = new char[30][30];
        this.snake = new Snake();
        buffer = new BufferedOutputStream(System.out);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    private void display() {
        try {
            for (int i = 0; i < 32; i++) {
                buffer.write('-');
            }
            buffer.write('\n');
            for (int i = 0; i < 30; i++) {
                buffer.write('|');
                for (int j = 0; j < 30; j++) {
                    buffer.write(grid[i][j]);
                }
                buffer.write('|');
                buffer.write('\n');
            }
            for (int i = 0; i < 32; i++) {
                buffer.write('-');
            }
            buffer.write('\n');
            buffer.flush();
        } catch (Exception e) {
        }
    }

    public void start() {
        generateFood();

        while (true) {
            if (!update()) {
                System.out.println("Game over!");
                input.setVisible(false);
                return;
            }
            display();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }

    }

    private boolean update() {
        Point tailPosition = snake.tail.position;
        int status = snake.move(input.direction);
        if (status == 0) {
            grid[tailPosition.y][tailPosition.x] = ' ';
        } else if (status == -1) {
            return false;
        }
        if (grid[snake.head.position.y][snake.head.position.x] == 'O') {
            return false;
        } else if (grid[snake.head.position.y][snake.head.position.x] == 'x') {
            snake.onPickup();
            generateFood();
        }
        grid[snake.head.position.y][snake.head.position.x] = 'O';
        return true;
    }
    private void generateFood() {
        int randomX = rand.nextInt(30);
        int randomY = rand.nextInt(30);
        if (grid[randomY][randomX] == 'O') {
            generateFood();
        } else {
            grid[randomY][randomX] = 'x';
        }

    }
}
