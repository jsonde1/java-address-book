# Domain Models, Class Diagrams and Test Plan
# Domain Models and Test Plan

### User Story 1

- As a User, I want to be able to add a contact to address book, so I can access their contact details easily

**Test Plan**

1. addContact should successfully add a contact object to AddressBook when given Object ✔
2. Contact object should successfully be created when given valid input ✔
3. Contact object should successfully be created when given valid extreme input ✔
4. Contact object should not be added when Validator throws error ✔
5. Validator should throw exception when one parameter is empty ✔
6. Validator should throw exception if name input is invalid ✔
7. Validator should throw exception if extreme name input is invalid ✔
8. Validator should throw exception if name input is empty ✔
9. Validator should throw exception if phoneNumber input is invalid ✔
10. Validator should throw exception if extreme phoneNumber input is invalid ✔
11. Validator should throw exception if phoneNumber input is empty ✔
12. Validator should throw exception if email input is invalid ✔
13. Validator should throw exception if extreme email input is invalid ✔
14. Validator should throw exception if email input is empty ✔
<br>

### User Story 2

-   As a user, I want to be able to search for a contact by name, so I can find their details easily

**Test Plan**

1. searchByName should successfully return contacts that match the valid parameter ✔
2. searchByName should successfully return contacts that match extreme valid parameter ✔
3. searchByName should return empty if no matches where found ✔

<br>

### User Story 3

- As a User, I want to be able to remove a contact from my address book, so i no longer have their details saved


**Test Plan**

1. deleteContact removes contact when given existing number ✔
2. deleteContact should do nothing when given number not in Address Book ✔

<br>

### User Story 4

- As a User, I want to be able to edit a contact's details, so I can make changes where necessary


**Test Plan**

1. editContact should successfully call contact setters with valid parameters ✔
2. editContact should successfully call contact setters with valid extreme parameters ✔
3. editContact should successfully call contact setters if only one parameter is passed ✔
4. editContact should successfully call contact setters if only two parameters are passed ✔
5. editContact should do nothing if Validator returns false ✔
6. Validator should return true when one parameter is empty ✔
7. Validator should return true when two parameters are empty ✔
8. Validator should throw exception when all parameters are empty ✔


<br>

### User Story 5

- As a User, I do not want to be able to add a new contact with an existing phone number, so that I don't add the same person twice


**Test Plan**

1. Check that contact with existing number is not added to address book ✔


<br>

### User Story 6

- As a User, I do not want to be able to add a new contact with an existing email, so that I don't add the same person twice


**Test Plan**

1. Check that contact with existing email is not added to address book ✔

<br>

### User Story 7

- As a User, I want to be able to view all contacts in my address book, so i can view them all at the same time


**Test Plan**

1. Check that all contacts are returned by getAllContacts ✔
2. Check that empty array is return when no contacts in address book ✔
3. Check that no contacts are printed if AddressBook is empty ✔
4. Check that printContactsUI prints all contacts given ✔


**Additional Stories**

### User Story 8
- As a User, I want to delete all contacts at once, so that I can start afresh

**Test Plan**
1. Check UI returns true when user confirms
2. Check UI returns false when user doesn't confirm
3. Check UI returns false when user gives invalid input
4. Check addressbook deletes contacts when UI returns true
5. Check addressbook deletes contacts when addressbook is empty
6. Check addressbook doesn't delete contacts when UI returns true

**AI Documentation**
![Alt text](./img/AI_Delete01.png?raw=true "AI documentation of delete all")
![Alt text](./img/AI_Delete02.png?raw=true "AI documentation of delete all")

<br>

### User Story 9
- As a User, I want to search for contacts by email, so that I can find contacts via their email

**Test Plan**
1. Check Search by email returns matching contacts
2. check search by email returns empty when no matching contacts found
3. check search by email handles empty input correctly
4. check search by email is case-insensitive
5. check search by email returns partial matches

**AI Documentation**
![Alt text](./img/AI_EmailSearch01.png?raw=true "AI documentation of email search")
![Alt text](./img/AI_EmailSearch02.png?raw=true "AI documentation of email search")

### User Story 10
- As a User, I want to search for contacts by Phone Number, so that I can find contacts via their phone Number

**Test Plan**
1. Check Search by phone returns matching contacts
2. check search by phone returns empty when no matching contacts found
3. check search by phone handles empty input correctly
4. check search by phone returns partial matches


**AI Documentation**
![Alt text](./img/AI_PhoneSearch01.png?raw=true "AI documentation of phone search")
![Alt text](./img/AI_PhoneSearch02.png?raw=true "AI documentation of phone search")

### User Story 11
- As a User, I want to have results displayed in Alphabetical Order, so that I can find contacts easier

**Test Plan**
1. Check Search by phone returns contacts in alphabetical order
2. Check Search by name returns contacts in alphabetical order
3. Check Search by email returns contacts in alphabetical order


**AI Documentation**
![Alt text](./img/AL_Alpha01.png?raw=true "AI documentation of alphabetical sort")
![Alt text](./img/AI_Alpha02.png?raw=true "AI documentation of alphabetical sort")
![Alt text](./img/AI_Alpha03.png?raw=true "AI documentation of alphabetical sort")

### Kanban Board 
![Alt text](./img/Kanban.png?raw=true "Kanban Board")

### Class Diagram
![Alt text](./img/Class_Diagram.png?raw=true "Class Diagram")