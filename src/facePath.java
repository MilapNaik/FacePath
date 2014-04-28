/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS. Milap Naik & Sushmitha Radhakrishnan
*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.*;


public class facePath {

	static private JTextArea fbook;
	static private JLabel actions1;
	static private JLabel actions2;
	static private JLabel actions3;
	static private JLabel actions4;
	static private JLabel actions5;
	static private JLabel actions6;
	static private JLabel actions7;
	static private JLabel actions8;
	static private JButton choose;
	static private JTextField input;
	static private JLabel enterA;
	
	static HashSC x = new HashSC(1019);
	
	public static void main(String[] args){
	
		//Construct GUI
		JFrame f = new JFrame ("FacePath");
		
		JPanel rightPanel = new JPanel();
		
		//Add elements to rightPanel
		actions1 = new JLabel("[1] New User");
		actions2 = new JLabel("[2] Update Profile");
		actions3 = new JLabel("[3] Add Friend");
		actions4 = new JLabel("[4] Search for User");
		actions5 = new JLabel("[5] Remove Friend");
		actions6 = new JLabel("[6] Find degrees of seperation");
		actions7 = new JLabel("[7] Remove User     ");
		actions8 = new JLabel("[8] Print all users of facePath");
		JPanel enterAction = new JPanel();
		enterA = new JLabel("Choose: ");
		input = new JTextField(3);
		choose = new JButton("Enter");
		enterAction.add(enterA);
		enterAction.add(input);
		rightPanel.add(actions1);
		rightPanel.add(actions2);
		rightPanel.add(actions3);
		rightPanel.add(actions4);
		rightPanel.add(actions5);
		rightPanel.add(actions6);
		rightPanel.add(actions7);
		rightPanel.add(actions8);
		rightPanel.add(enterAction);
		rightPanel.add(choose);
		
		//text area
		fbook = new JTextArea(50,30);
		fbook.setText("Please create a user profile");
		
		//GUI layout
		f.getContentPane().add(fbook, "West");
		f.getContentPane().add(rightPanel, "Center");
		
		//REGISTER ACTION LISTENER
		//choose an action
		choose.addActionListener(new chooseAction());
		
		f.setSize(555,400);
		f.setVisible(true);
		
	}
	
	static private class chooseAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String c = input.getText();
			int choice = Integer.parseInt(c);
			if ( choice == 1){ //NEW USER
				fbook.setText("Initializing User Creation Wizard...");
				String name11 = JOptionPane.showInputDialog("What's your name?");
				if (x.contains(name11)){
					fbook.setText("User already exists");
				}//closes if
				else{	
				String name12 = name11.toLowerCase();
				String a = JOptionPane.showInputDialog("Age?");
				int age = Integer.parseInt(a);
				String education = JOptionPane.showInputDialog("Education?");
				userProfile p = new userProfile(name12, age, education); //call the constructor to make a profile
				x.put(name12, p);
				fbook.setText(p.get());
				}//closes else
			}//closes choice 1
			
			if (choice == 2) {  //UPDATE USER
				String name21 = JOptionPane.showInputDialog("What's your name?");
				String name22 = name21.toLowerCase();
			    userProfile u = x.get(name22);
				boolean check = x.contains(name22);//check first to see if exists
				if (check == true){
					fbook.setText("This is info we have saved for you" + "\n" + u.get());	
					String a = JOptionPane.showInputDialog("Age? If you don't want to update, type 0.");
					int ageU = Integer.parseInt(a);
					String eduU = JOptionPane.showInputDialog("Education? If you don't want to update, type n/a");
					u.update(ageU, eduU);
					fbook.setText("This is your updated information: " + "\n" + u.get());
				}//closes if statement
				else
					fbook.setText("That user does not exist.");
			}//closes choice 2
			
			if (choice == 3) {  //ADD FRIEND
				String name31 = JOptionPane.showInputDialog("What's your name?");
				String name32 = name31.toLowerCase();
				String name33 = JOptionPane.showInputDialog("What's the name of the friend you would like to add?");
				String name34 = name33.toLowerCase();
				if ( !x.contains(name32) || !x.contains(name34)){
					if (!x.contains(name32)) {
			            fbook.setText("Your username does not exist"); 
			        }//closes if
			        else { //if friend doesn't exist
			            if(!x.contains(name34)){
			               fbook.setText("Your friend does not exist");
			            }//closes if
			        }//closes else
		        }//closes if
		        else{
		            // get the userProfiles with these keys
		            userProfile u = x.get(name32);
		            userProfile f = x.get(name34);  
		        
		            // update the friend's list of both of these users 
		            u.addFriend(name34); 
		            f.addFriend(name32); 
		         
		            //Print out their updated information  
		            fbook.setText(u.get() + "\n" + "\n" + f.get() + "\n" + "\nIt's official....you're friends!!!!!!:)");
			     }//closes else
			}//closes choice 3
			
