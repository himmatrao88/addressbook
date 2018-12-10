# Addressbook

The application
Your application needs to read the attached AddressBook file and answer the following questions:
1.	How many males are in the address book?
2.	Who is the oldest person in the address book?
3.	How many days older is Bill than Paul?

# Underlying Assumptions and Notes

1. It is assumed that 'Name' would be unique in the address book. In case the name is repeated exactly, the first entry in the Address Book would be treated as a match.
2. In case of two persons having same DOB and if they are the oldest person in the whole Address Book, the first entry in the address book
being the oldest will be treated as the Oldest Person in Address Book.
3. Since this is a small problem set, instead of using Logger for errors etc., System.err.println has been used instead.
4. The File name and path (AddressBook i.e. Address.txt) could have been exposed as a outside configuration or driven by a properties file. But since this is a small problem set and focus is towards Code writing, it has been kept as a configuration at DAO layer and being set in Launch.java.

# Pre-requisite

1. Java 8
2.  Apache Maven 3+

To build the software: This will run the JUnit tests after the application has been built:
--	mvn package

To run the junits:
--	mvn test

To run the main class (for report generation):
--    mvn exec:java -Dexec.mainClass="com.gumtree.addressbook.Launch"

Author:
Himmat Rao
Email: himmatrao88@gmail.com


