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
   }
   
   public void resetBoardSize()
   {
	   myView.killCurrentWindow();
	   new TrominoeController();
   }
}
