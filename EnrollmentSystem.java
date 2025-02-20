import java.util.ArrayList;
import java.util.List;

public class EnrollmentSystem {
    private String courseName;
    private int maxEnrollment;
    private List<String> enrolledStudents;
    private List<String> prerequisites;

    public EnrollmentSystem(String courseName, int maxEnrollment, List<String> prerequisites) {
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new ArrayList<>();
        this.prerequisites = prerequisites;
    }

    public void enrollStudent(String studentName, List<String> completedCourses) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= maxEnrollment) {
            throw new CourseFullException("Course is full. Cannot enroll " + studentName);
        }
        for (String prerequisite : prerequisites) {
            if (!completedCourses.contains(prerequisite)) {
                throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + courseName);
            }
        }
        enrolledStudents.add(studentName);
        System.out.println(studentName + " has been enrolled in " + courseName);
    }

    public static void main(String[] args) {
        List<String> prerequisites = new ArrayList<>();
        prerequisites.add("Core Java");
        EnrollmentSystem course = new EnrollmentSystem("Advanced Java", 2, prerequisites);
        
        List<String> completedCourses = new ArrayList<>();
        try {
            course.enrollStudent("Alice", completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        completedCourses.add("Core Java");
        try {
            course.enrollStudent("Bob", completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
