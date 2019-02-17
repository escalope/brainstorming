

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
* <p>The Task  ShareConceptNT has the following inputs, sets of possible outputs, and available applications:</p>
* Inputs:<ul>
*  <li>SketchIsReady</li>
*  <li>fake_SketchConceptNT_output_for_task_ShareConceptNT</li>



*</ul>
* Expected output: <ul>

*<li> 	Set  "ConceptCreation":<ul>
*<li>      Created  entities in the main mental state:<ul>
*<li>           ConceptSketch </li>
*</ul></li>
*<li>	   Created entities only in the workflow:<ul>
*<li>           fake_ShareConceptNT_output_for_task_CollectDrawingsNT </li>
*</ul></li>
*<li>      Created interactions: <ul>
</li>
*</ul></li></ul></li>

*</ul>
* Available apps:<ul>

*</ul>
*/
public class ShareConceptNTTask extends Task{

 public ShareConceptNTTask(String id){
  super(id,"ShareConceptNT");
  
 }


 public void execute() throws TaskException{
    YellowPages yp=null; // only available for initiators of interactions

        SketchIsReady  eiSketchIsReady=(SketchIsReady)this.getFirstInputOfType("SketchIsReady");             

        fake_SketchConceptNT_output_for_task_ShareConceptNT  eifake_SketchConceptNT_output_for_task_ShareConceptNT=(fake_SketchConceptNT_output_for_task_ShareConceptNT)this.getFirstInputOfType("fake_SketchConceptNT_output_for_task_ShareConceptNT");             










  		Vector<TaskOutput> outputs = this.getOutputs();
  		  
  		// sets the first possible alternative to be the default one
  		if (!this.getOutputs().isEmpty())  
  		 this.setFinalOutput(outputs.firstElement()); 
  		  		
  		  	
  		
  		// beginning of alternative "ConceptCreation".
  		// -------------------------------------------------------- 
  		TaskOutput	outputsConceptCreation=findOutputAlternative("ConceptCreation",
  																			outputs);
  																			
  		// Uncomment the following to make the task to produce only
  		// the outcome associated to this alternative:
  		// this.setFinalOutput(outputsConceptCreation); 
  		// if nothing is set, the first defined alternative will be chosen 
  		
  	
  		
		ConceptSketch outputsConceptCreationConceptSketch=
			(ConceptSketch)
				outputsConceptCreation.getEntityByType("ConceptSketch");				
		
			
		
		
		
		fake_ShareConceptNT_output_for_task_CollectDrawingsNT outputsConceptCreationfake_ShareConceptNT_output_for_task_CollectDrawingsNT=
			(fake_ShareConceptNT_output_for_task_CollectDrawingsNT)
				outputsConceptCreation.getEntityByType("fake_ShareConceptNT_output_for_task_CollectDrawingsNT");								
		
		
	    
		
		// --------------------------------------------------------
		// End of automatically generated code
  		// -------------------------------------------------------- 
    	//Expected output summary:
		
		// =================================================
		// Alternative "ConceptCreation":
		//     Created  entities in the main mental state:
//           -outputsConceptCreationConceptSketch 
		//	   Created entities only in the workflow:
//           -outputsConceptCreationfake_ShareConceptNT_output_for_task_CollectDrawingsNT 
		//     Created interactions: 

        // =================================================


		// Available apps:


		// Summary of alternatives available to this task
  		// --------------------------------------------------------
  	  		
  		// To set the output to alternative "ConceptCreation" copy the following to the code area
  		// this.setFinalOutput(outputsConceptCreation);
  		  	  		

// Code Area
//#start_node:INGENIASCodeComponent3 <--- DO NOT REMOVE THIS	
//REPLACE THIS COMMENT WITH YOUR CODE
System.out.println(getAgentID()+" executing -> "+getID()+":"+getType());
outputsConceptCreationConceptSketch.setsketch(eiSketchIsReady.getsketch());
//#end_node:INGENIASCodeComponent3 <--- DO NOT REMOVE THIS

 }
 
}

 