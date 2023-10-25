package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

	private Player[] players;
	private ResultAnalyzer analyser;
	private Board board;

	@BeforeEach
	public void setUp() {
		players = new Player[] { new Player("Player1", MarkType.X), new Player("Player2", MarkType.O) };
		analyser = new ResultAnalyzer(board);
		board = new Board();
	}

	@Test
	public void testGetCurrentPlayer() {
		Game game = new Game(players, analyser, board);
		Player currentPlayer = game.getCurrentPlayer();
		assertEquals(players[0], currentPlayer);
	}

	@Test
	public void testSwitchPlayer() {
		Game game = new Game(players, analyser, board);
		Player currentPlayer = game.getCurrentPlayer();
		game.switchPlayer();
		Player nextPlayer = game.getCurrentPlayer();
		assertNotEquals(currentPlayer, nextPlayer);
	}

	@Test
	public void testPlayWithWin() throws CellAlreadyMarkedException {
		Game game = new Game(players, analyser, board);
		board.setCellMarked(0, MarkType.X);
		board.setCellMarked(1, MarkType.X);
		board.setCellMarked(2, MarkType.X);
//		game.play();
		assertEquals(ResultType.WIN, analyser.getResult());
	}

	@Test
	public void testPlayWithDraw() throws CellAlreadyMarkedException {
//		Game game = new Game(players, analyser, board);
		board.setCellMarked(0, MarkType.X);
		board.setCellMarked(1, MarkType.O);
		board.setCellMarked(2, MarkType.X);
		board.setCellMarked(3, MarkType.X);
		board.setCellMarked(4, MarkType.O);
		board.setCellMarked(5, MarkType.X);
		board.setCellMarked(6, MarkType.O);
		board.setCellMarked(7, MarkType.X);
		board.setCellMarked(8, MarkType.O);
//		game.play();
		analyser.analyzeResult();
		assertEquals(ResultType.DRAW, analyser.getResult());
	}

}

