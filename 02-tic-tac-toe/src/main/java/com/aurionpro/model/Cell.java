package com.aurionpro.model;

public class Cell {
	private MarkType mark;

	public Cell() {
		super();
		this.mark = MarkType.EMPTY;
	}
	public boolean isEmpty() {
        return mark == MarkType.EMPTY;
    }

    public MarkType getMark() {
        return mark;
    }
    
    public boolean isMarked() {
        return mark != MarkType.EMPTY;
    }


    public void setMark(MarkType mark) throws CellAlreadyMarkedException {
        if (isEmpty()) {
            this.mark = mark;
        } else {
            throw new CellAlreadyMarkedException("Cell is already marked.");
        }
	
    }
    
    public void clearMark() {
        this.mark = MarkType.EMPTY;
    }

}
