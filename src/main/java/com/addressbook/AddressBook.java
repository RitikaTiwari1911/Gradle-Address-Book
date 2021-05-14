package com.addressbook;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    class ContactCategories {
        Scanner input = new Scanner(System.in);
        //can store multiple contact details
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();
        ArrayList<String> emailId = new ArrayList<>();
        ArrayList<Integer> zipCode = new ArrayList<>();
        ArrayList<Integer> phoneNumber = new ArrayList<>();


        //creating methods for various sub sections of the contact
        public String first_Name() {
            System.out.print("Enter the first name: ");
            String firstNameInput = input.next();
            boolean duplicateNameCheck = checkDuplicate(firstNameInput);
            if (duplicateNameCheck == true)
                System.out.println("The name already exists!");
            return firstNameInput;
        }

        public String last_Name() {
            System.out.print("Enter the last name: ");
            String lastNameInput = input.next();
            return lastNameInput;
        }

        public String address_() {
            System.out.print("Enter the address");
            String addressInput = input.next();
            return addressInput;
        }

        public String city_Name() {
            System.out.print("Enter the name of the city: ");
            String cityInput = input.next();
            return cityInput;
        }

        public String state_Name() {
            System.out.print("Enter the name of the state: ");
            String stateInput = input.next();
            return stateInput;
        }

        public String email_Id() {
            System.out.print("Enter the email id: ");
            String emailIdInput = input.next();
            return emailIdInput;
        }

        public int zip_Code() {
            System.out.print("Enter the zip code: ");
            int zipInput = input.nextInt();
            return zipInput;
        }

        public int phone_Number() {
            System.out.print("Enter the phone number: ");
            int phoneNumberInput = input.nextInt();
            return phoneNumberInput;
        }

        //Ability to add new contact to Address Book
        public void addPersonContactDetail() {
            System.out.println("Add a new person in the Address Book");
            firstName.add(first_Name());
            lastName.add(last_Name());
            address.add(address_());
            city.add(city_Name());
            state.add(state_Name());
            emailId.add(email_Id());
            zipCode.add(zip_Code());
            phoneNumber.add(phone_Number());
        }


        //Ability to edit the details of the contact
        public void editDetails() {
            System.out.println("Enter the name of the contact you want to edit");
            String editName = input.next();
            int firstNameIndex = firstName.indexOf(editName);
            int pos = firstNameIndex;
            if (firstName.contains(editName)) {

                firstName.set(pos, first_Name());
                lastName.set(pos, last_Name());
                address.set(pos, address_());
                city.set(pos, city_Name());
                state.set(pos, state_Name());
                emailId.set(pos, email_Id());
                zipCode.set(pos, zip_Code());
                phoneNumber.set(pos, phone_Number());

                System.out.println("Contact added successfully");
            } else {
                System.out.println("The name does not exist !!");
            }
        }

        //Ability to delete a contact detail
        public void deleteDetails() {
            System.out.println("Enter the name of the contact you want to delete: ");
            String deleteName = input.next();
            int firstNameIndex = firstName.indexOf(deleteName);
            int pos = firstNameIndex;
            if (firstName.contains(deleteName)) {
                firstName.remove(pos);
                lastName.remove(pos);
                address.remove(pos);
                city.remove(pos);
                state.remove(pos);
                emailId.remove(pos);
                zipCode.remove(pos);
                phoneNumber.remove(pos);

                System.out.println("Contact detail has been successfully deleted !!");
            } else {
                System.out.println("The name does not exist!!");
            }
        }

        // Ability to display the contact details
        public void displayDetails() {
            System.out.println("First Name: " + firstName + " Last Name: " + lastName + " Address: " + address + " State: " + city + " City: "
                    + state + " Zip Code: " + zipCode + " Phone Number: " + phoneNumber + " Email Id:  " + emailId);
        }

        //method to prevent any duplicate name
        public boolean checkDuplicate(String name) {
            if (firstName.contains(name))
                return true;
            else
                return false;
        }

        //method to search names by city
        public void searchByCity() {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter city name :");
            String cityName = userInput.nextLine();

            for (String city : city) {
                if (city.contains(cityName)) {
                    System.out.println(firstName);
                }
            }
        }

        //method to search names by state
        public void searchByState() {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter State name :");
            String stateName = userInput.nextLine();

            for (String state : state) {
                if (city.contains(stateName)) {
                    System.out.println(firstName);
                }
            }
        }

        //method to write into the CSV file
        public void writeToFile() throws IOException {
            try {
                FileOutputStream fileData = new FileOutputStream;
                ObjectOutputStream writeStream = new ObjectOutputStream(fileData);
                writeStream.writeObject(firstName);
                writeStream.writeObject(lastName);
                writeStream.flush();
                writeStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void readFromFile()throws IOException {
            try {
                FileInputStream file = new FileInputStream("C:\\Users\\RITIKA\\IdeaProjects\\Address Book Gradle\\Address Book Data.txt");
                ObjectInputStream readStream = new ObjectInputStream(file);
                ArrayList<ContactCategories> co = (ArrayList<ContactCategories>) readStream.readObject();
                readStream.close();
                System.out.println(co.toString());

            }catch(FileNotFoundException e) {
                System.out.println("File does not exists!!");
            }catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        // Ability to provide user with various options
        public void options() {
            while (true) {
                System.out.println("========================================\n Enter 1 to add new contact \n Enter 2 to add edit contact \n " +
                        "Enter 3 to delete a contact \n  \n Enter 4 to search person by city \n Enter 5 to search person by state \n "
                        +"Enter 6 for writing into the file \n Enter 7 to read from the file"+ "Enter 8 to exit the address book " +
                        "\n=======================================");
                int chooseOption = input.nextInt();
                switch (chooseOption) {
                    case 1:
                        //Ability to add new contact
                        addPersonContactDetail();
                        break;

                    case 2:
                        editDetails();
                        break;

                    case 3:
                        deleteDetails();
                        break;

                    case 4:
                        searchByCity();
                        break;

                    case 5:
                        searchByState();
                        break;

                    case 6:
                        try {
                            writeToFile();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            readFromFile();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;

                    case 8:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter the correct option!!");
                        break;
                }
                displayDetails();
            }
        }

    }

    //main method
    public class AddressBook {
        public static void main(String args[]) {
            System.out.println("Welcome to the Address Book !!");
            ContactCategories contactCategories = new ContactCategories();
            contactCategories.addPersonContactDetail();
            contactCategories.options();
        }
    }

