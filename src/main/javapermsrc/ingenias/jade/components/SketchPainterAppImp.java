

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

import java.util.*;

import es.ucm.sketchEditor.NotifyResultSketch;
import es.ucm.sketchEditor.SketchEditor;
import ingenias.jade.exception.*;
import ingenias.jade.mental.*;
import ingenias.exception.InvalidEntity;
import ingenias.jade.components.*;
import ingenias.jade.smachines.*;


public  class SketchPainterAppImp extends SketchPainterApp  implements NotifyResultSketch {

	
 public SketchPainterAppImp(){
  super();
 }

 public void launchEditor() {
	 SketchEditor se=new SketchEditor(this.getOwner().getAID().getLocalName(),this);	 
 }
 
 @Override
 public void launchEditor(byte[] getsketch) {
	 SketchEditor se=new SketchEditor(
			 this.getOwner().getAID().getLocalName(),
			 getsketch,
			 this);
 	
 }

@Override
public void sketchIsReady(byte[] sketch) {
	try {
		SketchIsReady event = new SketchIsReady("ready");
		event.setsketch(sketch);
		this.getOwner().getMSM().addMentalEntity(event);
	} catch (InvalidEntity e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



}

 