			if (choice == 4){ //SEARCH FOR USER
				String name41 = JOptionPane.showInputDialog("Enter the name of the user you would like to search for:");
		        String name42 = name41.toLowerCase();  
		           
		        //check if user exists before trying to search for them 
		        boolean check1 = x.contains(name42);
		        if(check1 == true) { 
		           userProfile u = x.get(name42); 
		           String info = u.get();
		           fbook.setText("This is " + name42 + ":" + "\n" + "\n" + info);
		        }//closes if
		        else {
		           fbook.setText("User does not exist");
		        }//closes else 
		      }//closes choice 4
			
			if (choice == 5){ //REMOVE FRIEND
				String name51 = JOptionPane.showInputDialog("Enter your name:");
		        String name52 = name51.toLowerCase();
		        
		        String name53 = JOptionPane.showInputDialog("Enter the name of a friend you would like to remove"); 
		        String name54 = name53.toLowerCase();
			       
		        if (!x.contains(name52) || !x.contains(name54)){ //checks if remove friend can even be implemented 
		            if (!x.contains(name52)) {
		               fbook.setText("Your username does not exist"); 
		            }//closes if
		            else { //if friend doesn't exist
		               if(!x.contains(name54)){
		               fbook.setText("Your friend does not exist");
		               }//closes if
		            }//closes else
		         }  //closes if
		         else {
	                // Removing friends 
	                userProfile u = x.get(name52);
	                userProfile r = x.get(name54);
	                // Update friend's list by removing friends 
	                u.RemoveFriend(name54);
	                r.RemoveFriend(name52);
	                fbook.setText(u.get() + "\n" + "\n" + r.get() + "\n" + "\nYou two are no longer friends :(");
		         }//closes else
			}//closes choice 5
			
			if (choice == 6){ //FIND DEGREES OF SEPERATION
				fbook.setText("How many degrees of Seperation is User 2 from User 1?");
		        String name61 = JOptionPane.showInputDialog("User 1:");
		        String name62 = name61.toLowerCase(); //store the string read in 
		           
		        String name63 = JOptionPane.showInputDialog("User 2:");
		        String name64 = name63.toLowerCase(); //store the string read in 
		     
		        if (!x.contains(name62) || !x.contains(name63)){ //checks if remove friend can even be implemented 
		             if (!x.contains(name62)){
		                fbook.setText("Your username does not exist"); 
		             }//closes if
		             else { //if friend doesn't exist
		                if(!x.contains(name64)){
		                   fbook.setText("Your friend does not exist");
		                }//closes if
		             }//closes else
		        }//closes if 
		        else { 
			         BFP dfs = new BFP(x,name62); //find all paths for user1    
		             if (dfs.hasPathTo(x.hash(name64))){ //check to see if user1 has a path to user2 
		                Stack <Integer> path = dfs.pathTo(x.hash(name64));
		                int deg = 0; //keep track of hops taken

		                while(!path.empty()) {  //increment hops each time a user is popped 
		                      path.pop(); 
		                      deg++;
	                    }//closes while  
	                    if (deg>2){ 
	                    	String deg1 = Integer.toString(deg-1);
	                       fbook.setText("You are " + deg1 + " degree(s) apart."); 
	                    }//closes if
	                    else{ //exception cases that don't follow the rule in the the preceding if statement 
	                       if (deg==2){
	                    	   String deg2 = Integer.toString(1);
	                          fbook.setText("You are " + deg2 + " degree(s) apart.");
	                       }//closes if
	                       if (deg==1){
	                    	   String deg3 = Integer.toString(0);
	                          fbook.setText("You are " + deg3 + " degree(s) apart.");
	                       }//closes if
	                    }//closes else
		             }//closes if	             
	                 else{
	                    fbook.setText("There is NO connection between these two users"); 
	                 }//closes else
		        }//closes else
			}//closes option 6
			
			if (choice == 7){ //REMOVE USERPROFILE 
				JFrame myFrame = null;
				JOptionPane.showMessageDialog(myFrame, "Are you sure you want to deactivate your account?");
				JOptionPane.showMessageDialog(myFrame, "FacePath is too awesome for you to deactive!");
				int response = JOptionPane.showConfirmDialog(myFrame, "Think some more about it, and tell us (Y/N)"); 
				if (response != JOptionPane.YES_OPTION){
				    fbook.setText("Yay! You made the right choice :D");
				}
				else {
					String name71 = JOptionPane.showInputDialog("Oh, well...you're friends will miss you :/" +
					                "\nPlease enter your name");         
				    String name72 = name71.toLowerCase();
				    userProfile y = x.get(name72); 
				    ArrayList<String> f = y.friends; //save all the friends whose friend's lists need to be updated 
				    for(int i = 0 ; i<f.size(); i++){ //delete the user from all the friends' lists that he is friends with 
				        userProfile j = x.get(f.get(i));
				        j.RemoveFriend(name72);
				    }
			        x.delete(name72); //delete the userProfile form the hash table  
			        fbook.setText("You are no longer a user!");
				}
			}//closes choice 7
			
			if (choice == 8){ //PRINT ALL USERS
				ArrayList<String> users = x.keys(); 
				String printall = "";
				for(int i = 0 ; i<users.size(); i++){ //delete the user from all the friends' lists that he is friends with 
				    printall = printall + users.get(i) + "\n"; 
				}//closes for
				fbook.setText(printall);
			}//closes choice 8
		}//closes action performed
    }//closes choose action
}//closes class