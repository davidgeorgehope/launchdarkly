# launchdarkly

Login to launchdarkly and set up the feature flags 'backend-note' and 'edit-note'. 

To run this you need at least Java 18

Clone this repository and then switch to the 'target' directory

Run the application by typing 'java -jar launchdarkly-0.0.1-SNAPSHOT.war'

Go to http://localhost:8080/login

Enter a username, client key and sdk key.

Go to launch darkly and test turning on/off the flags for specific users. 

Provided everything is working correctly you should see that the Edit Button will enable/disable depending on the 'edit-note' flag and that the text below the table will change depending on the 'backend-note' flag.

Questions for LD discussion, 

Do you ever find that people end up creating thousands of usernames by accident or because of hacking?
What do you do about if/else sprawl is there a better way to wrap features that just with if statements?


