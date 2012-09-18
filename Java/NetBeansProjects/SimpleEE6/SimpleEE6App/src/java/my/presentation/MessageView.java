/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author toddpickell
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {


    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }
    
    //Injects the MessageFacade session bean using the @EJB annotation
    @EJB
    private MessageFacade messageFacade;
    
    //creates a new field
    private Message message;
    
    //calls the getMessage to retireve message
    public Message getMessage() {
        return message;
    }
    
    //trying to return all messages 
    public String getAllMessages() {
        
        String myMessages = "";  
        List<Message> maybe = this.messageFacade.findAll();
        for (int i=0; i < maybe.size(); i++) {
            myMessages += maybe.get(i).toString() + "<br>";
        }
        return myMessages;
    }
    
    //returns the total number of messages
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    //saves the message and then returns the string "theend"
    public String postMessage() {
        this.messageFacade.create(message);
        return "theend";
    }
}
