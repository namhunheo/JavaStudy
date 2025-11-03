package omok1;

import java.util.Scanner;

public class Omok {
    public static void main(String[] args) {
        Player playerA = new Player("사용자", "O");
        Player playerB = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, playerA, playerB);
    }

    private static void play(Board board, Player playerA, Player playerB) {
        Scanner scanner = new Scanner(System.in);
        Player current = playerA;

        while (true) {
            board.print();
            System.out.print(current.name + " > ");

            String colInput = scanner.next().toUpperCase();
            int row = scanner.nextInt();

            int col = colInput.charAt(0) - 65;

            //유효성 검사
            if (!board.placeStone(row, col, current.stone)) {
                System.out.println("안돼 돌아가");
                continue;
            }

            // 오목 체크
    		boolean check = board.check();
    		if (check) {
    			System.out.println("이겼다앙");
    			break;
    		}
            
            // 플레이어 교체
            current = (current == playerA) ? playerB : playerA;
        }

        scanner.close();
    }
}
