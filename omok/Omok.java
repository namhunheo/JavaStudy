package omok;

import java.util.Scanner;

public class Omok {
    public static void main(String[] args) {
        Player playerA = new Player("사용자", "O");
        Player playerB = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, playerA, playerB);
    }

    private static void play(Board board, Player playerA, Player playerB) {
        Scanner sc = new Scanner(System.in);
        Player current = playerA;

        while (true) {
            board.print();
            System.out.print(current.name + " > ");

            String colInput = sc.next().toUpperCase();
            int row = sc.nextInt();

            int col = colInput.charAt(0) - 'A';

            //유효성 검사
            if (!board.placeStone(row, col, current.stone)) {
                System.out.println("노농 다시ㄱ");
                continue;
            }

            // 승리 판정
            if (board.checkWin(current.stone)) {
                board.print();
                System.out.println(current.name + " (" + current.stone + ") 이김");
                break;
            }

            // 플레이어 교체
            current = (current == playerA) ? playerB : playerA;
        }

        sc.close();
    }
}
