package com.aurionpro.model;

public class ResultAnalyzer {

	private Board board;
	private ResultType result;

	// public ResultAnalyzer(Board board, ResultType result) {
	// super();
	// this.board = board;
	// this.result = result;
	// }

	public Board getBoard() {
		return board;
	}

	public ResultType getResult() {
		return result;
	}

	public ResultAnalyzer(Board board) {
		this.board = board;
		this.result = ResultType.PROGRESS;
	}

	public void horizontalWinCheck() {
		for (int row = 0; row < 3; row++) {
			if ((board.getCells()[row * 3].getMark() == MarkType.X
					&& board.getCells()[row * 3 + 1].getMark() == MarkType.X
					&& board.getCells()[row * 3 + 2].getMark() == MarkType.X)) {
				result = ResultType.WIN;
			}
			if ((board.getCells()[row * 3].getMark() == MarkType.O
					&& board.getCells()[row * 3 + 1].getMark() == MarkType.O
					&& board.getCells()[row * 3 + 2].getMark() == MarkType.O)) {
				result = ResultType.WIN;
			}
		}
	}

	// public boolean horizontalWinCheck(MarkType mark) {
	// for (int row = 0; row < 3; row++) {
	// if (board.getCells()[row * 3].getMark() == mark && board.getCells()[row * 3 +
	// 1].getMark() == mark
	// && board.getCells()[row * 3 + 2].getMark() == mark) {
	// return true;
	// }
	// }
	// return false;
	// }

	// public boolean verticalWinCheck(MarkType mark) {
	// for (int col = 0; col < 3; col++) {
	// if (board.getCells()[col].getMark() == mark && board.getCells()[col +
	// 3].getMark() == mark
	// && board.getCells()[col + 6].getMark() == mark) {
	// return true;
	// }
	// }
	// return false;
	// }

	public void verticalWinCheck() {
		for (int col = 0; col < 3; col++) {
			if ((board.getCells()[col].getMark() == MarkType.X && board.getCells()[col + 3].getMark() == MarkType.X
					&& board.getCells()[col + 6].getMark() == MarkType.X)) {
				result = ResultType.WIN;
			}
			if ((board.getCells()[col].getMark() == MarkType.O && board.getCells()[col + 3].getMark() == MarkType.O
					&& board.getCells()[col + 6].getMark() == MarkType.O)) {
				result = ResultType.WIN;
			}
		}
	}

	// public boolean diagonalWinCheck(MarkType mark) {
	// if ((board.getCells()[0].getMark() == mark && board.getCells()[4].getMark()
	// == mark
	// && board.getCells()[8].getMark() == mark)
	// || (board.getCells()[2].getMark() == mark && board.getCells()[4].getMark() ==
	// mark
	// && board.getCells()[6].getMark() == mark)) {
	// return true;
	// }
	// return false;
	// }

	public void diagonalWinCheck() {
		if ((board.getCells()[0].getMark() == MarkType.X && board.getCells()[4].getMark() == MarkType.X
				&& board.getCells()[8].getMark() == MarkType.X)
				|| (board.getCells()[0].getMark() == MarkType.O && board.getCells()[4].getMark() == MarkType.O
						&& board.getCells()[8].getMark() == MarkType.O)) {
			result = ResultType.WIN;
		}

		if ((board.getCells()[2].getMark() == MarkType.X && board.getCells()[4].getMark() == MarkType.X
				&& board.getCells()[6].getMark() == MarkType.X)
				|| (board.getCells()[2].getMark() == MarkType.O && board.getCells()[4].getMark() == MarkType.O
						&& board.getCells()[6].getMark() == MarkType.O)) {
			result = ResultType.WIN;
		}
	}

	public void analyzeResult() {
		horizontalWinCheck();
		verticalWinCheck();
		diagonalWinCheck();

		if (result == ResultType.PROGRESS && board.isBoardFull()) {
			result = ResultType.DRAW;
		}
	}
	
	 public void reset() {
	        result = ResultType.PROGRESS; 
	    }

}
