//John Rosar
//COSC1437
//Lab6 part 2
//SU2021_StudentGradingApplication_Rosar.java
//Driver class



import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class SU2021_StudentGradingApplication_Rosar {

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String studentID, firstname, lastname;
		float scores[] = new float[3];
		int option = 0;
		Student_Rosar student;
		


		// I did a switch
		do
		{
			System.out.println("SU21_StudentGradingApplication_Rosar.java");
			System.out.println("GRADING MENU - JOHN ROSAR");
			System.out.println("--------------------------------------------------------");
			System.out.println("1. Enter Student data");
			System.out.println("2. Display the Grade of Class");
			System.out.println("0. Exit");
			System.out.print("Enter your option: ");
			option = sc.nextInt();

			switch (option) {
			case 1: // enter student data
			
				System.out.print("Student ID: ");
				studentID = sc.next();
				System.out.print("Firstname: ");
				firstname = sc.next();
				System.out.print("Lastname: ");
				lastname = sc.next();
				System.out.print("Scores for 3 assignments(max 100): ");
				for(int i=0;i<scores.length;i++)
					scores[i] = sc.nextFloat();
				float total = 0;
				for(int i=0;i<scores.length;i++)
					total += scores[i];
				float percent;
				percent = total/3;
				String grade;
				if(percent >= 90)
					grade = "A";
				else if(percent >= 80)
					grade = "B";
				else if(percent >= 70)
					grade = "C";
				else if(percent >= 60)
					grade = "D";
				else
					grade = "F";
				
				// create Student_Rosar object
				student = new Student_Rosar(studentID, firstname, lastname, scores);
				System.out.println(student); // display the student information
				FileWriter fwriter = new FileWriter("studentInfo.txt", true);
				PrintWriter outputFile = new PrintWriter(fwriter);
				outputFile.println("\n" + studentID + "-" + lastname + "-" + firstname + "-" + percent + "-" + grade + " ");
				fwriter.flush();
				outputFile.close();
				System.out.println();

				break;
			

			case 2:
			
				String line;

				System.out.println("SU21_StudentGradingApplication_Rosar.java");

				System.out.println("LIST OF CLASS GRADES – John Rosar");

				System.out.println("--------------------------------------------------------");

				try{


					BufferedReader br = new BufferedReader(new FileReader("studentInfo.txt"));

					while ((line = br.readLine()) != null) {

						String result[] = line.split("-");

						System.out.printf("%s%22s", "Student ID:", result[0]+"\n");
						System.out.printf("%s%20s", "Student Name:", result[2]+" "+result[1]+"\n");
						System.out.printf("%s%20.2s", "Percentage:",result[3]);
						System.out.print("%");
						System.out.println();
						System.out.printf("%s%20s", "Letter Grade:",result[4]+"\n");
						System.out.println("--------------------------------------------------------");

					

					}


				}catch(IOException e) {
					System.out.println("Error, Invalid selection.");
					e.printStackTrace();

				}

			}

		}while(option != 0);
		System.out.println("Goodbye!");
	}
}



