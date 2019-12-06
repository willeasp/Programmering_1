package eu3;

import java.util.Random;


public class ReachableFieldsOnChessboard {

	public static void main(String[] args) throws InterruptedException {
		Chessboard chessBoard = new Chessboard();
		System.out.println(chessBoard + "\n");
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
		
		pieces[0] = chessBoard.new Pawn('w', 'P');
		pieces[1] = chessBoard.new Rook('b', 'R');
		pieces[2] = chessBoard.new Queen('w', 'Q');
		pieces[3] = chessBoard.new Bishop('w', 'B');
		pieces[4] = chessBoard.new King('b', 'K');
		pieces[5] = chessBoard.new Knight('w', 'N');
		
		
		Random rand = new Random();
		int r = 0, c = 0;
		int sleep = 700;
		while (true) {
			for (Chessboard.Chesspiece piece : pieces) {
				System.out.println(chessBoard);
				Thread.sleep(sleep);
				r = rand.nextInt(Chessboard.NUMBER_OF_ROWS) + Chessboard.FIRST_ROW;
				c = rand.nextInt(Chessboard.NUMBER_OF_COLUMNS) + Chessboard.FIRST_COLUMN;
				piece.moveTo((char) r, (byte) (c));
				System.out.println(chessBoard);
				Thread.sleep(sleep);
				piece.markReachableFields();
				System.out.println(chessBoard);
				Thread.sleep(sleep);
				piece.unmarkReachableFields();
				System.out.println(chessBoard);
				piece.moveOut();
				Thread.sleep(sleep);
			}
		}
	}
}
