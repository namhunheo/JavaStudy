package omok1;

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
    	// 오목판 벗어날 경우
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        // 기존에 돌이 있는 경우
        if (!map[row][col].equals(".")) return false;
        map[row][col] = stone;
        return true;
    }

    public boolean check() {
    	// 가로 체크
    	boolean flag = false;

    	for (int i = 4; i < size - 4; i++) {
    		for (int j = 4; j < size - 4; j++) {
    			// 가로 오목 체크
    			if (map[i][j] == "O" && map[i][j+1] == "O" && map[i][j+2] == "O" && map[i][j+3] == "O" && map[i][j+4] == "O" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			if (map[i][j] == "X" && map[i][j+1] == "X" && map[i][j+2] == "X" && map[i][j+3] == "X" && map[i][j+4] == "X" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			
    			// 세로 오목 체크
    			if (map[i][j] == "O" && map[i+1][j] == "O" && map[i+2][j] == "O" && map[i+3][j] == "O" && map[i+4][j] == "O" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			if (map[i][j] == "X" && map[i+1][j] == "X" && map[i+2][j] == "X" && map[i+3][j] == "X" && map[i+4][j] == "X" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			// 대각선 좌상우하 방향 체크
    			if (map[i][j] == "O" && map[i+1][j+1] == "O" && map[i+2][j+2] == "O" && map[i+3][j+3] == "O" && map[i+4][j+4] == "O" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			if (map[i][j] == "X" && map[i+1][j+1] == "X" && map[i+2][j+2] == "X" && map[i+3][j+3] == "X" && map[i+4][j+4] == "X" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			// 대각선 좌하우상 방향 체크
    			if (map[i][j] == "O" && map[i-1][j+1] == "O" && map[i-2][j+2] == "O" && map[i-3][j+3] == "O" && map[i-4][j+4] == "O" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}
    			if (map[i][j] == "X" && map[i-1][j+1] == "X" && map[i-2][j+2] == "X" && map[i-3][j+3] == "X" && map[i-4][j+4] == "X" ) {
    				System.out.println("오목 승");
    				flag = true;
    			}

    		}
    	}
        return flag;
    }
}
