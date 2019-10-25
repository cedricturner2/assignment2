import java.util.Arrays;
import java.util.Scanner;

public class Student {

    String firstName;
    String lastName;
    String peopleSoft;
    String[] year = { "freshman", "sophomore", "junior", "senior" };
    String email;
    String classification;
    String address;
    String state;
    String states[] = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN",
            "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV",
            "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY" };
    String zipcode;

    public void getInfo() throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of the Student: ");

        String fName = sc.next();

        setFirstName(fName);

        System.out.println("Enter the Last Name of the Student: ");
        String lName = sc.next();
        setLastName(lName);

        System.out.println("Enter the peopleSoft ID: ");
        String id = sc.next();
        setPeopleSoftId(id);

        System.out.println("Enter classification (freshman, sophomore, junior, senior): ");
        String classStand = sc.next();
        setClassStanding(classStand);

        System.out.println("Enter Student Email: ");
        String mail = sc.next();
        sc.nextLine();
        setEmail(mail);

        System.out.println("Enter Address Line 1: ");
        String line1 = sc.nextLine();
        setAddress(line1);

        System.out.println("Enter State (Abbreviation format. ex: TX): ");
        String cityName = sc.next();
        setCity(cityName);

        System.out.println("Enter ZIP Code: ");
        String zip = sc.next();
        setZipcode(zip);

    }

    public void setFirstName(String firstName) throws Exception {

        if (firstName.matches("[a-zA-Z]+"))
            this.firstName = firstName;
        else
            throw new Exception("First Name contains Other than characters. It is not a valid name.");
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName.matches("[a-zA-Z]+"))
            this.lastName = lastName;
        else
            throw new Exception("First Name contains Other than characters. It is not a valid name.");
    }

    public void setPeopleSoftId(String peopleSoft) throws Exception {

        boolean flag = true;
        if (peopleSoft.length() <= 7) {
            for (int i = 0; i < peopleSoft.length(); i++) {
                if((peopleSoft.charAt(i)+"").matches("[0-9]"))
                    continue;
                else {
                    flag=false;
                    break;
                }
            }
        }

        else
            throw new Exception("ID length should be less than or equal to 7. ");

        if(flag==true)
            this.peopleSoft = peopleSoft;
        else
            throw new Exception("Id should contain only digits. ");
    }

    public void setClassStanding(String classification) throws Exception {

        boolean flag = false;

        for(int i=0;i<year.length;i++) {
            if(year[i].compareToIgnoreCase(classification)==0) {
                flag=true;
                break;
            }

            else
                continue;
        }
        if(flag==true)
            this.classification = classification;
        else
            throw new Exception("Value of class Standing should be in given values: "+Arrays.toString(year));
    }

    public void setEmail(String email) throws Exception {

        if(email.contains("@") && email.contains(".") )
            this.email = email;

        else
            throw new Exception("Email Should contain @ and '.' ");
    }

    public void setAddress(String address) throws Exception {

        if(address.contains(" "))
            this.address = address;
        else
            throw new Exception("Address Line 1 should contain Space between house number and Street name. ");
    }

    public void setCity(String city) throws Exception {
        boolean flag = false;

        for(int i=0;i<states.length;i++) {
            if(states[i].compareToIgnoreCase(city)==0) {
                flag=true;
                break;
            }

            else
                continue;
        }
        if(flag==true)
            this.state = state;
        else
            throw new Exception("Value of City Name should be in given values : "+Arrays.toString(states));
    }

    public void setZipcode(String zipcode) throws Exception {
        boolean flag = true;
        if (zipcode.length() == 9) {
            for (int i = 0; i < zipcode.length(); i++) {
                if((zipcode.charAt(i)+"").matches("[0-9]"))
                    continue;
                else {
                    flag=false;
                    break;
                }
            }
        }

        else
            throw new Exception("Zip Code length should be equal to 9.");

        if(flag==true)
            this.zipcode=zipcode;
        else
            throw new Exception("Zip Code should contain only digits.");
    }

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of students for which data to be entered: ");
        int N = scan.nextInt();

        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Details of student " + (i + 1) + ": ");
            Student student = new Student();
            try {
                student.getInfo();
                students[i] = student;
                count++;
            } catch (Exception e) {
                System.out.println(e);
                if (i > 0) {
                    System.out.println("Exiting program. Now displaying enrolled students ");
                    System.out.println();
                    System.out.println("Students Details, Department of ILT");
                    for (int j = 0; j < i; j++)
                        students[j].displayInfo();

                    System.out.println("Number of students: " + count);
                }

                System.exit(1);
            }

        }

        System.out.println("Students Details, Department of ILT");
        for (int i = 0; i < N; i++)
            students[i].displayInfo();

        System.out.println("Number of students: " + count);

    }

    public void displayInfo() {
        System.out.println("First Name: " + firstName + "\tLast Name: " + lastName + "\tPeopleSoft ID: "
                + peopleSoft + "\tClassification: " + classification + "\tEmail Address: " + email + "\tHome Address: " + address
                + "\tCity: " + state + "\tZip Code: " + zipcode);
        System.out.println("\n");

    }

}