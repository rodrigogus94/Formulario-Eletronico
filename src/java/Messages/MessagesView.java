/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodri
 */
@ManagedBean
public class MessagesView {
    
     public void messagesAlterar(){
        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Você não tem permissão para fazer esta ação!"));
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
    
    public void buttonAction() {
        addMessage("Welcome to Primefaces!!");
    }
    
}
