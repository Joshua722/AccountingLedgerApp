# AccountingLedgerApp
This project is recording user input and allowing the input to manipulate the data on a CSV file. 
While stored in a hashmap so that it can be filtered later on if the user decides to have specific searches.
For this project, I decided to split this into different classes to make it neater or more organized.
<img width="189" alt="Screenshot 2023-10-24 163425" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/aa38c2dc-225a-4a2e-bc04-35b484b46673">
The home screen only contains the home screen that will be presented to the user first and will give them a list of options. I have also created the addDeposits and addPayments methods since this will be in the first set of options.
<img width="425" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/acb24391-c34b-4ebb-bab0-532b7e7e058e">
Here are the methods created in this class
<img width="274" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/c2371713-6e41-47ea-b7f2-6d0a76bc160d">
In the next class DisplayLedger, I gave options to the user that included displaying all, payments, and deposits, and gave them options to back home screen or go to a report screen.
<img width="338" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/bc372ed4-48dd-47c0-bcd0-1275e8c3ebe6">
Here are the methods I worked on in this class
<img width="278" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/a67143c1-ee48-4443-8fc7-06176332113f">
The following methods:displayLedger will give user options to choose from, displayAll will display all information contained in the CSV and sort in descending order, displayDeposits will only display deposits in descending order, and displayPayments will only display payments in descending order as well.
The last method worked on in that class was the newReports method, which takes the user to a different screen that presents them with pre-defined filters that the user can choose from. In this method, I used for each loop to run through the hashmap to get the values and put them into an if statement that takes the information and compares it to the local date/time.
In the ledger screen, I defined the variables and created a constructor to use later when they are called to print out data.
<img width="434" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/57ae5cde-a787-4728-9d20-fdbafb77d3f4">
<img width="199" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/3ba747e9-f1dc-486e-96f3-dae3779ab5ae">
In the reader class, I created the file reader and buffered readers so that it can read the CSV and later on be called in a different class to use a buffered writer.
<img width="251" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/3de35b7c-0809-4a6a-b902-87437a792789">
<img width="400" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/9c3821f2-c3dc-472b-8597-40e351fac205">
Lastly, I created a main to have everything be called in there, and to keep it simple I only have two classes being called and those classes will handle the rest.
<img width="284" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/426b4425-ae3c-43ac-bac9-eb4d2c028884">



Overall I really enjoyed this project it has given me an increase in confidence when it comes to logging and manipulating data in a CSV file|Hashmaps|ArrayList. 
I spent some time reviewing notes on LocalDateTime and started to practice more of the collections with ArrayList, I'm not super well versed in it, but it definitely is something that is very useful and practical to use.
A piece of code that I found really interesting was in my newReports method one of the cases, case 5 searches through the vendors and displays the transaction that matches the user input. 
<img width="406" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/666b2cb0-b133-447f-81fe-d9e3b0d99d61">
When it clicked in my head to use a boolean to set that to true if it does find it, all of the dots connected and I proceeded to add the else if just in case it does not find it.


Here are the application screens:
Home Screen : <img width="283" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/cc34c108-4ca8-40d0-92b0-319e517de2bd">
Deposits : <img width="297" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/714b047c-6917-4eb4-a7c3-12488eaded78">
Ledger Screen : <img width="281" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/22ff1cf6-54c8-44e4-8f2b-dca497239b8f">
Payments : <img width="289" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/ce9c3a78-324a-4726-b15a-de40e8617a0a">
Exit : <img width="204" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/af86d8ac-6bd8-49b7-8978-fadb33799f78">
Now here are the individual options for each choice and its output:
DisplayAll : <img width="518" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/2523bf2d-a374-44b5-aa03-67174ae542c7"> 
After it displays all the information it sends the user back to the Ledger Screen
DisplayDeposits : <img width="473" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/eb1ad599-abe5-49f7-865c-05ce58d584df">
This time it will only display positive numbers that define them as deposits
DisplayPayments : <img width="442" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/fb5e2bcc-81ca-45a7-8751-260cda1e8088">
It will only display the negative numbers that define them as payments
If the user decides to go to a new screen they will be presented with the following screen:
<img width="224" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/8a821b60-00b7-4bb7-8ac7-5e0bef7e27dc">
If the user chooses option 1 the output will be from the start of the month to the current date: <img width="434" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/824871a8-6d86-4d13-8ee6-0f9afdeee870">
The user chooses option 2 output will be from the previous month: <img width="388" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/a6d0fe34-abd8-4088-9b2a-94a586c7f9bc">
The user chooses option 3 output will be from the start of the year till the current date: <img width="481" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/fdb432f3-2798-427d-b0fe-912979a4103f">
The user chooses option 4 output will be from the previous year: <img width="488" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/2d75d1a0-53d3-4607-9157-fb526bd3ab9c">
Option 5 gives the user the ability to search for a vendor and display that full transaction: <img width="400" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/b5cd83df-3373-4c65-85d9-bd4ccbdc66af">
If a vendor does not exist they will be presented with this: <img width="506" alt="image" src="https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/ffc74550-6adc-4ac4-8615-293eb981465d">
That concludes all of the screens!


















