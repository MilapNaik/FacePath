/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS. Milap Naik & Sushmitha Radhakrishnan
*/

import java.util.ArrayList;

public class userProfile{
 
 
 public String name;
 public int age; //store age of user
 public String education; 
 public ArrayList<String> friends; 
 public int n; //keep track of number of friends  
 
 public userProfile(String s, int a, String edu) {
  name = s; 
  age = a; 
  education = edu;   
  friends  = new ArrayList<String> (); 
 }   
 
  public String get(){
    return "Name:" + name + "\nAge:" + age + "\nEducation:" + education + "\nFriends:" + getFriends(); 
   }
   
  public void update(int ageU, String eduU){
    if (ageU != 0){
     age = ageU;
    } 
    
    if (!eduU.equals("n/a")){
     education = eduU;
    } 
  }
   
     public void addFriend(String friend){
    friends.add(friend); 
     }
   
  public void RemoveFriend(String Friend){
  for(int y = 0 ; y<friends.size(); y++){
   if (friends.get(y).equals(Friend)){
    friends.remove(y);
   }
  }
  }
   
  public String getFriends(){
    
   if (friends.isEmpty()){
    return "You have NO friends :("; 
   }
   else{
    String list = null; 
     for (int i=0; i<friends.size(); i++){
      if (i==0){
       String alist = friends.get(i); 
       list = alist;
       continue; 
      }
     String next = friends.get(i); 
     list = list + ", " + next ; 
     } 
    return list;
   }
 }
    
 public String toString(){
  return this.name; 
 }
}