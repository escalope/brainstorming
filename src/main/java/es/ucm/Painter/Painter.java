package es.ucm.Painter;


/*=====================*\
|*   Bpaint            *|
|*---------------------*|
|* Author -            *|
|Barun Chakrabarty     *|
|NIT Calicut           *|
\*=====================*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Painter extends JFrame 
{
	private CanvasPanel 		canvasPanel;
	private ToolButtonPanel   	toolButtonPanel;
	private ColorButtonPanel	colorButtonPanel;
	public JLabel                  statusBar;
	
	private Container 			mainContainer;
	private String fileName;
	private String ipkey;
	
	JMenuBar mainBar;
	JMenu fileMenu, editMenu, setColorMenuItem, aboutMenu;
	JMenuItem newMenuItem, openMenuItem, closeMenuItem, saveMenuItem, 
saveAsMenuItem, exitMenuItem, undoMenuItem, redoMenuItem, 
foreGroundMenuItem, backGroundMenuItem, authorMenuItem;
	
	public Painter()
	{
		super("Bpaint - A basic paint program");
		fileName = null;
		
		
		mainBar 		= new JMenuBar();
		setJMenuBar(mainBar);
/*----------------------------------------------------------------------------*/		
		fileMenu  		= new JMenu("File");
		fileMenu.setMnemonic('F');
		
		newMenuItem		= new JMenuItem("New");
		openMenuItem 	= new JMenuItem("Open");
		closeMenuItem 	= new JMenuItem("Close"); 
		saveMenuItem 	= new JMenuItem("Save");
		saveAsMenuItem 	= new JMenuItem("Save As");
		exitMenuItem	= new JMenuItem("Exit");
		 
		
		newMenuItem.addActionListener(new MenuButtonListener());
		openMenuItem.addActionListener(new MenuButtonListener());
		saveMenuItem.addActionListener(new MenuButtonListener());
		saveAsMenuItem.addActionListener(new MenuButtonListener());
		closeMenuItem.addActionListener(new MenuButtonListener());
		exitMenuItem.addActionListener(new MenuButtonListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
/*----------------------------------------------------------------------------*/			
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');
		
		undoMenuItem	   = new JMenuItem("Undo");
		redoMenuItem 	   = new JMenuItem("Redo");
		
		setColorMenuItem   = new JMenu("Set Color");
		foreGroundMenuItem = new JMenuItem("Set ForeGround");
		backGroundMenuItem = new JMenuItem("Set BackGround");
		
		undoMenuItem.addActionListener(new MenuButtonListener());
		redoMenuItem.addActionListener(new MenuButtonListener());
		foreGroundMenuItem.addActionListener(new MenuButtonListener());
		backGroundMenuItem.addActionListener(new MenuButtonListener());
		
		setColorMenuItem.add(foreGroundMenuItem);
		setColorMenuItem.add(backGroundMenuItem);
		
		editMenu.add(undoMenuItem);
		editMenu.add(redoMenuItem);
		editMenu.addSeparator();
		editMenu.add(setColorMenuItem);
/*----------------------------------------------------------------------------*/			
		aboutMenu	= new JMenu("About");
		aboutMenu.setMnemonic('A');
		
		authorMenuItem = new JMenuItem("Author");
		authorMenuItem.addActionListener(new MenuButtonListener());
		
		aboutMenu.add(authorMenuItem);
/*----------------------------------------------------------------------------*/				
		mainBar.add(fileMenu);
		mainBar.add(editMenu);
		mainBar.add(aboutMenu);
/*----------------------------------------------------------------------------*/



		canvasPanel 	  = new CanvasPanel();
		toolButtonPanel   = new ToolButtonPanel(canvasPanel);
		colorButtonPanel  = new ColorButtonPanel(canvasPanel);
		statusBar       = new JLabel(" Hello!!");
		
		mainContainer = getContentPane();
		mainContainer.add(toolButtonPanel,BorderLayout.NORTH);
		mainContainer.add(canvasPanel,BorderLayout.CENTER);
		mainContainer.add(colorButtonPanel,BorderLayout.WEST);
		mainContainer.add(statusBar,BorderLayout.SOUTH);
		
		setSize(700,500);
		this.setResizable(true);
		setVisible(true);
		
/*----------------------------------------------------------------------------*/
		MouseHandler handler = new MouseHandler();
 		this.addMouseListener(handler);
/*----------------------------------------------------------------------------*/
		addWindowListener (
      		new WindowAdapter () 
      		{
      			public void windowClosing (WindowEvent e) 
      			{
      				System.exit(0);
      			}
      			public void windowDeiconified (WindowEvent e) 
      			{
      				canvasPanel.repaint();
      			}
      			public void windowActivated (WindowEvent e) 
      			{	 
      				canvasPanel.repaint();
      			}
      		}
      	);
	}
/*----------------------------------------------------------------------------*/
	private class MouseHandler implements MouseListener
	{
		
		public void mousePressed (MouseEvent event)
		{
			statusBar.setText("ho jaayega");
		}
		
		public void mouseClicked (MouseEvent event)
		{
			statusBar.setText("ho jaayega");
		}
		public void mouseReleased (MouseEvent event)
		{
			
		}public void mouseEntered (MouseEvent event)
		{
			
		}public void mouseExited (MouseEvent event)
		{
			
		}
	}


/*----------------------------------------------------------------------------*/
	public class MenuButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == newMenuItem || event.getSource() == 
closeMenuItem)
			{
				canvasPanel.clearCanvas();
				canvasPanel.setDrawMode(0);
				canvasPanel.setForeGroundColor(Color.WHITE);
				canvasPanel.setBackGroundColor(Color.BLACK);
				canvasPanel.repaint();
			}
			if(event.getSource() == exitMenuItem)
			{
				System.exit(0);
			}
			if(event.getSource() == foreGroundMenuItem)
			{
				colorButtonPanel.setForeGroundColor();
				canvasPanel.repaint();
			}
			if(event.getSource() == backGroundMenuItem)
			{
				colorButtonPanel.setBackGroundColor();
				canvasPanel.repaint();
			}
			if(event.getSource() == authorMenuItem)
			{
				JOptionPane.showMessageDialog(Painter.this,"Author : Barun Chakrabarty\n    NIT Calicut","Bpaint",JOptionPane.INFORMATION_MESSAGE);
				canvasPanel.repaint();
			}
			if(event.getSource() == saveMenuItem)
			{
				canvasPanel.SaveCanvasToFile();
			}
			if(event.getSource() == saveAsMenuItem)
			{
				canvasPanel.SaveAsCanvasToFile();
			}
			if(event.getSource() == openMenuItem)
			{
				canvasPanel.OpenCanvasFile();
			}
			if(event.getSource() == undoMenuItem)
			{
				canvasPanel.undo();
			}
			if(event.getSource() == redoMenuItem)
			{
				canvasPanel.redo();
			}
		}
	}
/*----------------------------------------------------------------------------*/
       
/*----------------------------------------------------------------------------*/
	public static void main(String args[])
	{
		Painter application = new Painter();
		application.show();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

