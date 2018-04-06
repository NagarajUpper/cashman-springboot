# cashman-springboot

About project:
cash dispensing application for use in an ATM or similar device.  There is no need to request authorisation or availability of funds. The application should assume that all requests are legitimate; there will be other components of the system that will do things such as communicating with bank accounts and authorising withdrawals

Build & Deploy:

 Build command:
   mvn clean install
 deployment in 3 ways:
   1. Though the eclipse run as java application.
   2. Goto target folder after build->open cmd prompt -> run the "java -jar cashman-springboot-0.0.1-SNAPSHOT" cmd
   3. Go to base dir ->open cmd prompt-> run the "mvn spring-boot:run "cmd
   
  
 Deploying in extranal tomcat server:
 Step 1: Install Tomact. 
 step 2: Change the <packaging>jar</packaging> to <packaging>war</packaging> ini the main pom
 Step 3: Build the project& go to target folder and copy .war file.
 step 4: Start the tomcat & open tomcat manager window.
 step 5: To deploy the application upload the .war file .
 
 
EndPoint & Request:

#Add Denominations to DB:(Post Oparation)
Request:
http://localhost:8080/addNotes

{  
   "list":[
      {
         "denominationValue":"50",
         "denominationValueCount":100
      },
      {
         "denominationValue":"20",
         "denominationValueCount":100
      }
   ]
}

Response: 200 OK
=======================================================================
#Retrieve the Denomination count from DB:(GET Oparation)
Request:
http://localhost:8080/balanceNotes

Respose:

{  
   "list":[  
      {  
         "denominationValue":"50",
         "denominationValueCount":100
      },
      {  
         "denominationValue":"20",
         "denominationValueCount":100
      }
   ]
}


=============================================================================
#Withdraw Cash:(PUT Oparation)
Request:
http://localhost:8080/getCash/200

Response:
50 Notes are: 4 &  20 Notes are:0 has been  issued.

===============================================================================

