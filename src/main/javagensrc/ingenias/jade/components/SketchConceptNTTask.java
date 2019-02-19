

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
* <p>The Task  SketchConceptNT has the following inputs, sets of possible outputs, and available applications:</p>
* Inputs:<ul>
*  <li>GoalDefinition</li>
*  <li>fake_DefineGoalNT_output_for_task_SketchConceptNT</li>



*</ul>
* Expected output: <ul>

*<li> 	Set  "default":<ul>
*<li>      Created  entities in the main mental state:<ul>
</li>
*</ul></li>
*<li>	   Created entities only in the workflow:<ul>
*<li>           fake_SketchConceptNT_output_for_task_ShareConceptNT </li>
*</ul></li>
*<li>      Created interactions: <ul>
</li>
*</ul></li></ul></li>

*</ul>
* Available apps:<ul>
*<li>          SketchPainterApp</li>

*</ul>
*/
public class SketchConceptNTTask extends Task{

 public SketchConceptNTTask(String id){
  super(id,"SketchConceptNT");
  
 }


 public void execute() throws TaskException{
    YellowPages yp=null; // only available for initiators of interactions

        GoalDefinition  eiGoalDefinition=(GoalDefinition)this.getFirstInputOfType("GoalDefinition");             

        fake_DefineGoalNT_output_for_task_SketchConceptNT  eifake_DefineGoalNT_output_for_task_SketchConceptNT=(fake_DefineGoalNT_output_for_task_SketchConceptNT)this.getFirstInputOfType("fake_DefineGoalNT_output_for_task_SketchConceptNT");             





			
        SketchPainterApp eaSketchPainter=(SketchPainterApp)this.getApplication("SketchPainter");





  		Vector<TaskOutput> outputs = this.getOutputs();
  		  
  		// sets the first possible alternative to be the default one
  		if (!this.getOutputs().isEmpty())  
  		 this.setFinalOutput(outputs.firstElement()); 
  		  		
  		  	
  		
  		// beginning of alternative "default".
  		// -------------------------------------------------------- 
  		TaskOutput	outputsdefault=findOutputAlternative("default",
  																			outputs);
  																			
  		// Uncomment the following to make the task to produce only
  		// the outcome associated to this alternative:
  		// this.setFinalOutput(outputsdefault); 
  		// if nothing is set, the first defined alternative will be chosen 
  		
  	
  		
		
		
		fake_SketchConceptNT_output_for_task_ShareConceptNT outputsdefaultfake_SketchConceptNT_output_for_task_ShareConceptNT=
			(fake_SketchConceptNT_output_for_task_ShareConceptNT)
				outputsdefault.getEntityByType("fake_SketchConceptNT_output_for_task_ShareConceptNT");								
		
		
	    
		
		// --------------------------------------------------------
		// End of automatically generated code
  		// -------------------------------------------------------- 
    	//Expected output summary:
		
		// =================================================
		// Alternative "default":
		//     Created  entities in the main mental state:

		//	   Created entities only in the workflow:
//           -outputsdefaultfake_SketchConceptNT_output_for_task_ShareConceptNT 
		//     Created interactions: 

        // =================================================


		// Available apps:
//           SketchPainterApp</li>


		// Summary of alternatives available to this task
  		// --------------------------------------------------------
  	  		
  		// To set the output to alternative "default" copy the following to the code area
  		// this.setFinalOutput(outputsdefault);
  		  	  		

// Code Area
//#start_node:INGENIASCodeComponent2 <--- DO NOT REMOVE THIS	
//REPLACE THIS COMMENT WITH YOUR CODE
System.out.println(getAgentID()+" executing -> "+getID()+":"+getType());
eaSketchPainter.launchEditor();
//#end_node:INGENIASCodeComponent2 <--- DO NOT REMOVE THIS

 }
 
}

 