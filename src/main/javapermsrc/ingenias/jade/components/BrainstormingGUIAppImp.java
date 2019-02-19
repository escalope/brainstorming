

/**
 *
 *
 *  Description of the task /
 *
 * 
 *@author     Jorge J. Gomez
 *@version    1.0
 */

package ingenias.jade.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import ingenias.jade.exception.*;
import ingenias.jade.mental.*;
import ingenias.exception.InvalidEntity;
import ingenias.jade.components.*;
import ingenias.jade.smachines.*;


public  class BrainstormingGUIAppImp extends BrainstormingGUIApp{

private JFrame jf=new JFrame();

public BrainstormingGUIAppImp(){
  super();
  
  JButton button=new JButton("Initiate");
  button.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			getOwner().getMSM().addMentalEntity(new InitiateBrainstorming("IB"+getOwner().getMSM().generateMentalEntityID()));
		} catch (InvalidEntity e1) {
			e1.printStackTrace();
		}
		
	}
});
  jf.getContentPane().add(button);
  jf.pack();
  jf.setVisible(true);
  
 }
 
 


}

 