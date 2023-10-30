import java.util.Random;

class GameOfLife {
    private int size;
    private boolean[][] grid;

    public GameOfLife(int size) {
        this.size = size;
        this.grid = new boolean[size][size];
        initializeGrid();
    }

    // Method to initialize the grid randomly
    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    // Method to determine the number of live neighbors for a cell
    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the current cell
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
                    if (grid[newX][newY]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Method to compute the next generation based on the current grid
    public void nextGeneration() {
        boolean[][] newGrid = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (grid[i][j]) {
                    // Cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        newGrid[i][j] = false; // Dies due to underpopulation or overpopulation
                    } else {
                        newGrid[i][j] = true; // Survives
                    }
                } else {
                    // Cell is dead
                    if (liveNeighbors == 3) {
                        newGrid[i][j] = true; // Becomes alive due to reproduction
                    } else {
                        newGrid[i][j] = false; // Stays dead
                    }
                }
            }
        }

        grid = newGrid; // Update the grid with the new generation
    }

    // Method to display the current grid (for testing purposes)
    public void displayGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int gridSize = 8; // Size of the grid (8x8)
        GameOfLife game = new GameOfLife(gridSize);

        System.out.println("Initial Grid:");
        game.displayGrid();

        // Generating a specific number of generations (change the loop count as needed)
        for (int i = 0; i < 5; i++) {
            game.nextGeneration();
            System.out.println("\nGeneration " + (i + 1) + ":");
            game.displayGrid();
        }
    }
}
