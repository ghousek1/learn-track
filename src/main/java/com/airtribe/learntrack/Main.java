package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMainMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> studentMenu(sc);
                case "2" -> courseMenu(sc);
                case "3" -> enrollmentMenu(sc);
                case "0" -> {
                    System.out.println("Exiting application");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println();
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private static void studentMenu(Scanner sc) {
        System.out.println();
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        System.out.print("Choose option: ");

        String option = sc.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("First name: ");
                    String fn = sc.nextLine();

                    System.out.print("Last name: ");
                    String ln = sc.nextLine();

                    System.out.print("Email (optional): ");
                    String email = sc.nextLine();

                    System.out.print("Batch: ");
                    String batch = sc.nextLine();

                    Student s = email.isBlank()
                            ? studentService.addStudent(fn, ln, batch)
                            : studentService.addStudent(fn, ln, email, batch);

                    System.out.println("Created student with ID " + s.getId());
                }
                case "2" -> {
                    for (Student s : studentService.listStudents()) {
                        System.out.println(s.getId() + " | " + s.getDisplayName() + " | active=" + s.isActive());
                    }
                }
                case "3" -> {
                    System.out.print("Student ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Student s = studentService.findById(id);
                    System.out.println(s.getDisplayName() + " | batch=" + s.getBatch());
                }
                case "4" -> {
                    System.out.print("Student ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    studentService.updateStudent(id, null, false);
                    System.out.println("Student deactivated");
                }
                default -> System.out.println("Invalid option");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void courseMenu(Scanner sc) {
        System.out.println();
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Activate / Deactivate Course");
        System.out.print("Choose option: ");

        String option = sc.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("Course name: ");
                    String name = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Duration (weeks): ");
                    int weeks = Integer.parseInt(sc.nextLine());

                    Course c = courseService.addCourse(name, desc, weeks);
                    System.out.println("Created course with ID " + c.getId());
                }
                case "2" -> {
                    for (Course c : courseService.listCourses()) {
                        System.out.println(c.getId() + " | " + c.getCourseName() + " | active=" + c.isActive());
                    }
                }
                case "3" -> {
                    System.out.print("Course ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Course c = courseService.findById(id);
                    c.setActive(!c.isActive());
                    System.out.println("Course status updated");
                }
                default -> System.out.println("Invalid option");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void enrollmentMenu(Scanner sc) {
        System.out.println();
        System.out.println("1. Enroll Student");
        System.out.println("2. View Student Enrollments");
        System.out.println("3. Update Enrollment Status");
        System.out.print("Choose option: ");

        String option = sc.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(sc.nextLine());
                    System.out.print("Course ID: ");
                    int cid = Integer.parseInt(sc.nextLine());

                    Enrollment e = enrollmentService.enrollStudent(sid, cid);
                    System.out.println("Enrollment created with ID " + e.getId());
                }
                case "2" -> {
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(sc.nextLine());
                    List<Enrollment> list = enrollmentService.getEnrollmentsByStudent(sid);
                    for (Enrollment e : list) {
                        System.out.println(
                                e.getId() + " | course=" + e.getCourseId() + " | " + e.getStatus()
                        );
                    }
                }
                case "3" -> {
                    System.out.print("Enrollment ID: ");
                    int eid = Integer.parseInt(sc.nextLine());
                    System.out.print("Status (ACTIVE / COMPLETED / CANCELLED): ");
                    String status = sc.nextLine();

                    enrollmentService.updateStatus(
                            eid,
                            EnrollmentStatus.valueOf(status)
                    );

                    System.out.println("Enrollment updated");
                }
                default -> System.out.println("Invalid option");
            }
        } catch (Exception e) {
            System.out.println("Invalid input or operation failed");
        }
    }




}
