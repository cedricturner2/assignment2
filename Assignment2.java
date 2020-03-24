import java.util.*;
import java.io.*;
public class Assignment2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the name of the file you want to open: ");
        String file = s.nextLine();

        File infile = new File(file);

        int semesterHours = 3; // or 4 but for this assignment we will use 3
        int totalNumCourses=3;
        Scanner input = new Scanner(System.in);
        String lastName, firstName, id;

        if ((!infile.exists())) {
            System.out.println("The file does not exist");
            System.exit(0);
        }




        do {
            System.out.println("Enter student's first name: ");
            firstName = input.next();
        }while(validateName(firstName)==false);
        do {
            System.out.println("Enter student's last name: ");
            lastName = input.next();
        }while(validateName(lastName)==false);
        do {
            System.out.println("Enter student ID number (PSID): ");
            id = input.next();
        }while(validateID(id)==false);

        System.out.println("Enter Grade 1: ");
        float grade1 = input.nextFloat();

        System.out.println("Enter Grade 2: ");
        float grade2 = input.nextFloat();

        System.out.println("Enter Grade 3: ");
        float grade3 = input.nextFloat();

        float gpaClass1, gpaClass2, gpaClass3;
        gpaClass1 = semesterHours * getGPA(grade1);
        gpaClass2 = semesterHours * getGPA(grade2);
        gpaClass3 = semesterHours * getGPA(grade3);

        float gpa = (gpaClass1+gpaClass2+gpaClass3)/(totalNumCourses*semesterHours);
        System.out.println("GPA: "+gpa);

        try {
           FileWriter content = new FileWriter(file);
           content.write(firstName + " " + lastName + " " + id);
           content.write(" " + grade1 + " " + grade2 + " " + grade3 + "GPA: " + gpa);

        }catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    static boolean validateName(String name){
        return name.matches("[a-zA-Z]+");
    }
    static boolean validateID(String PSID){
        if(PSID.length()==7 && PSID.matches("\\d+")) {
            return true;
        }
        return false;
    }
    static float getGPA(float grade) {
        if(grade>=93 && grade<=100){
            return (float)4.00;
        }
        else if(grade>=90 && grade<93) {
            return (float)3.67;
        }
        else if(grade>=87 && grade<90) {
            return (float)3.33;
        }
        else if(grade>=83 && grade <87){
            return (float)3.00;
        }
        else if(grade>=80 && grade<83){
            return (float)2.67;
        }
        else if(grade>=77 && grade<80){
            return (float)2.33;
        }
        else if(grade>=73 && grade<77){
            return (float)2.00;
        }
        else if(grade>=70 && grade<73) {
            return (float)1.67;
        }
        else if(grade>=67 && grade<70) {
            return (float)1.33;
        }
        else if(grade>=63 && grade<67) {
            return (float)1.00;
        }
        else if(grade<=60 && grade<63) {
            return (float)0.67;
        }
        return (float)0.00;
    }
}
