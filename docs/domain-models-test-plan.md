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

1. addContact should successfully add a contact object to AddressBook
<br>

### User Story 2

-   As a user, I want to be able to search for a contact by name, so i can find their details easily

**Domain Model**

| Object      | Properties              | Message               | Output |
|:------------|:------------------------|:----------------------|:-------|
| AddressBook | contacts@Array[Contact] | searchByName(@string) | @Array |
| Contact     | name@String             |                       |        |

**Test Plan**

1. searchByName should successfully return contacts that match the string parameter

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

1. Removes contact associated with phone number when removeContact is called

<br>

### User Story 4

- As a User, I want to be able to edit a contact's details, so I can make changes where necessary

**Domain Model**

| Object      | Properties    | Message             | Output |
| :---------- | :------------ | :------------------ | :----- |
|      | |  |   |

**Test Plan**

1. A Contacts Details should be successfully edited when edit contact details is called

<br>

### User Story 5

- As a User, I do not want to be able to add a new contact with a existing phone number, so that I don't add the same person twice

**Domain Model**

| Object      | Properties | Message          | Output |
| :---------- |:-----------|:-----------------|:-------|
|      |            |                  |        |

**Test Plan**

1. Check that contact with existing number is not added to address book


<br>

### User Story 6

- As a User, I do not want to be able to add a new contact with a existing email, so that I don't add the same person twice

**Domain Model**

| Object      | Properties    | Message            | Output |
| :---------- | :------------ |:-------------------| :----- |
|      |               |                    |  |


**Test Plan**

1. Check that contact with existing email is not added to address book

<br>

### User Story 7

- As a User, I want to be able to view all contacts in my address book, so i can view them all at the same time

**Domain Model**

| Object      | Properties    | Message                | Output |
| :---------- | :------------ | :--------------------- | :----- |
|      |               |  |  |

**Test Plan**

1. Check that all contacts are returned by addressBook
