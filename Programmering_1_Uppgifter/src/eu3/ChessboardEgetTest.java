package eu3;
import eu3.Chessboard.*;

public class ChessboardEgetTest {

	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
//		Pawn p1 = chessboard.new Pawn('w', 'P');
//		King k1 = chessboard.new King('b', 'K');
//		p1.moveTo('c', (byte) 4);
//		p1.markReachableFields();
//		k1.moveTo('e', (byte) 6);
//		k1.markReachableFields();
//		Rook r1 = chessboard.new Rook('b', 'R');
//		r1.moveTo('e', (byte) 4); 
//		r1.markReachableFields();
		Knight b1 = chessboard.new Knight('b', 'Q');
		b1.moveTo('a', (byte) 2); 
		b1.markReachableFields();
		System.out.println(chessboard);
		
		
	}

}
