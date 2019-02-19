

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

public  class BrainstormingGUIInit {


private static java.lang.String semaphore="BrainstormingGUI";
 


 private static Vector<BrainstormingGUIAppImp> appsinitialised=new Vector<BrainstormingGUIAppImp>();
 


 public static void initialize(BrainstormingGUIAppImp app){
//#start_node: <--- DO NOT REMOVE THIS	

//#end_node: <--- DO NOT REMOVE THIS
 }

 public static void shutdown(BrainstormingGUIAppImp app){
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



 public static Vector<BrainstormingGUIAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static BrainstormingGUIApp createInstance(){
  	synchronized (semaphore) {
	BrainstormingGUIAppImp app=new BrainstormingGUIAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static BrainstormingGUIApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	BrainstormingGUIAppImp app=new BrainstormingGUIAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 