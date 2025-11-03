package omok;

public class Board {
    int size;
    String[][] map;

    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            System.out.printf("%2d ", row);
            for (int col = 0; col < size; col++) {
                System.out.print(" " + map[row][col]);
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int c = 0; c < size; c++) {
            System.out.print(" " + (char) ('A' + c));
        }
        System.out.println();
    }

    public boolean placeStone(int row, int col, String stone) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (!map[row][col].equals(".")) return false;
        map[row][col] = stone;
        return true;
    }

    public boolean checkWin(String stone) {
        int[][] dirs = { {0,1}, {1,0}, {1,1}, {1,-1} };
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!map[r][c].equals(stone)) continue;
                for (int[] d : dirs) {
                    int count = 1;
                    int nr = r + d[0];
                    int nc = c + d[1];
                    while (nr >= 0 && nr < size && nc >= 0 && nc < size && map[nr][nc].equals(stone)) {
                        count++;
                        nr += d[0];
                        nc += d[1];
                    }
                    if (count >= 5) return true;
                }
            }
        }
        return false;
    }
}
