package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell;

	@BeforeEach
	void onInit() {
		cell = new Cell();
	}

	@Test
	void testCell() {
	}

	@Test
	void testIsEmpty() {
		boolean is = cell.isEmpty();
		assertTrue(is);
	}

	@Test
	void testGetMark() {
	}

	@Test
	void testSetMark() throws CellAlreadyMarkedException {
		cell.setMark(MarkType.X);
		assertEquals(MarkType.X, cell.getMark());
	}

	@Test
	void testSetMark_CellAlreadyMarkedException() throws CellAlreadyMarkedException {
		cell.setMark(MarkType.X);
		assertThrows(CellAlreadyMarkedException.class, () -> cell.setMark(MarkType.O));
	}
}
