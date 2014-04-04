package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
	    myStatsPanel.setLayout(new FlowLayout());
	    myContainer.add(myStatsPanel);
	    
	    JLabel defSquareLabel = new JLabel("Deficient Square: Not Set");
	    JLabel numbItersLabel = new JLabel("Number Iterations: 0");
	    myStatsPanel.add(defSquareLabel);
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
	   for (int i = 0; i < board.length; i ++)
	   {
		   for( int j = 0; j < board[i].length; j++)
		   {
	           myBoardButtons[i][j].setOpaque(true);
			   if( board[i][j] == -1)
			   {
				  myBoardButtons[i][j].setBackground(Color.black);
			   }
			   else if(board[i][j] % 3 == 0)
			   {
			      myBoardButtons[i][j].setBackground(Color.red);
			   }
			   else if(board[i][j] % 4 == 0)
			   {
			      myBoardButtons[i][j].setBackground(Color.orange);
			   }
			   else if(board[i][j] % 5 == 0)
			   {
				   myBoardButtons[i][j].setBackground(Color.MAGENTA);
			   }
			   else if(board[i][j] % 7 == 0)
			   {
				   myBoardButtons[i][j].setBackground(Color.BLUE);
			   }
			   else
			   {
				   myBoardButtons[i][j].setBackground(Color.cyan);
			   }
		   }
	   }
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
}
