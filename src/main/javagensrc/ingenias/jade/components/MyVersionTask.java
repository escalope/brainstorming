

/*
    Copyright (C) 2005 Jorge Gomez Sanz

    This file is part of INGENIAS Agent Framework, an agent infrastructure linked
    to the INGENIAS Development Kit, and availabe at http://grasia.fdi.ucm.es/ingenias or
    http://ingenias.sourceforge.net. 

    INGENIAS Agent Framework is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    INGENIAS Agent Framework is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with INGENIAS Agent Framework; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*/


package ingenias.jade.components;

import java.util.*;
import ingenias.jade.exception.*;
import ingenias.jade.comm.*;
import ingenias.jade.mental.*;
import ingenias.editor.entities.*;

/**
* 
* <p>The Task  MyVersion has the following inputs, sets of possible outputs, and available applications:</p>
* Inputs:<ul>
*  <li>FrameFact0</li>



*</ul>
* Expected output: <ul>

*</ul>
* Available apps:<ul>

*</ul>
*/
public class MyVersionTask extends Task{

 public MyVersionTask(String id){
  super(id,"MyVersion");
  
 }


 public void execute() throws TaskException{
    YellowPages yp=null; // only available for initiators of interactions

        FrameFact0  eiFrameFact0=(FrameFact0)this.getFirstInputOfType("FrameFact0");             










  		Vector<TaskOutput> outputs = this.getOutputs();
  		  
  		// sets the first possible alternative to be the default one
  		if (!this.getOutputs().isEmpty())  
  		 this.setFinalOutput(outputs.firstElement()); 
  		  		
  		
		// --------------------------------------------------------
		// End of automatically generated code
  		// -------------------------------------------------------- 
    	//Expected output summary:
		

		// Available apps:


		// Summary of alternatives available to this task
  		// --------------------------------------------------------

// Code Area
//#start_node:INGENIASCodeComponent0 <--- DO NOT REMOVE THIS	
//REPLACE THIS COMMENT WITH YOUR CODE
System.out.println(getAgentID()+" executing -> "+getID()+":"+getType());
//#end_node:INGENIASCodeComponent0 <--- DO NOT REMOVE THIS

 }
 
}

 