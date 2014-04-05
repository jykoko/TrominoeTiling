package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import controller.TrominoeController;

public class TrominoeView extends JFrame 
{
   private JFrame myMainView;
   private Container myContainer;
   private TrominoeController myController;
   private JPanel myBoardPanel, myStatsPanel;
   private JLabel myNumbItersLbl, myDefSquareLocationLbl;
   private JButton[][] myBoardButtons;
   private static final long serialVersionUID = 1L;

   public TrominoeView( TrominoeController controller )
   {
	  myController = controller;
	  displayInterface();
   }
   
   public void displayInterface()
   {
	   myMainView = new JFrame();
	   myMainView.setSize(800, 600);
	   myMainView.setTitle("Tiling With Trominoes");
	   myMainView.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   myMainView.setVisible(true);
	   myMainView.setResizable(false);
	   
	   myContainer = myMainView.getContentPane();
	   myContainer.setLayout(null);
	   
	   myBoardPanel = new JPanel();
	   myBoardPanel.setSize(250,250);
	   myBoardPanel.setVisible(true);
	   myBoardPanel.setBounds( 150,130,500,300 );
	   myBoardPanel.setBackground(Color.WHITE);
	   myBoardPanel.setLayout(new GridLayout(myController.getBoardSize(),
			                                 myController.getBoardSize(),0,0));
	   myContainer.add(myBoardPanel);
	   myBoardButtons = new JButton[myController.getBoardSize()]
			   					   [myController.getBoardSize()];
	  
	   LineBorder lnBorder = new LineBorder(Color.black, 1);
	   for(int i = 0; i < myBoardButtons.length; i++)
	   {
		   for(int j = 0 ; j < myBoardButtons[i].length; j++)
		   {
			   myBoardButtons[i][j] = new JButton();
			   myBoardButtons[i][j].setEnabled(false);
			   myBoardButtons[i][j].setMargin(new Insets(0,0,0,0));
			   myBoardButtons[i][j].setContentAreaFilled(false);
			   myBoardButtons[i][j].setFocusPainted(false);
			   myBoardButtons[i][j].setBorder( lnBorder );
			   myBoardPanel.add(myBoardButtons[i][j]);
			 }
		}
	  
	    myStatsPanel = new JPanel();
	    myStatsPanel.setSize(250,250);
	    myStatsPanel.setVisible(true);
	    myStatsPanel.setBounds( 600,20,180,100 );
	    myStatsPanel.setBackground(Color.WHITE);
	    myStatsPanel.setLayout(null);
	    myContainer.add(myStatsPanel);
	    
	    JLabel defSquareLabel = new JLabel("Def Square: ");
	    defSquareLabel.setBounds(10, 20, 80, 20);
	    myDefSquareLocationLbl = new JLabel("( x , y )");
	    myDefSquareLocationLbl.setBounds(90, 20, 80, 20);
	    myStatsPanel.add(myDefSquareLocationLbl);
	    myStatsPanel.add(defSquareLabel);
	    
	    JLabel numbItersLabel = new JLabel("Iterations: ");
	    numbItersLabel.setBounds(10, 60, 80, 20);
	    myNumbItersLbl = new JLabel("0");
	    myNumbItersLbl.setBounds(90, 60, 80, 20);
	    myStatsPanel.add(myNumbItersLbl);
	    myStatsPanel.add(numbItersLabel);
	    
		TitledBorder title = BorderFactory.createTitledBorder("Stats");
        title.setTitleJustification(TitledBorder.CENTER);
        myStatsPanel.setBorder(title);
        
        JButton runButton = new JButton("Tile Board");
        runButton.setBounds(250, 460, 160, 30);
        myContainer.add(runButton);
        runButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                myController.tileBoard();
                updateView();
            }
        });      
        
        JButton refreshButton = new JButton("Set New Size");
        refreshButton.setBounds(420, 460, 160, 30);
        myContainer.add(refreshButton);
        refreshButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                myController.resetBoardSize();
            }
        });  
        
		updateView();
   }
   
   public void displayBoard(int[][] board)
   {
	   myBoardPanel.setBackground(Color.BLACK);
	   for (int i = 0; i < board.length; i ++)
	   {
		   for( int j = 0; j < board[i].length; j++)
		   {
	           myBoardButtons[i][j].setOpaque(true);
			   myBoardButtons[i][j].setBackground(setNewColor( board[i][j] )); 
		   }
	   }
   }
   
   public void setIterationsLabel( String label )
   {
	   myNumbItersLbl.setText(label);
	   updateView();
   }
   
   public void setDefSquareLabel( String label )
   {
	   myDefSquareLocationLbl.setText(label);
	   updateView();
   }

   public void updateView()
   {
	   myMainView.validate();
	   myMainView.repaint();
   }
   
   public void killCurrentWindow() 
   {
	  myMainView.dispose();
   }
   
   public Color setNewColor( int n )
   {
	   if( n == -1)
	   {
		 return Color.black;
	   }
	   else if(n % 3 == 0)
	   {
		   return Color.pink;
	   }
	   else if(n % 4 == 0)
	   {
		   return Color.red;
	   }
	   else if(n % 5 == 0)
	   {
		   return Color.blue;
	   }
	   else if(n % 7 == 0)
	   {
		   return Color.magenta;
	   }
	   else
	   {
		   return Color.orange;
	   }
   }
}