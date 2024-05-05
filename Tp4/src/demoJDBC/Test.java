package demoJDBC;

import java.sql.Connection;
import java.util.ArrayList;

import JDBCProjet.beans.Client;
import JDBCProjet.connexion.Connexion;
import JDBCProjet.service.ClientService;

public class Test {
	 public static void main(String[] args) {
	    Client c=new Client(1,"mezen","younes");
	      //Client c1=new Client("oussema","mhamed");
	      //Client c2=new Client("aziz","naas");
	      ClientService cs=new ClientService();
	      //cs.create(c);
	      //cs.create(c1);
	      //cs.create(c);
	      ArrayList<Client> l= new ArrayList<Client>(cs.findAll());
	      for (Client client : l) {
	    	    System.out.println("ID: " + client.getId());
	    	    System.out.println("Nom: " + client.getNom());
	    	    System.out.println("Prénom: " + client.getPrenom());
	    	} 
	      System.out.println (cs.findById(4));
	
	      Client c3=new Client(3,"oussemaxx","mhamedxxx");
	    
	      
	     // cs.delete(c5);
	      cs.update(c3);
	 
	 }
}
