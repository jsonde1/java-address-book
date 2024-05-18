# Domain Models, Class Diagrams and Test Plan
# Domain Models and Test Plan

### User Story 1

- As a User, I want to be able to add a contact to address book, so I can access their contact details easily
**Domain Model**

| Object      | Properties                                          | Message              | Output   |
|:------------|:----------------------------------------------------|:---------------------|:---------|
| AddressBook | contacts@Array[Contact]                             | addContact(@Contact) | @void    |
| Contact     | name@String<br/>email@String<br/>phoneNumber@String | constructor(@String) | @Contact |

**Test Plan**

1. addContact should successfully add a contact object to AddressBook when given Object ✔
2. Contact object should successfully be created when given valid input ✔
3. Contact object should successfully be created when given valid extreme input ✔
4. Contact object should not be created when Validator returns false
5. Contact object should not be created when parameters are missing
6. addContact should inform user that contact has been added
7. addContact should inform user that contact has not been added  
<br>

### User Story 2

-   As a user, I want to be able to search for a contact by name, so i can find their details easily

**Domain Model**

| Object      | Properties              | Message               | Output |
|:------------|:------------------------|:----------------------|:-------|
| AddressBook | contacts@Array[Contact] | searchByName(@string) | @Array |
| Contact     | name@String             |                       |        |

**Test Plan**

1. searchByName should successfully return contacts that match the valid parameter ✔
2. searchByName should successfully return contacts that match extreme valid paramter
3. searchByName should return null if no matches where found
4. searchByName should return null if Validator returns false

<br>

### User Story 3

- As a User, I want to be able to remove a contact from my address book, so i no longer have their details saved

**Domain Model**

| Object      | Properties              | Message                | Output |
|:------------|:------------------------|:-----------------------|:-------|
| AddressBook | contacts@Array[Contact] | removeContact(@String) | @Void  |
|             |                         |                        |        |
| Contact     |                         |                        |        |

**Test Plan**

1. deleteContact removes contact when given existing number ✔
2. deleteContact should do nothing when given number not in Address Book
3. deleteContact should do nothing when validator returns false
4. deleteContact should inform user when contact is Deleted
5. deleteContact should inform user when contact is not Deleted

<br>

### User Story 4

- As a User, I want to be able to edit a contact's details, so I can make changes where necessary

**Domain Model**

| Object      | Properties    | Message             | Output |
| :---------- | :------------ | :------------------ | :----- |
|      | |  |   |

**Test Plan**

1. editContact should successfully call contact setters with valid parameters ✔
2. editContact should successfully call contact setters with valid extreme parameters
3. editContact should successfully call contact setters if only one parameter is passed 
4. editContact should successfully call contact setters if only two parameters are passed
5. editContact should do nothing if Validator returns false

<br>

### User Story 5

- As a User, I do not want to be able to add a new contact with an existing phone number, so that I don't add the same person twice

**Domain Model**

| Object      | Properties | Message          | Output |
| :---------- |:-----------|:-----------------|:-------|
|      |            |                  |        |

**Test Plan**

1. Check that contact with existing number is not added to address book ✔


<br>

### User Story 6

- As a User, I do not want to be able to add a new contact with an existing email, so that I don't add the same person twice

**Domain Model**

| Object      | Properties    | Message            | Output |
| :---------- | :------------ |:-------------------| :----- |
|      |               |                    |  |


**Test Plan**

1. Check that contact with existing email is not added to address book ✔

<br>

### User Story 7

- As a User, I want to be able to view all contacts in my address book, so i can view them all at the same time

**Domain Model**

| Object      | Properties    | Message                | Output |
| :---------- | :------------ | :--------------------- | :----- |
|      |               |  |  |

**Test Plan**

1. Check that all contacts are returned by getAllContacts ✔
2. Check that no contacts are printed if AddressBook is empty 
3. Check that printContactsUI prints all contacts given ✔
