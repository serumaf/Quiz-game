/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;


import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;





/**
 *
 * @author ANFAL
 */
public class Serveur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
         try{
            
            ServerSocket svr= new ServerSocket(5000);
            System.out.println("Serveur connecté sur le port d'écoute "+ svr.getLocalPort() + " en attente d'une requete ");
          while (true) { 
              
              
               Socket sClient;
             sClient = svr.accept ();
             
             System.out.println ("Client connecté sur le port transfert " + sClient.getPort ());
                 
                  DataInputStream  Sin= new DataInputStream(sClient.getInputStream());    
                  DataOutputStream Sout= new DataOutputStream(sClient.getOutputStream()); 
                  
              
            String msg;
            Sout.writeUTF("\n Question 1: Quelle est la saison vient juste avant le printemps? \n  A/ L'hiver      B/ L'été    C/ L'automne \n");
            msg=Sin.readUTF();
            System.out.println(" client :"+msg);   
              
              
              
        if(msg.equalsIgnoreCase("A")){
                  
                  Sout.writeUTF(" EXCELLENT ! \n\n"+"Question 2: A quelle date le printemps dure-t-il? \n  A/ 22 Mars    B/ 21 Mars   C/ 24 Mars \n");
                  msg=Sin.readUTF();
                  
                  if(msg.equalsIgnoreCase("B")){
                     Sout.writeUTF(" EXCELLENT !\n\n ****YOU GOT THIS WELL PLAYED! ****\n");   
                  }
                  else{
                      
                      
                   
                        int c=1;
               while(c<2 && !msg.equalsIgnoreCase("B") ){
                   
                   Sout.writeUTF(" Oops. \n  Let's give it another shot !: \n ");
                   msg=Sin.readUTF();
                   c++;
                   
               }
                  
                  
                  if(msg.equalsIgnoreCase("B")){
                  
                  Sout.writeUTF(" EXCELLENT ! \n\n **** YOU GOT THIS WELL PLAYED! ****\n");
                
              }else if(c>=2){
                       Sout.writeUTF(" Oops. \n\n  ***** Game Over D: ***** ! ");
                 
                }
                      
             }
       
              }else{
                  
               int  c=1;
               while(c<2 && !msg.equalsIgnoreCase("A") ){
                   
                   Sout.writeUTF(" Oops. \n Let's give it another shot !: \n ");
                   msg=Sin.readUTF();
                   c++;
                   
                }
                  
                  
                if(msg.equalsIgnoreCase("A")){
                  
                 Sout.writeUTF(" EXCELLENT ! \n\n"+"Question 2: A quelle date le printemps dure-t-il? \n  A/ 22 Mars    B/ 21 Mars   C/ 24 Mars \n");
                 msg=Sin.readUTF();
                 
                 
                 
                  if(msg.equalsIgnoreCase("B")){
                     Sout.writeUTF(" EXCELLENT !\n\n **** YOU GOT THIS WELL PLAYED! **** \n");   
                  }
                  else{
                      
                      
                   
                    c=1;
                  while(c<2 && !msg.equalsIgnoreCase("B") ){
                   
                   Sout.writeUTF(" Oops. \n  Let's give it another shot !: \n ");
                   msg=Sin.readUTF();
                   c++;
                   
                    }
                  
                  
                  if(msg.equalsIgnoreCase("B")){
                  
                       Sout.writeUTF(" EXCELLENT ! \n **** YOU GOT THIS WELL PLAYED! ****\n");
                    }else if(c>=2){
                       Sout.writeUTF("Oops. \n \n  ***** Game Over D: *****! ");
                    }
                }
                 
                }else if(c>=2){
                      
                Sout.writeUTF("  Oops. \n \n  ***** Game Over D: ***** ! ");
                } 
            }
              
              
              
              
              
              
              
              
              
              
              
          }
        
    }catch(IOException ex){
        
        Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE,null,ex);
             }
        
        
      
    }
    
}
