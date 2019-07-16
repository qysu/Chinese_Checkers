
import java.util.ArrayList;


public class Move
{

	private int row;
	private int column;
	private Move previousMove;
	
	
	public Move(int row, int column, Move previousMove)
	{

		this.row = row;
		this.column = column;
		this.previousMove = previousMove;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	public boolean isPossibleMove()
	{
		if (this.previousMove != null)
			return true;
		else
			return false;
	}
	
	public ArrayList<Move> getMoveList()
	{
		if (this.previousMove == null)
		{
			ArrayList<Move> moveList = new ArrayList<Move>();
			moveList.add(this);
			return moveList;
		}
		
		ArrayList<Move> moveList = previousMove.getMoveList();
		moveList.add(this);
		return moveList;
	}
	
	public int advancementToEnd()
	{
		if (previousMove == null)
			return 0;
		int distance = -(row - previousMove.row) + previousMove.advancementToEnd();
		return distance;
	}
	
	public String toString (){
		String previous = "NULL";
		if (previousMove != null){
			previous = previousMove.toString();
		}
		return previous + " TO " + "(" + row + "," + column + ")";
	}
}
