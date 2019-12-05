package eu3;

import java.util.Random;


public class ReachableFieldsOnChessboard {

	public static void main(String[] args) {
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
		rand.ints(97, 104);
		System.out.println(rand.ints(97, 104));
//		char rad = (char) (rand.ints);
//		//rand.ints((int)Chessboard.FIRST_ROW, (Chessboard.NUMBER_OF_ROWS + Chessboard.FIRST_ROW)
//		for(Chessboard.Chesspiece piece : pieces) {
//			
//			
//			
//			piece.moveTo(, 
//					
//					(byte) (rand.ints(Chessboard.FIRST_COLUMN, Chessboard.NUMBER_OF_COLUMNS)));
//		}
	}
}
