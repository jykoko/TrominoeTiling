package controller;

import javax.swing.JOptionPane;
import model.Board;
import model.TrominoeModel;
import view.TrominoeView;

public class TrominoeController 
{
   private TrominoeModel myModel;
   private TrominoeView myView;
   
   public TrominoeController()
   {
	   String input = JOptionPane.showInputDialog(null, "How many squares would you like in the grid? (N x N)");
       int boardSize = Integer.parseInt(input);
       
       Board board = new Board(boardSize);
       myModel = new TrominoeModel(board);
 	   myView = new TrominoeView(this);
 	   System.out.println("GUI started, program is running.");
   }
   
   public void tileBoard()
   {
	   myModel.tileBoard();
 	   myModel.getBoard().printBoard();
 	   displayBoardToInterface();
   }
   
   public void displayBoardToInterface()
   {
	   myView.displayBoard(myModel.getBoard().getBoard());
   }
   
   public void resetBoardSize()
   {
	   myView.killCurrentWindow();
	   new TrominoeController();
   }
   
   public int getBoardSize()
   {
	   return myModel.getBoard().getOriginalBoardSize();
   }
}