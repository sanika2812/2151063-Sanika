Question 1: Student and Course Management
Write a Java program that implements the Student and Course classes. You should be able to create instances of these classes, set their attributes, and display their information. 
Additionally, implement a method to check if a course is full (reached its maximum capacity).
package java_assignment;
class Student {
    private String name;
    private int id;
  public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
    }
}
class Course {
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment = 0;
    public Course(String courseName, int maxCapacity) {
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;    }

    public String getCourseName() {
        return courseName;
    }
public boolean isCourseFull() {
        return currentEnrollment >= maxCapacity;
    }
    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Max Capacity: " + maxCapacity);
        System.out.println("Current Enrollment: " + currentEnrollment);
    }
}
public class Question1 {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 1);
        Course course1 = new Course("Math 101", 30);
        student1.displayInfo();
        course1.displayInfo();
        if (course1.isCourseFull()) {
            System.out.println("Course is full.");
        } else {
            System.out.println("Course is not full.");
        }
    }
}





















Question 2: Enrollment Management
Extend the program from Question 1 to include the Enrollment class and implement the ability to enroll a student in a course. Ensure that the program prevents enrolling a student in a course if it has reached its maximum capacity
package que2;
import java.util.ArrayList;
import java.util.List;
class Student {
    private int studentId;
    private String studentName;
    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Student Name: " + studentName;
    }
}
class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private List<Student> enrolledStudents;
    public Course(int courseId, String courseName, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }
    public int getCourseId() {
        return courseId;
    }    public String getCourseName() {
        return courseName;
    }
public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }
    public boolean enrollStudent(Student student) {
        if (!isFull()) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    @Override
    public String toString() {
        return "Course ID: " + courseId + 
        		", Course Name: " + courseName + 
        		", Enrolled Students: " + enrolledStudents.size() + "/" + maxCapacity;
    }
}
public class Question2 {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");
        Course course1 = new Course(101, "Java Programming", 1);
        boolean enrolled1 = course1.enrollStudent(student1);
        boolean enrolled2 = course1.enrollStudent(student2);
        boolean enrolled3 = course1.enrollStudent(student3);
        System.out.println(course1); 
        if (enrolled1) {
            System.out.println(student1.getStudentName() + " enrolled in " + course1.getCourseName());
        } else {
            System.out.println(student1.getStudentName() + " couldn't enroll in " + course1.getCourseName() + " (Course is full)");
        }

        if (enrolled2) {
            System.out.println(student2.getStudentName() + " enrolled in " + course1.getCourseName());
        } else {
            System.out.println(student2.getStudentName() + " couldn't enroll in " + course1.getCourseName() + " (Course is full)");
        }
        if (enrolled3) {
            System.out.println(student3.getStudentName() + " enrolled in " + course1.getCourseName());
        } else {
            System.out.println(student3.getStudentName() + " couldn't enroll in " + course1.getCourseName() + " (Course is full)");
        }
    }
}








Question 3: CollegeManager Implementation
Create a CollegeManager class that utilizes the Student, Course, and Enrollment classes to manage the college system. Implement methods in the CollegeManager class to:
• Add students to the system.
• Add courses to the system.
• Enroll students in courses.
• Display the list of students enrolled in a particular course.
• Display the list of courses a student is enrolled in

package que3;
import java.util.ArrayList;
import java.util.List;
class Student {
    private String name;
    private int id;
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
    }
}
class Course {
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment = 0;
    public Course(String courseName, int maxCapacity) {
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
    }
    public String getCourseName() {
        return courseName;
    }
    public boolean isCourseFull() {
        return currentEnrollment >= maxCapacity;
    }
    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Max Capacity: " + maxCapacity);
        System.out.println("Current Enrollment: " + currentEnrollment);
    }
    public void enrollStudent() {
        currentEnrollment++;
    }
}
class Enrollment {
    private Student student;
    private Course course;
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    public Student getStudent() {
        return student;
    }
    public Course getCourse() {
        return course;
    }
}
public class Question3 {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        if (courses.contains(course) && !course.isCourseFull()) {
            Enrollment enrollment = new Enrollment(student, course);
            enrollments.add(enrollment);
            course.enrollStudent();
            System.out.println(student.getName() + " has been enrolled in " + course.getCourseName());
        } else if (!courses.contains(course)) {
            System.out.println("Course not found.");
        } else {
            System.out.println("Course is full. Cannot enroll " + student.getName());
        }
    }
    public void displayStudentsInCourse(Course course) {
        System.out.println("Students enrolled in " + course.getCourseName() + ":");
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse() == course) {
                System.out.println(enrollment.getStudent().getName());
            }
        }
    }
    public void displayCoursesForStudent(Student student) {
        System.out.println("Courses enrolled by " + student.getName() + ":");
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent() == student) {
                System.out.println(enrollment.getCourse().getCourseName());
            }
        }
    }
    public static void main(String[] args) {
        Question3 collegeManager = new Question3();
        Student student1 = new Student("Alice", 1);
        Student student2 = new Student("Bob", 2);
        Course course1 = new Course("Math 101", 30);
        Course course2 = new Course("Physics 101", 25);
        collegeManager.addStudent(student1);
        collegeManager.addStudent(student2);
        collegeManager.addCourse(course1);
        collegeManager.addCourse(course2);
        collegeManager.enrollStudentInCourse(student1, course1);
        collegeManager.enrollStudentInCourse(student2, course1);
        collegeManager.enrollStudentInCourse(student1, course2);
        collegeManager.displayStudentsInCourse(course1);
        collegeManager.displayCoursesForStudent(student1);
    }
}
