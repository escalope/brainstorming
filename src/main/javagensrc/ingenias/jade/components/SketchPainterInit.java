

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
import ingenias.jade.exception.*;
import ingenias.jade.JADEAgent;
import ingenias.jade.mental.*;
import ingenias.jade.components.*;
import ingenias.jade.smachines.*;

public  class SketchPainterInit {


private static java.lang.String semaphore="SketchPainter";
 


 private static Vector<SketchPainterAppImp> appsinitialised=new Vector<SketchPainterAppImp>();
 


 public static void initialize(SketchPainterAppImp app){
//#start_node: <--- DO NOT REMOVE THIS	

//#end_node: <--- DO NOT REMOVE THIS
 }

 public static void shutdown(SketchPainterAppImp app){
//#start_node: <--- DO NOT REMOVE THIS	

//#end_node: <--- DO NOT REMOVE THIS
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<SketchPainterAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static SketchPainterApp createInstance(){
  	synchronized (semaphore) {
	SketchPainterAppImp app=new SketchPainterAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static SketchPainterApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	SketchPainterAppImp app=new SketchPainterAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 