
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


package ingenias.jade.agents;


import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.*;
import ingenias.jade.*;
import ingenias.jade.smachines.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;

import jade.core.*;
import jade.core.behaviours.*;

import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPAException;
import jade.domain.DFService;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import ingenias.jade.*;
import java.util.*;
import ingenias.jade.exception.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ingenias.editor.entities.RuntimeFact;
import ingenias.jade.components.*;
import ingenias.jade.mental.*;
import ingenias.editor.entities.ApplicationEventSlots;
import ingenias.editor.entities.Interaction;
import ingenias.editor.entities.MentalEntity;
import ingenias.editor.entities.ObjectSlot;
import ingenias.editor.entities.RuntimeEvent;
import ingenias.editor.entities.RuntimeFact;
import ingenias.editor.entities.RuntimeConversation;
import ingenias.editor.entities.Slot;

import ingenias.jade.components.Task;
import ingenias.jade.graphics.*;
import ingenias.jade.MentalStateManager;
import ingenias.exception.InvalidEntity;

public class RandomSketchAgentJADEAgent
		 extends JADEAgent {         
 
		 public RandomSketchAgentJADEAgent(){
		 super(new RandomSketchAgentProtocol(),new RandomSketchAgentInteractionLocks());
		 }

	private boolean initialiseNonConversationalTask(Task tobject) {
	   boolean initialised=false;
	   Vector<String> repeatedOutputs=new Vector<String>();
	    Vector<String> nonExistingInputs=new Vector<String>();
	    
	    if (tobject.getType().equals("DeleteNonUsedEntitiesTask")){
            Vector<MentalEntity> expectedInput=null;
            RuntimeFact expectedOutput=null;
            RuntimeEvent expectedOutputEvent=null;
			RuntimeConversation expectedInt=null;
            ingenias.jade.components.Resource expectedResource=null;
			ingenias.jade.components.Application expectedApp=null;        
			boolean allEntitiesExist=false;		
			TaskOutput to=null;
			to=new TaskOutput("default");
  
		
		expectedInput=this.getMSM().getMentalEntityByType("fake_ShareConceptNT_output_for_task_CollectDrawingsNT");
		if (this.getLM().canBeDeleted(expectedInput)){             
             if (expectedInput.size()==0){
				nonExistingInputs.add("fake_ShareConceptNT_output_for_task_CollectDrawingsNT");
			 } else {
			    JADEAgent.addExpectedInputs(tobject, "fake_ShareConceptNT_output_for_task_CollectDrawingsNT","1",expectedInput);
             	JADEAgent.addConsumedInput(to,"fake_ShareConceptNT_output_for_task_CollectDrawingsNT",expectedInput);
			 }
             allEntitiesExist=allEntitiesExist || expectedInput.size()!=0;
		} 
	      
		expectedInput=this.getMSM().getMentalEntityByType("ConceptSketch");
		if (this.getLM().canBeDeleted(expectedInput)){             
             if (expectedInput.size()==0){
				nonExistingInputs.add("ConceptSketch");
			 } else {
			    JADEAgent.addExpectedInputs(tobject, "ConceptSketch","1",expectedInput);
             	JADEAgent.addConsumedInput(to,"ConceptSketch",expectedInput);
			 }
             allEntitiesExist=allEntitiesExist || expectedInput.size()!=0;
		} 
	      
		 tobject.addOutput(to);
     		   	
	      initialised= allEntitiesExist;

		  if (!allEntitiesExist){
			StringBuffer nonexisting=new StringBuffer();
			for (int j=0;j<nonExistingInputs.size();j++){
				nonexisting.append(nonExistingInputs.elementAt(j).toString()+",");
			}
   		  }
		  return initialised;
	    }
	
   	    
    	         
                  
         
         nonExistingInputs.clear();
  		 repeatedOutputs.clear();
         if (tobject.getType().equals("MyVersion") ){
            Vector<MentalEntity> expectedInput=null;
            RuntimeFact expectedOutput=null;
            RuntimeEvent expectedOutputEvent=null;
			RuntimeConversation expectedInt=null;
            ingenias.jade.components.Resource expectedResource=null;
			ingenias.jade.components.Application expectedApp=null;        
			boolean allEntitiesExist=true;		
			TaskOutput to=null;
			 

			
		
	      
	      
				
             expectedInput=this.getMSM().getMentalEntityByType("FrameFact0");
             if (expectedInput.size()==0 && !("1".equals("0..n"))){
				nonExistingInputs.add("FrameFact0");
			 } else {
			    JADEAgent.addExpectedInputs(tobject, "FrameFact0","1",expectedInput);             
			 }
             allEntitiesExist=allEntitiesExist&& expectedInput.size()!=0;
	      
	      
	     
	      
	     
	      
	     // Default application for all tasks executed within a conversation
	     expectedApp=(ingenias.jade.components.Application)getAM().getApplication("YellowPages");
             tobject.addApplication("YellowPages",expectedApp);
	      
	      /**/	      
	      

     		      
     if (allEntitiesExist){
         // some tasks do not have output, so a fake one has to be created
         // to allocate input consumption
         if (to==null){
           to=new TaskOutput("default"); 
           tobject.addOutput(to);
         }
	       for (TaskOutput singleTO:tobject.getOutputs()){
	      		
             expectedInput=this.getMSM().getMentalEntityByType("FrameFact0");
             if (expectedInput.size()==0 && !("1".equals("0..n"))){			
			 } else {
			    // to remove the input from whatever alternative
             	addConsumedInput(singleTO,"1",expectedInput);
			 }
             allEntitiesExist=allEntitiesExist&& expectedInput.size()!=0;
	      
	       }
	 }
	      initialised= allEntitiesExist;

		if (!allEntitiesExist){
		   String[] nonexisting=new String[nonExistingInputs.size()];
		   for (int j=0;j<nonExistingInputs.size();j++){
				nonexisting[j]=nonExistingInputs.elementAt(j).toString();
			}
			EventManager.getInstance().conversationalInitializationOfTaskFailed(getLocalName(), 
												"RandomSketchAgent", 
												tobject, nonexisting);
		} else {
		 
		}
		return initialised;	       
	      }
                 
         
	      return false;
	}
	
	private boolean initialiseConversationalTask(RuntimeConversation conversation, Task tobject) {
	   boolean initialised=false;
	   Vector<String> nonExistingInputs=new Vector<String>();
	   Vector<String> repeatedOutputs=new Vector<String>();
	   boolean validConversationType=false;
	   
	   if (tobject.getType().equals("DeleteNonUsedEntitiesTask")){
            Vector<MentalEntity> expectedInput=null;
            RuntimeFact expectedOutput=null;
            RuntimeEvent expectedOutputEvent=null;
			RuntimeConversation expectedInt=null;
            ingenias.jade.components.Resource expectedResource=null;
			ingenias.jade.components.Application expectedApp=null;        
			boolean allEntitiesExist=false;		
			TaskOutput to=null;
			to=new TaskOutput("default");
			tobject.setConversationContext(conversation);
  
		
		expectedInput=this.getMSM().obtainConversationalMentalEntityByType(conversation,"fake_ShareConceptNT_output_for_task_CollectDrawingsNT");
		if (this.getLM().canBeDeleted(expectedInput)){                          
             if (expectedInput.size()==0){
				nonExistingInputs.add("fake_ShareConceptNT_output_for_task_CollectDrawingsNT");
			 } else {
			    JADEAgent.addExpectedInputs(tobject, "fake_ShareConceptNT_output_for_task_CollectDrawingsNT","1",expectedInput);
             	JADEAgent.addConsumedInput(to,"fake_ShareConceptNT_output_for_task_CollectDrawingsNT",expectedInput);
			 }
             allEntitiesExist=allEntitiesExist|| expectedInput.size()!=0;
		} 
	      
		expectedInput=this.getMSM().obtainConversationalMentalEntityByType(conversation,"ConceptSketch");
		if (this.getLM().canBeDeleted(expectedInput)){                          
             if (expectedInput.size()==0){
				nonExistingInputs.add("ConceptSketch");
			 } else {
			    JADEAgent.addExpectedInputs(tobject, "ConceptSketch","1",expectedInput);
             	JADEAgent.addConsumedInput(to,"ConceptSketch",expectedInput);
			 }
             allEntitiesExist=allEntitiesExist|| expectedInput.size()!=0;
		} 
	      
		 tobject.addOutput(to);
     		   	
	      initialised= allEntitiesExist;

		  if (!allEntitiesExist){
			StringBuffer nonexisting=new StringBuffer();
			for (int j=0;j<nonExistingInputs.size();j++){
				nonexisting.append(nonExistingInputs.elementAt(j).toString()+",");
			}
   		  }
		  return initialised;
	    }
	    
		    

		    
		validConversationType=validConversationType||
				conversation.getInteraction().getId().equalsIgnoreCase("FirstSessionInt0");
	 	
				
		if (validConversationType){
    	         
         
	   	nonExistingInputs.clear();
  	   	repeatedOutputs.clear();
  	   	boolean correctRole=conversation.getPlayedRole().equals ("Participant");
  	   	// Now all ascendant roles are verified, to enable tasks belonging to roles specializing a more
  	   	// generic one involved in an interaction
  	   	
  	   	correctRole=correctRole|| 
  	   	 conversation.getPlayedRole().equals ("");
  	   	
       	if (tobject.getType().equals("SketchConceptNT") && (false ||
       		correctRole)){
	        Vector<MentalEntity> expectedInput=null;
            
       	RuntimeFact expectedOutput=null;
	   	RuntimeConversation expectedInt=null;
       	ingenias.jade.components.Resource expectedResource=null;
	   	ingenias.jade.components.Application expectedApp=null;        	
	   	TaskOutput originalTO=null;
	   	originalTO=new TaskOutput("default");
	   	TaskOutput to=originalTO;

		tobject.setConversationContext(conversation);
		boolean allEntitiesExist=true;
	     
            
		
            expectedInput=this.getMSM().obtainConversationalMentalEntityByType(conversation,"fake_DefineGoalNT_output_for_task_SketchConceptNT");
			if (expectedInput.size()==0 && !("1".equals("0..n")))
				nonExistingInputs.add("fake_DefineGoalNT_output_for_task_SketchConceptNT");
			else {
			    JADEAgent.addExpectedInputs(tobject, "fake_DefineGoalNT_output_for_task_SketchConceptNT","1",expectedInput);
			    JADEAgent.addConsumedInput(originalTO, "1", expectedInput);
			}
	      allEntitiesExist=allEntitiesExist&& expectedInput.size()!=0;
	      
		
             expectedApp=(ingenias.jade.components.Application)getAM().getApplication("SketchPainter");
             tobject.addApplication("SketchPainter",expectedApp);
	      
	      expectedApp=(ingenias.jade.components.Application)getAM().getApplication("YellowPages");
             tobject.addApplication("YellowPages",expectedApp);
        /*     
		
	      */	      
	     boolean alreadyExists=true;
	
		 to=new TaskOutput("default");
	     transferOutput(originalTO,to);
	     
		  
         tobject.addOutput(to);
	     
	     
		    {fake_SketchConceptNT_output_for_task_ShareConceptNT expectedOutputfake_SketchConceptNT_output_for_task_ShareConceptNT=		    
		     new fake_SketchConceptNT_output_for_task_ShareConceptNT(MentalStateManager.generateMentalEntityID());			
             to.add(new OutputEntity(expectedOutputfake_SketchConceptNT_output_for_task_ShareConceptNT,TaskOperations.CreateWF));
            }
	     
     
	     tobject.addOutput(to);
	     
	     
     	      if (!allEntitiesExist){
     	         String[] nonexisting=new String[nonExistingInputs.size()];
		   		 for (int j=0;j<nonExistingInputs.size();j++){
					nonexisting[j]=nonExistingInputs.elementAt(j).toString();
				 }
				 EventManager.getInstance().conversationalInitializationOfTaskFailed(
				 			getLocalName(), "RandomSketchAgent", 
												tobject, nonexisting);
     	     			
			   } else {
			   
			   
			   }
	        	       
 	      initialised= allEntitiesExist;
 	       return initialised;
	      }
         
         
         }
         validConversationType=false;
             

		    
		validConversationType=validConversationType||
				conversation.getInteraction().getId().equalsIgnoreCase("FirstSessionInt0");
	 	
				
		if (validConversationType){
    	         
         
	   	nonExistingInputs.clear();
  	   	repeatedOutputs.clear();
  	   	boolean correctRole=conversation.getPlayedRole().equals ("Participant");
  	   	// Now all ascendant roles are verified, to enable tasks belonging to roles specializing a more
  	   	// generic one involved in an interaction
  	   	
  	   	correctRole=correctRole|| 
  	   	 conversation.getPlayedRole().equals ("");
  	   	
       	if (tobject.getType().equals("ShareConceptNT") && (false ||
       		correctRole)){
	        Vector<MentalEntity> expectedInput=null;
            
       	RuntimeFact expectedOutput=null;
	   	RuntimeConversation expectedInt=null;
       	ingenias.jade.components.Resource expectedResource=null;
	   	ingenias.jade.components.Application expectedApp=null;        	
	   	TaskOutput originalTO=null;
	   	originalTO=new TaskOutput("default");
	   	TaskOutput to=originalTO;

		tobject.setConversationContext(conversation);
		boolean allEntitiesExist=true;
	     
            
		
            expectedInput=this.getMSM().obtainConversationalMentalEntityByType(conversation,"SketchIsReady");
			if (expectedInput.size()==0 && !("1".equals("0..n")))
				nonExistingInputs.add("SketchIsReady");
			else {
			    JADEAgent.addExpectedInputs(tobject, "SketchIsReady","1",expectedInput);
			    JADEAgent.addConsumedInput(originalTO, "1", expectedInput);
			}
	      allEntitiesExist=allEntitiesExist&& expectedInput.size()!=0;
	      
            expectedInput=this.getMSM().obtainConversationalMentalEntityByType(conversation,"fake_SketchConceptNT_output_for_task_ShareConceptNT");
			if (expectedInput.size()==0 && !("1".equals("0..n")))
				nonExistingInputs.add("fake_SketchConceptNT_output_for_task_ShareConceptNT");
			else {
			    JADEAgent.addExpectedInputs(tobject, "fake_SketchConceptNT_output_for_task_ShareConceptNT","1",expectedInput);
			    JADEAgent.addConsumedInput(originalTO, "1", expectedInput);
			}
	      allEntitiesExist=allEntitiesExist&& expectedInput.size()!=0;
	      
		
	      expectedApp=(ingenias.jade.components.Application)getAM().getApplication("YellowPages");
             tobject.addApplication("YellowPages",expectedApp);
        /*     
		
	      */	      
	     boolean alreadyExists=true;
	
		 to=new TaskOutput("ConceptCreation");
	     transferOutput(originalTO,to);
	     
		  
         tobject.addOutput(to);
	     
 			{
 			ConceptSketch expectedOutputConceptSketch=
 				new ConceptSketch(MentalStateManager.generateMentalEntityID());
 			if (RuntimeConversation.class.isAssignableFrom(expectedOutputConceptSketch.getClass())){
 			    java.lang.reflect.Method m;
				try {
					m = expectedOutputConceptSketch.getClass().getMethod("setInteraction", new Class[]{Interaction.class});
					m.invoke(expectedOutputConceptSketch, new Interaction("")) ;	  
				} catch (SecurityException e) {					
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
 			}	 			
            to.add(new OutputEntity(expectedOutputConceptSketch,TaskOperations.CreateMS));
            }
	     
	     
		    {fake_ShareConceptNT_output_for_task_CollectDrawingsNT expectedOutputfake_ShareConceptNT_output_for_task_CollectDrawingsNT=		    
		     new fake_ShareConceptNT_output_for_task_CollectDrawingsNT(MentalStateManager.generateMentalEntityID());			
             to.add(new OutputEntity(expectedOutputfake_ShareConceptNT_output_for_task_CollectDrawingsNT,TaskOperations.CreateWF));
            }
	     
     
	     tobject.addOutput(to);
	     
	     
     	      if (!allEntitiesExist){
     	         String[] nonexisting=new String[nonExistingInputs.size()];
		   		 for (int j=0;j<nonExistingInputs.size();j++){
					nonexisting[j]=nonExistingInputs.elementAt(j).toString();
				 }
				 EventManager.getInstance().conversationalInitializationOfTaskFailed(
				 			getLocalName(), "RandomSketchAgent", 
												tobject, nonexisting);
     	     			
			   } else {
			   
			   
			   }
	        	       
 	      initialised= allEntitiesExist;
 	       return initialised;
	      }
         
         
         }
         validConversationType=false;
         
		return false;
	}       

		
 	// This method returns the tasks this agent can perform in
	// order to satisfy the goal
	public Vector tasksThatSatisfyGoal(String goalname){
         Vector tasks=new Vector();
         Vector<String> typesOfConversation=null;
         //************************************
         // Conversational tasks evaluation
         //************************************
         
         typesOfConversation=new Vector<String>();
	     
	     typesOfConversation.add("FirstSessionInt0");
		 
         
         if (goalname.equals("Design_a_chair")){
         
          {
		    Task tobject=null;
			Vector<RuntimeConversation>  conversations=getCM().getCurrentActiveConversations(typesOfConversation);
				boolean canbescheduled=false;
				for (int k=0;k<conversations.size();k++){
					tobject=new SketchConceptNTTask(ingenias.jade.MentalStateManager.generateMentalEntityID());
					canbescheduled=initialiseConversationalTask(conversations.elementAt(k),tobject);
					if (canbescheduled){
					//	MainInteractionManager.log("Scheduled task "+tobject.getType()+" to achieve goal Design_a_chair",getLocalName()+"-"+tobject.getType());
						tasks.add(tobject);
					}
					tobject=new DeleteNonUsedEntitiesTask("DeleteNonUsedEntitiesTask","DeleteNonUsedEntitiesTask");
					canbescheduled=initialiseConversationalTask(conversations.elementAt(k),tobject);
					 if (canbescheduled && IAFProperties.getGarbageCollectionEnabled()){			
							tasks.add(tobject);
					 }
				}
				// If a conversational initialization fails, a conventional one is tried
	      }
         
          }        
         
         
         typesOfConversation=new Vector<String>();
	     
	     typesOfConversation.add("FirstSessionInt0");
		 
         
         if (goalname.equals("Design_a_chair")){
         
          {
		    Task tobject=null;
			Vector<RuntimeConversation>  conversations=getCM().getCurrentActiveConversations(typesOfConversation);
				boolean canbescheduled=false;
				for (int k=0;k<conversations.size();k++){
					tobject=new ShareConceptNTTask(ingenias.jade.MentalStateManager.generateMentalEntityID());
					canbescheduled=initialiseConversationalTask(conversations.elementAt(k),tobject);
					if (canbescheduled){
					//	MainInteractionManager.log("Scheduled task "+tobject.getType()+" to achieve goal Design_a_chair",getLocalName()+"-"+tobject.getType());
						tasks.add(tobject);
					}
					tobject=new DeleteNonUsedEntitiesTask("DeleteNonUsedEntitiesTask","DeleteNonUsedEntitiesTask");
					canbescheduled=initialiseConversationalTask(conversations.elementAt(k),tobject);
					 if (canbescheduled && IAFProperties.getGarbageCollectionEnabled()){			
							tasks.add(tobject);
					 }
				}
				// If a conversational initialization fails, a conventional one is tried
	      }
         
          }        
         
         
         //************************************
         // Non conversational tasks evaluation
         //************************************
         
         if (goalname.equals("RandomIdea")){
         
         {
         boolean canbescheduled=false;
		 Task tobject=null;		 
				// If a conversational initialization fails, a conventional one is tried
				 tobject=new MyVersionTask(ingenias.jade.MentalStateManager.generateMentalEntityID());
				 canbescheduled=initialiseNonConversationalTask(tobject);
			 	 if (canbescheduled){
					//MainInteractionManager.log("Scheduled task "+tobject.getType()+" to achieve goal RandomIdea",getLocalName()+"-"+tobject.getType());
					tasks.add(tobject);
				 } 			
	     }
         
          }
                  
         
         Task tobject=new DeleteNonUsedEntitiesTask("DeleteNonUsedEntitiesTask","DeleteNonUsedEntitiesTask");
         boolean canbescheduled=initialiseNonConversationalTask(tobject);
		 if (canbescheduled && IAFProperties.getGarbageCollectionEnabled()){			
				tasks.add(tobject);
		 }
        return tasks;
	}


	/**
	 *  Initializes the agent
	 */
	public void setup() {
		super.setup();
		Vector<String> ttypes=new Vector<String>(); 
		          
         
                   
         ttypes.add("SketchConceptNT");					
         
         
                  
         
                   
         ttypes.add("ShareConceptNT");					
         
         
         
         
         
         ttypes.add("MyVersion");		         
                
         
         if (IAFProperties.getGraphicsOn())
          this.getGraphics().setKnownTasks(ttypes);

   // Interactions started by this agent		
   
   boolean continueInit=false;
   // Interactions where this agent acts as collaborator
   
   getCM().addKnownProtocol("FirstSessionInt0");
   

   // These are the initial goals of the agent. Goals determine
   // which task to execute first    
   ingenias.editor.entities.StateGoal sg=null;
   ingenias.editor.entities.RuntimeFact ff=null;
   Slot slot=null;	  
   ObjectSlot oslot=null;
   ingenias.jade.components.Application app=null;	  
   
   sg= new ingenias.editor.entities.StateGoal("RandomIdea");
   sg.setState("pending");
      try {
	   this.getMSM().addMentalEntity(sg);
   } catch (InvalidEntity e1) {

	   e1.printStackTrace();
   }
   
   sg= new ingenias.editor.entities.StateGoal("Design_a_chair");
   sg.setState("pending");
      try {
	   this.getMSM().addMentalEntity(sg);
   } catch (InvalidEntity e1) {

	   e1.printStackTrace();
   }
   
   
     

		//Initializing the applications panel in the manager
			
		Vector events=null;		
		RuntimeEvent event=null;
		
	//Initial applications assigned to the agent	  
	Vector actions=null;
	Vector evetns=null;

     //Initial applications assigned to the agent	  
   
     
     app=SketchPainterInit.createInstance(this);
	 //app.registerOwner(this);
	 	    
     this.getAM().addApplication("SketchPainter",app);        
	 events=new Vector();
	 actions=new Vector();
		
	 event= new SketchIsReady();
	 /*
	 slot=new Slot("41");
	 slot.setName("sketch");
	 slot.setType("byte[]");
	 slot.setValue("");
	 event.addSlots(slot);
	  
	 */ 
	 events.add(event);
	 actions.add(generateActionListener(SketchIsReady.class));		

	 if (getGraphics()!=null)
	  getGraphics().addApplication("SketchPainter", events,actions);    


   



   // Panel creation for interaction control
   // This panel shows a button for each interaction it starts.
   // If this agent does not start any interaction, a label showin
   // a message "DOES NOT START ANY INTERACTION" will appear
   java.awt.event.ActionListener ifPressed=null;
      

    
    // Final Graphics initialization
    if (getGraphics()!=null)
     getGraphics().startAgentDebug();
    
    getMSM().setModified(); // to trigger a first planning round
    // To indicate that the MSP can start
    this.agentInitialised();

	}




	/**
	 *  Obtains a DFAgentDescription array that describes the different roles an
       *  agent can play
	 *
	 *@return    Roles played
	 */
	public DFAgentDescription[ ] getDescription() {
               DFAgentDescription[] result=null;
	       Vector playedRoles=new Vector();
	        DFAgentDescription dfd=null;
                dfd = new DFAgentDescription();
                ServiceDescription sd=null;
                
		dfd.setName(getAID());
		sd = new ServiceDescription();
		sd.setName(getLocalName() + "-sub-df");
		sd.setType("RandomSketchAgentR");
		sd.setOwnership("JADE");
		dfd.addServices(sd);
                playedRoles.add(dfd);
                
		dfd.setName(getAID());
		sd = new ServiceDescription();
		sd.setName(getLocalName() + "-sub-df");
		sd.setType("Participant");
		sd.setOwnership("JADE");
		dfd.addServices(sd);
                playedRoles.add(dfd);
                
                
                result=new  DFAgentDescription[playedRoles.size()];
                playedRoles.toArray(result);
		return result;

	}


}

