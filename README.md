# Accounting Ledger App

This project allows users to record financial transactions and manage data in a CSV file. The data is stored in a HashMap, making it easy to filter and search for specific transactions. The project is organized into different classes to maintain clarity and organization.

## Screenshots

![Home Screen](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/aa38c2dc-225a-4a2e-bc04-35b484b46673)

The home screen is the initial interface users see. It offers a range of options, including adding deposits and payments.

![Home Screen Options](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/acb24391-c34b-4ebb-bab0-532b7e7e058e)

Here are the methods available in the HomeScreen class.

![Home Screen Methods](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/c2371713-6e41-47ea-b7f2-6d0a76bc160d)

In the DisplayLedger class, users can display all transactions, filter by deposits or payments, and choose to return to the home screen or proceed to a report screen.

![DisplayLedger Options](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/bc372ed4-48dd-47c0-bcd0-1275e8c3ebe6)

Here are the methods available in the DisplayLedger class.

![DisplayLedger Methods](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/a67143c1-ee48-4443-8fc7-06176332113f)

Methods available include displayLedger, displayAll, displayDeposits, displayPayments, and newReports.

## New Reports

The newReports method provides predefined filters that users can apply to transactions. It utilizes a foreach loop to iterate through the HashMap and apply filters based on local date/time.

In the Ledger class, variables are defined, and a constructor is created for later use when printing data.

![Ledger Class](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/57ae5cde-a787-4728-9d20-fdbafb77d3f4)

![Ledger Constructor](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/3ba747e9-f1dc-486e-96f3-dae3779ab5ae)

The Reader class handles file reading, using file readers and buffered readers to read the CSV file and later use a buffered writer.

![Reader Class](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/3de35b7c-0809-4a6a-b902-87437a792789)

![Reader Methods](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/9c3821f2-c3dc-472b-8597-40e351fac205)

The main class coordinates all functions. In this example, only two classes are used, which handle the rest of the functionality.

![Main Class](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/426b4425-ae3c-43ac-bac9-eb4d2c028884)

## Application Screens

### Home Screen

![Home Screen](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/cc34c108-4ca8-40d0-92b0-319e517de2bd)

### Deposits

![Deposits](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/714b047c-6917-4eb4-a7c3-12488eaded78)

### Ledger Screen

![Ledger Screen](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/22ff1cf6-54c8-44e4-8f2b-dca497239b8f)

### Payments

![Payments](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/ce9c3a78-324a-4726-b15a-de40e8617a0a)

### Exit

![Exit](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/af86d8ac-6bd8-49b7-8978-fadb33799f78)

## Options

### Display All

![Display All](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/2523bf2d-a374-44b5-aa03-67174ae542c7)

After displaying all information, the user is returned to the Ledger Screen.

### Display Deposits

![Display Deposits](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/eb1ad599-abe5-49f7-865c-05ce58d584df)

This option displays only positive transactions, indicating deposits.

### Display Payments

![Display Payments](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/fb5e2bcc-81ca-45a7-8751-260cda1e8088)

This option displays only negative transactions, indicating payments.

### Reports

If the user chooses to go to a new screen, they are presented with the following menu:

![Reports](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/8a821b60-00b7-4bb7-8ac7-5e0bef7e27dc)

### Filter by Current Month

Option 1 outputs transactions from the start of the month to the current date:

![Current Month Filter](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/824871a8-6d86-4d13-8ee6-0f9afdeee870)

### Filter by Previous Month

Option 2 outputs transactions from the previous month:

![Previous Month Filter](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/a6d0fe34-abd8-4088-9b2a-94a586c7f9bc)

### Filter by Year to Date

Option 3 outputs transactions from the start of the year to the current date:

![Year to Date Filter](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/fdb432f3-2798-427d-b0fe-912979a4103f)

### Filter by Previous Year

Option 4 outputs transactions from the previous year:

![Previous Year Filter](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/2d75d1a0-53d3-4607-9157-fb526bd3ab9c)

### Search for a Vendor

Option 5 enables users to search for a specific vendor and display related transactions:

![Vendor Search](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/b5cd83df-3373-4c65-85d9-bd4ccbdc66af)

If a vendor is not found, users receive a notification:

![Vendor Not Found](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/ffc74550-6adc-4ac4-8615-293eb981465d)

These are the primary screens and options available in the Accounting Ledger App.

## Conclusion

Overall, this project has improved my skills in working with CSV files, HashMaps, and ArrayLists. I have enhanced my understanding of LocalDateTime and practiced working with collections like ArrayList. While not an expert, I find these tools practical and valuable.

One interesting piece of code is in the newReports method. In case 5, I implemented a vendor search, displaying matching transactions. It uses a boolean to track success and includes an "else if" to handle cases when no matches are found.

![Vendor Search](https://github.com/Joshua722/AccountingLedgerApp/assets/101982787/666b2cb0-b133-447f-81fe-d9e3b0d99d61)












