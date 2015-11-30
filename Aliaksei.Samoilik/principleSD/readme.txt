Task: Create modular project with using DRY principle. You could use any of build managers (ant, maven, gradle and etc.)

- mainapp
 Main programm which send messages wirh using different modules EmailModule and SmsModule
 
- sayHiByEmailModule
 Predend that send email in format view (call common method formatMessage).

- sayHiBySMSModule
 Predend that send sms  in format view (call common method formatMessage).

- sayHiCommon
 common interface. All potential modules should implement it.

- utils
 contains formatMessage method which is called from sayHiByEmailModule and sayHiBySMSModule means that the same code is not repeated and moved to separated module which is responsible for formatting. It shows DRY principle. 
 
 

