package test.others;



/******************************************************************************

Given a sorted array arr[] of size N, the task is to remove the duplicate elements from the array.

Examples: 

Input: arr[] = {2, 2}
Output: arr[] = {2,null}
Explanation: All the elements are 2, So only keep one instance of 2.

Input: arr[] = {1, 2, 2, 3, 4, 4 }
Output: arr[] = {1, 2, 3, 4,null,null}

*******************************************************************************/
public class RemoveDuplicatesFromSortedArray
{
	public static void main(String[] args) {
// 		int arr[] = { 1, 2, 2, 2, 3, 4, 4, 4, 5, 5 };
		int arr[] = {1, 2, 2, 3, 4, 4 };
        int n = arr.length;
 
        // removeDuplicates() returns new size of array
        n = removeDuplicates(arr, n);
 
        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
	}
	static int removeDuplicates(int arr[], int n){
// Input: arr[] =  {1, 2, 2, 3, 4, 4 }
// Output: arr[] = {1, 2, 3, 4,null,null}
	   // when found dub stop loc keep going till no dublicate
	    int loc = 0;
	    boolean isFundDup = false;
	    
	    
	    
	    for(int i=0; i < n-1 ; i++ ) {
	        if(arr[i] == arr[i+1] && !isFundDup) {
	           // shift
                System.out.println(arr[loc] + " shifted " +arr[i+1]);
               
               loc = i+1; 
               isFundDup = true;
	        }
	        else{
	                        System.out.println(loc + " loc ");
                isFundDup = false;
	            arr[loc] = arr[i+1];
	            
	        }
	    }
	    return loc;
	    
	}
	

}

/*

Consider the following program to insert values into HashSet. 

class Student {
    public int id;
    public String name;

    public Student(String name, int id) {
        this.name = name; 
        this.id = id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());
    }

    public boolean equals(Object o) {
        if (o instanceof Student) {
           Student s = (Student) o;
           return s.id == this.id ? true : false;
        }
        return false;
    }
}

public class UpdateHashSet {

    public static void main(String[] args) {
    HashSet<Student> studentList = new HashSet<>();

    Student st1 = new Student("Nimit", 1);
    Student st2 = new Student("Rahul", 3);
    Student st3 = new Student("Nimit", 2);
    studentList.add(st1);
    studentList.add(st2);
    studentList.add(st3);

    System.out.println(studentList.size()); //3

    st1.id = 3;
    System.out.println(studentList.size()); // 3
   }
}

What will be the output?






Design entities and behavior for File System. Expose a method to calculate the size of the any entity in the file system. You are expected to give interfaces, classes, hierarchy between classes.


Root -> folder1 -> cf1


Interface File {
	long id;
	String name;
	Date createdAt;

	onDoubleClic();
}

class Folder implements File {
	Icon icon;

	onDoubleClic();

} 

class PFDFile implements File {
	Application openBy;	

} 




Class Singleton {

	private final int value;
	
	private Singleton s;

	private Siglton(int value) {
		this.value = value;
	}

	static Singleton getSiglton() {		if(s != null) {
			synchronised{
	
				s = new Singleton(10);
			}
		
		}
		
		return s;
	}

}


/*
Table Name : Student

Column : Name, Subject, Marks

Rama Math 50
Rama Physics 60
Rama English 45
Hari Math 70
Hari Physics 65
Hari English 85
Gita Math 90
Gita Physics 55
Gita English 80

Expected Output: 
Gita 225
Hari 220
Rama  155

Print the Students In Notice board format.
 (i.e Calculate the Toal mark for an individual student,
 and print in descending order of total marks.)



select	name, sum(marks) totalMarks
From Student
Group by name
Order by totalMarks

 */




