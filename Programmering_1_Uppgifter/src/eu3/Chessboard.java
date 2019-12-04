package eu3;

public class Chessboard {
	public static class Field {
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;
		
		/**
		 * konstruktor för ett objekt av typen field
		 * @param row
		 * @param column
		 */
		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}

		/**
		 * Ställer chackpjäsen i en ruta
		 * @param piece är en schackpjäs bror
		 */
		public void put(Chesspiece piece) {
			this.piece = piece;
		}

		/**
		 * returnerar piece och sätter piece till null
		 * @return schackpjäsen
		 */
		public Chesspiece take() {
			Chesspiece copy = this.piece;
			this.piece = null;
			return copy;
		}

		/**
		 * markerar att pjäsen kan gå till denna rutan
		 */
		public void mark() {
			this.marked = true;
		}

		/**
		 * avmarkerar att pjäsen kan gå till denna rutan
		 */
		public void unmark() {
			this.marked = false;
		}

		/**
		 * bestämmer hur rutan ser ut i utskriften
		 */
		public String toString() {
			String s = (marked) ? "xx" : "--";
			return (piece == null) ? s : piece.toString();			
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;

	/**
	 * Skapar schackbrädet
	 */
	public Chessboard() {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	/**
	 * Skriver ut tjackbrädet
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("  1  2  3  4  5  6  7  8\n");
		int i = 0;
		for(Field[] row : fields) {
			s.append((char) (FIRST_ROW + i++) + " ");
			for(Field field : row)
				s.append(field.toString() + " ");
			s.append("\n");
		}
		
		/*for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			s.append((char) (FIRST_ROW + r) + " ");
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				s.append(fields[r][c].toString() + " ");
			}
			s.append("\n");
		}*/
		
		return s.toString();
	}

	/**
	 * Kollar om fältet är inom schackbrädets gränser
	 * @param row
	 * @param column
	 * @return true eller false
	 */
	public boolean isValidField(char row, byte column) {
		return row >= FIRST_ROW && row < (FIRST_ROW + NUMBER_OF_ROWS) &&
				column >= FIRST_COLUMN && column < (FIRST_COLUMN + NUMBER_OF_COLUMNS);
	}

	/**
	 * Superklassen för en schackpjäs
	 * @author wille
	 *
	 */
	public abstract class Chesspiece {
		private char color;
		// w - white, b - black
		private char name;
		// K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
		// P – Pawn
		protected char row = 0;
		protected byte column = -1;

		/**
		 * superkonstruktor för en schackpjäs
		 * @param color
		 * @param name
		 */
		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
		}

		/**
		 * utskriften för en schackpjäs
		 */
		public String toString() {
			return "" + color + name;
		}

		/**
		 * kollar om pjäsen är på brädet
		 * @return true eller false
		 */
		public boolean isOnBoard() {
			return Chessboard.this.isValidField(row, column);
		}

		/**
		 * Flyttar schackpjäsen till en ny plats
		 * @param row den rad man vill flytta till
		 * @param column den kolumn man vill flytta till
		 * @throws NotValidFieldException om den är utanför brädet
		 */
		public void moveTo(char row, byte column) throws NotValidFieldException {
			if (!Chessboard.this.isValidField(row, column))
				throw new NotValidFieldException("bad field: " + row + column);
			this.row = row;
			this.column = column;
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put(this);
		}

		public void moveOut() {
		}

		/**
		 * markerar de fält som pjäsen kan nå
		 */
		public abstract void markReachableFields();

		/**
		 * omarkerar fälten som pjäsen kan nå
		 */
		public abstract void unmarkReachableFields();
	}

	/**
	 * bonde
	 */
	public class Pawn extends Chesspiece {
		public Pawn(char color, char name) {
			super(color, name);
		}

		@Override
		/**
		 * Markerar en ruta framåt asså
		 */
		public void markReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
		}

		@Override
		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Rook extends Chesspiece {

		protected Rook(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				fields[r][column -1].mark();
			}
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[row - FIRST_ROW][c].mark();
			}
		}

		@Override
		public void unmarkReachableFields() {
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				fields[r][column -1].unmark();
			}
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[row - FIRST_ROW][c].unmark();
			}
		}
	}

	public class Knight extends Chesspiece {

		protected Knight(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			
		}

		@Override
		public void unmarkReachableFields() {
			
		}
	}

	public class Bishop extends Chesspiece {

		protected Bishop(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			int rad = (int) (row - FIRST_ROW);
			int kortast = ((int) (row - FIRST_ROW) > (int) column) ? (int) (row - FIRST_ROW) : (int) column;
			for(int i = -kortast; ; i--) {
				if (Chessboard.this.isValidField((char) (row - FIRST_ROW + i), (byte) (column - FIRST_COLUMN + i))) {
				}
				fields[(row - FIRST_ROW) - kortast][column -1 -kortast].mark();
			}
		}

		@Override
		public void unmarkReachableFields() {
			
		}
	}

	public class Queen extends Chesspiece {

		protected Queen(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			// lodrätt vågrätt 
			for(int r = 0; r < NUMBER_OF_ROWS; r++) {
				fields[r][column -1].mark();
			}
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[row - FIRST_ROW][c].mark();
			}
			
			// diagonalt
		}

		@Override
		public void unmarkReachableFields() {
			// lodrätt vågrätt
			for (int r = 0; r < NUMBER_OF_ROWS; r++) {
				fields[r][column - 1].unmark();
			}
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[row - FIRST_ROW][c].unmark();
			}

			// diagonalt
		}
	}

	public class King extends Chesspiece {

		protected King(char color, char name) {
			super(color, name);
		}

		@Override
		public void markReachableFields() {
			for(int i = -1; i <= 1; i++)
				for(int j = -1; j <= 1; j++) {
					char rowen = (char) (row + i);
					byte col = (byte) (column + j);
					if (Chessboard.this.isValidField(rowen, col)) {
						int r = rowen - FIRST_ROW;
						int c = col - FIRST_COLUMN;
						Chessboard.this.fields[r][c].mark();
					}
				}
		}

		@Override
		public void unmarkReachableFields() {
			for(int i = -1; i <= 1; i++)
				for(int j = -1; j <= 1; j++) {
					char rowen = (char) (row + i);
					byte col = (byte) (column + j);
					if (Chessboard.this.isValidField(rowen, col)) {
						int r = rowen - FIRST_ROW;
						int c = col - FIRST_COLUMN;
						Chessboard.this.fields[r][c].unmark();
					}			
				}
		}
	}
}

