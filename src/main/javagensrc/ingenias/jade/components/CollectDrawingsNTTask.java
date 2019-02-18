

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

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import ingenias.jade.exception.*;
import ingenias.jade.comm.*;
import ingenias.jade.mental.*;
import ingenias.editor.entities.*;

/**
* 
* <p>The Task  CollectDrawingsNT has the following inputs, sets of possible outputs, and available applications:</p>
* Inputs:<ul>
*  <li>fake_ShareConceptNT_output_for_task_CollectDrawingsNT</li>

*  <li>Collection<ConceptSketch> </li>           


*</ul>
* Expected output: <ul>

*</ul>
* Available apps:<ul>
*<li>          SketchPainterApp</li>

*</ul>
*/
public class CollectDrawingsNTTask extends Task{

 public CollectDrawingsNTTask(String id){
  super(id,"CollectDrawingsNT");
  
 }


 public void execute() throws TaskException{
    YellowPages yp=null; // only available for initiators of interactions

        fake_ShareConceptNT_output_for_task_CollectDrawingsNT  eifake_ShareConceptNT_output_for_task_CollectDrawingsNT=(fake_ShareConceptNT_output_for_task_CollectDrawingsNT)this.getFirstInputOfType("fake_ShareConceptNT_output_for_task_CollectDrawingsNT");             



        Collection<ConceptSketch>  eiConceptSketch=new Vector(this.getAllInputsOfType("ConceptSketch"));             



			
        SketchPainterApp eaSketchPainter=(SketchPainterApp)this.getApplication("SketchPainter");





  		Vector<TaskOutput> outputs = this.getOutputs();
  		  
  		// sets the first possible alternative to be the default one
  		if (!this.getOutputs().isEmpty())  
  		 this.setFinalOutput(outputs.firstElement()); 
  		  		
  		
		// --------------------------------------------------------
		// End of automatically generated code
  		// -------------------------------------------------------- 
    	//Expected output summary:
		

		// Available apps:
//           SketchPainterApp</li>


		// Summary of alternatives available to this task
  		// --------------------------------------------------------

// Code Area
//#start_node:INGENIASCodeComponent4 <--- DO NOT REMOVE THIS	
//REPLACE THIS COMMENT WITH YOUR CODE
System.out.println(getAgentID()+" executing -> "+getID()+":"+getType());
System.out.println(getAgentID()+" received "+eiConceptSketch.size()+ " designs");
Vector v=new Vector();

Vector vFreeHand=new Vector();
Vector vLine=new Vector();
Vector vOval=new Vector();
Vector vPolygon=new Vector(); 
Vector vRoundRect=new Vector(); 
Vector vSolidOval=new Vector(); 
Vector vSolidPolygon=new Vector();
Vector vSolidRoundRect=new Vector(); 
Vector vSolidSquare=new Vector(); 
Vector vSquare=new Vector();
Color backGroundColor=Color.WHITE;
v.removeAllElements();
v.addElement(vFreeHand);
v.addElement(vLine);
v.addElement(vOval);
v.addElement(vPolygon);
v.addElement(vRoundRect);
v.addElement(vSolidOval);
v.addElement(vSolidPolygon);
v.addElement(vSolidRoundRect);
v.addElement(vSolidSquare);
v.addElement(vSquare);	
v.addElement(new Color(backGroundColor.getRGB()));

for (ConceptSketch sketch:eiConceptSketch) {
	try {
		ObjectInputStream oos=new ObjectInputStream(new ByteArrayInputStream(sketch.getsketch()));
		Vector vFile2 = (Vector)oos.readObject();		
		 vFreeHand .addAll( (Vector)vFile2.elementAt(0));
		 vLine.addAll( (Vector)vFile2.elementAt(1));
		vOval			.addAll((Vector)vFile2.elementAt(2));
		vPolygon		.addAll( (Vector)vFile2.elementAt(3));
		vRoundRect		.addAll( (Vector)vFile2.elementAt(4));
		vSolidOval		.addAll( (Vector)vFile2.elementAt(5));
		vSolidPolygon	.addAll( (Vector)vFile2.elementAt(6));
		vSolidRoundRect.addAll( (Vector)vFile2.elementAt(7));
		vSolidSquare	.addAll( (Vector)vFile2.elementAt(8));
		vSquare			.addAll( (Vector)vFile2.elementAt(9));
		backGroundColor =( (Color)vFile2.elementAt(10));
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}

eaSketchPainter.launchEditor(v);
//#end_node:INGENIASCodeComponent4 <--- DO NOT REMOVE THIS

 }
 
}

 