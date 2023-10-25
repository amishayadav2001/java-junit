package com.aurionpro.model;

import java.util.Scanner;

public class Game {
	private Player currentPlayer;
	private Player[] players;
	private ResultAnalyzer analyser;
	private Board board;

	public Game(Player[] players, ResultAnalyzer analyser, Board board) {
		this.players = players;
		this.currentPlayer = players[0];
		this.analyser = analyser;
		this.board = board;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void printBoard() {
		System.out.println("Board");
		Cell[] cells = board.getCells();
		for (int i = 0; i < cells.length; i++) {
			if (i % 3 == 0) {
				if (i != 0) {
					System.out.println();
					System.out.println("---------");
				}
			}
			if (cells[i].isMarked()) {
				System.out.print(" " + cells[i].getMark() + " ");
			} else {
				System.out.print("   ");
			}
			if (i % 3 < 2) {
				System.out.print("|");
			}
		}
		System.out.println();
	}

	public void play() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(currentPlayer.getPlayerName() + ", enter your move (0-8): ");
			int loc = sc.nextInt();

			try {
				if (loc >= 0 && loc <= 8) {
					if (!board.getCells()[loc].isMarked()) {
						board.setCellMarked(loc, currentPlayer.getPlayerMark());
						analyser.analyzeResult();
						printBoard();

						if (analyser.getResult() == ResultType.WIN) {
							System.out.println(currentPlayer.getPlayerName() + " has won!");
							break;
						} else if (analyser.getResult() == ResultType.DRAW) {
							System.out.println("The game is a draw.");
							break;
						} else {
							switchPlayer();
						}
					} else {
						System.out.println("Invalid move! Cell already marked.");
					}
				} else {
					System.out.println("Invalid move! Enter a number between 0 and 8.");
				}
			} catch (CellAlreadyMarkedException e) {
				System.out.println("Invalid move! Cell already marked.");
			}

		}
	}

	public void switchPlayer() {
		if (currentPlayer == players[0]) {
			currentPlayer = players[1];

		} else {
			currentPlayer = players[0];
		}
		// currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
	}

	public void reset() {
		board.reset();
		currentPlayer = players[0];
		analyser.reset();
	}

	
}
