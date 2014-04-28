FacePath
========

1. Project design - 

	▪	What classes/objects did you create? 

	  ⁃	 facePath (MAIN CLASS): This is our main class. This is the class where we interact with the user as well as call the methods from the other classes we need to implement our program. This class is rather code heavy because we also are implementing our GUI in this class. The code in this class is basically centered around what option the user would like to perform on facePath, which is a series of "if statements." Based on what the user enters, we either  call constructors or methods from the other classes. We also construct a hash table of size "1019." This is just an arbitrary prime number we are using to run our program. With that being said, this number can be changed if we expect a huge number of users to use facePath. 
	  
	  ⁃	HashSC (SEPARATE CHAINING HASH TABLE): HashSC is the class written to create our separate chaining hash table. We have various methods written in this class. The main methods are hash(), which maps every userProfile based on the name entered during the creation of the user profile. Other important methods include: contains() -which checks whether the hash table even contains a user and get() - returns the userProfile that is associated with the key/value pair of name/userProfile, put() - inserts a name/userProfile pair every time a user is created in the hash table, and delete() - deletes a name/userProfile from the hash table. 
	  
	  ⁃	SequentialSearchST(OBJECTS IN THE HASH TABLE): The hash table we implement consists of objects of SequentialSearchST. Each object contains the key/value pair of name/userProfile. The main reason we even have this class is because there is always the chance that two users whose name hash to the same value. For this reason, we will have to create a linked list of users (nodes) who hash to the same value. If we ever need to access a user that hashes to the same index as other users, then we are going to have to traverse the list until we find the node that contains the same key as the one we are looking for. The main methods and constructors in this class are : Node() - creates a node to help us traverse the linked list, contains() which tells us whether the node actually contains the key we are looking for, get() - returns the userProfile associated with a key, delete() -deletes a name/userProfile from the hash table, and put() - inserts a name/userProfile pair every time a user is created in the hash table. 
	  
	  ⁃	userProfile (USER PROFILE OBJECT): This is the class which we work with when we create, update, and delete users. It contains four fields that every user has: name, age,education, and a list of friends. Based on what the user would like to do: we can call a constructor that creates a userProfile, updates a userProfile when the user wants to, add/remove friends to an ArrayList of friends. 
	  
	  ⁃	BFP(USES BFS TO FIND DEGREES OF SEPARATION): This is the class we use to find our degrees of separation between users (basically making a path from one user to another). We have a constructor that creates an array that keep tracks of which users have been visited, a source user for whom we are finding all paths, and an edgeTo array that maintains which friends share an edge with other friends. The method that actually does the breadth first search for a source user is bfs(). When we want to check whether two users are connected, we call hasPathTo(). If we want to to find out the path in order to calculate the degrees of separation, we would traverse the edgeTo array to find the path. While traversing the edgeTo array, we push elements into a stack. In the main method, we find the degrees of seperation by keeping track of how many elements we pop from the stack. 
	  

	▪	How do the graphical classes work with your classes? 
	  ⁃	We used the swing class throughout our GUI. We had our main method show the GUI, while the chooseAction method implemented the GUI, including adding all the buttons and textfields, and accepting input dialogue. The hardest part about this part was figuring out the first few parts, since we have never had experience with a GUI before. After the ball got rolling, however, it got easier and easier to code all the parts.
	  
	  
	▪	What data structures did you use to represent your network of friends, and why?
	
	  ⁃	We used an ArrayList to keep track of our network of friends. This made it easy for us to add and delete from the list. Also, we found that is was very easy to traverse an ArrayList to check and see whether someone was friends with someone else. 
	  
	  
	  

 2. Project development - 
 
	▪	Which group member worked on what parts? 

	  ⁃	Milap - GUI, facePath, userProfile
	  
	  ⁃	Sushi - BFP, HashSC, SequentialSearchST 
	  
	  ⁃	We each focused on certain classes/parts of our final program, but there was definitely a lot of collaboration that happened regardless. By the end of the program, we each had contributed something to each class. 
	  
	  
	▪	Did you work separately on individual copies, and then integrate, or work together in front of one computer?
	
	  ⁃	In the beginning stages of the projects, we found it easy to work on one computer. However, as we delved deeper into into it and the project got more complex, we started working on individual copies that we constantly emailed to one another. At one point, we were using Dropbox to make sure we could share the most updated files. However, this didn't last long because our files weren't being updated real time in our respective Dropbox folders.  By the end of the project, we were just emailing each other snippets of codes that we had changed or updated. 
	
3. Project experience - 

	•	What's the most challenging aspect? 
	
	  ⁃	Working as team - We both have two different coding styles and two different visualizations for what the program could be. When we started working separately on our own copies, we found that our code would clash and that it would often take longer to make two different coding styles work in one big larger program, than to actually code both parts. Also, just cooperating with one another as we worked on this project was a big challenge. 
	  
	•	What lessons have you learned?  What would you change the second time around?
	
	  ⁃	It's very important to have a good understanding of what data structures and algorithms you would like to implement. If not, you could write a ton of code only to realize that you did it all wrong. We also learned that when two people collaborate on code, they have to collaborate on EVERYTHING about it. Sometimes we would write our separate pieces of code after talking about it for a good while, only to realize that we never went over what object type we would use for a certain aspect, or what methods we would implement. The second time around we would probably have better communication with one another, that way we both are always on the same page.  
