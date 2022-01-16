//John Rosar
//COSC1437
//Lab6 part 2
//Student_Rosar.java
//Data class



import java.io.IOException;
import java.util.Scanner;
import java.io.File;



public class Student_Rosar {

	private String studentId;
	private String firstname;
	private String lastname;
	private float[] scores;

	// Mr. Constructor
	public Student_Rosar()
	{
		studentId= "";
		firstname = "";
		lastname = "";
		scores = new float[3];
		for(int i=0;i<scores.length;i++)
			scores[i] = 0;
	}

	public Student_Rosar(String studentId, String firstname, String lastname, float[] scores)
	{
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;                    	// Mrs. Parameterized 
		this.scores = new float[scores.length];
		for(int i=0;i<scores.length;i++)
			this.scores[i] = scores[i];
	}

	// Methods and Methods, Method Madness
	public float totalScore()
	{
		float total = 0;
		for(int i=0;i<scores.length;i++)
			total += scores[i];

		return total;
	}

	public float percent()
	{
		return (totalScore()*100)/(100*scores.length);
	}

	public String letterGrade()
	{
		float grade = percent(); 
		if(grade >= 90)
			return "A";
		else if(grade >= 80)
			return "B";
		else if(grade >= 70)
			return "C";
		else if(grade >= 60)
			return "D";
		else
			return "F";
	}

	// to the string though
	public String toString()
	{
		return "\nFile name: StudentGradingResult_Rosar"+
				"\nSTUDENT GRADING APPLICATION - John Rosar"+
				"\n--------------------------------------------------"+"\n"+
				String.format("%-20s%30s", "Student ID:",studentId)+"\n"+
				String.format("%-20s%30s", "Student Name:",firstname+" "+lastname)+"\n"+
				String.format("%-20s%30s", "Total of Scores:", totalScore() +"/300")+"\n"+
				String.format("%-20s%29.2f%s", "Percentage:",percent(),"%")+"\n"+
				String.format("%-20s%30s", "Letter Grade:",letterGrade());
	}
	public static void ReadDelimited() {
		    Scanner sc = null;
		    try {
		      sc = new Scanner(new File("studentInfo.txt"));

		      while(sc.hasNextLine()){
		        String str = sc.nextLine();
		        parseData();
		        return;
		      }
		    } catch (IOException  exp) {
		    	System.out.println("Error has occurred");
		    	exp.printStackTrace();
		    }
		    if(sc.nextLine() == null)
		        sc.close();
	}
		    

		public static  void parseData() {
					String ID, Fname, Lname, Grade, Letter;
				    Scanner sc = new Scanner("studentInfo.txt");
				    sc.useDelimiter("-");
				    while(sc.hasNext()){
				    	ID = sc.next();
				    	Lname = sc.next();
				    	Fname = sc.next();
				    	Grade = sc.next();
				    	Letter = sc.next();
				    	System.out.printf("File name: StudentGradingResult_Rosar.java");
				    	System.out.printf("STUDENT GRADING APPLICATION - John Rosar");
				    	System.out.printf("--------------------------------------------------");
						System.out.printf("%-20s%30s", "Student ID:",ID);
						System.out.printf("%-20s%30s", "Student Name:",Fname+" "+Lname);
						System.out.printf("%-20s%29.2f%s", "Percentage:",Grade,"%");
						System.out.printf("%-20s%30s", "Letter Grade:",Letter);  
						return;
				    }
				    sc.close();
		}}
		