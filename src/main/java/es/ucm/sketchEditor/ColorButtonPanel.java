package es.ucm.sketchEditor;


/*=====================*\
|*   Bpaint            *|
|*---------------------*|
|* Author -            *|
|Barun Chakrabarty     *|
|NIT Calicut           *|
\*=====================*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ColorButtonPanel extends JPanel
{
	private JPanel colorButtonPanel;
	private JButton foreGroundColorBtn,backGroundColorBtn;
	private JLabel foreGroundColorLbl,backGroundColorLbl,foreColorLbl,backColorLbl;
	private Color foreColor, backColor;
	private CanvasPanel canvasPanel;
	
	public ColorButtonPanel(CanvasPanel inCanvasPanel)
	{
		canvasPanel = inCanvasPanel;	
		foreGroundColorLbl = new JLabel("   ");
		foreGroundColorLbl.setOpaque(true);
		foreGroundColorLbl.setBackground(canvasPanel.getForeGroundColor());
		foreGroundColorLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		backGroundColorLbl = new JLabel("   ");
		backGroundColorLbl.setOpaque(true);
		backGroundColorLbl.setBackground(canvasPanel.getBackGroundColor());
		backGroundColorLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		foreGroundColorBtn = new JButton("",new ImageIcon(getClass().getResource("/fgBtn.gif")));
		foreGroundColorBtn.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					setForeGroundColor();
				}
			}
		);
		
		backGroundColorBtn = new JButton("",new ImageIcon(getClass().getResource("/bgBtn.gif")));
		backGroundColorBtn.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					setBackGroundColor();
				}
			}
		);
	
		this.setLayout(new GridLayout(4,1));
		this.add(foreGroundColorBtn);
		this.add(foreGroundColorLbl);
		this.add(backGroundColorBtn);
		this.add(backGroundColorLbl);
		foreGroundColorBtn.setToolTipText("ForeGround Colour");
		backGroundColorBtn.setToolTipText("BackGround Colour");
	}
/*----------------------------------------------------------------------------*/	
	public void setForeGroundColor()
	{
		foreColor = JColorChooser.showDialog(null,"ForeGround Color",foreColor);
		if(foreColor!=null)
		{
			foreGroundColorLbl.setBackground(foreColor);
			canvasPanel.setForeGroundColor(foreColor);
		}
	}
/*----------------------------------------------------------------------------*/
	public void setBackGroundColor()
	{
		backColor = JColorChooser.showDialog(null,"BackGround Color",backColor);
		if(backColor!=null)
		{
			backGroundColorLbl.setBackground(backColor);
			canvasPanel.setBackGroundColor(backColor);
		}
	}
}