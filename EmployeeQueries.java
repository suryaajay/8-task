import java.util.*;

class Employee {
    int empno;
    String ename;
    String job;
    Integer mgr;
    String hiredate;
    double sal;
    Double comm;
    int deptno;

    public Employee(int empno, String ename, String job, Integer mgr, String hiredate, double sal, Double comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}

public class EmployeeQueries {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(8369, "SMITH", "CLERK", 8902, "1990-12-18", 800.0, null, 20),
            new Employee(8499, "ANYA", "SALESMAN", 8698, "1991-02-20", 1600.0, 300.0, 30),
            new Employee(8521, "SETH", "SALESMAN", 8698, "1991-02-22", 1250.0, 500.0, 30),
            new Employee(8654, "MAHADEVAN", "MANAGER", 8698, "1991-04-02", 2985.0, null, 20),
            new Employee(8654, "MOMIN", "SALESMAN", 8698, "1991-09-28", 1250.0, 1400.0, 30),
            new Employee(8698, "BINA", "MANAGER", 8839, "1991-05-01", 2850.0, null, 30),
            new Employee(8839, "SHIVANSH", "MANAGER", 8698, "1991-06-09", 2450.0, null, 20),
            new Employee(8888, "SCOTT", "ANALYST", 8566, "1992-12-09", 3000.0, null, 20),
            new Employee(8839, "AMIR", "PRESIDENT", null, "1991-11-18", 5000.0, null, 10),
            new Employee(8844, "KULDEEP", "SALESMAN", 8698, "1991-09-08", 1500.0, 0.0, 30)
        ));

        // A. Salary >= 2200
        System.out.println("\nA) Employees with salary >= 2200:");
        for (Employee e : employees) {
            if (e.sal >= 2200) {
                System.out.println(e.ename + " - " + e.sal);
            }
        }

        // B. No commission
        System.out.println("\nB) Employees with no commission:");
        for (Employee e : employees) {
            if (e.comm == null || e.comm == 0.0) {
                System.out.println(e.ename);
            }
        }

        // C. Salary not between 2500 and 4000
        System.out.println("\nC) Employees with salary NOT between 2500 and 4000:");
        for (Employee e : employees) {
            if (!(e.sal >= 2500 && e.sal <= 4000)) {
                System.out.println(e.ename + " - " + e.sal);
            }
        }

        // D. Employees without manager
        System.out.println("\nD) Employees who don’t have a manager:");
        for (Employee e : employees) {
            if (e.mgr == null) {
                System.out.println(e.ename + " - " + e.job + " - " + e.sal);
            }
        }

        // E. Name with 'A' as third letter
        System.out.println("\nE) Employees with 'A' as the third letter in name:");
        for (Employee e : employees) {
            if (e.ename.length() >= 3 && e.ename.charAt(2) == 'A') {
                System.out.println(e.ename);
            }
        }

        // F. Name ending with 'T'
        System.out.println("\nF) Employees whose name ends with 'T':");
        for (Employee e : employees) {
            if (e.ename.endsWith("T")) {
                System.out.println(e.ename);
            }
        }
    }
}

// Output
A) Employees with salary >= 2200:
MAHADEVAN - 2985.0
BINA - 2850.0
SHIVANSH - 2450.0
SCOTT - 3000.0
AMIR - 5000.0

B) Employees with no commission:
SMITH
MAHADEVAN
BINA
SHIVANSH
SCOTT
AMIR
KULDEEP

C) Employees with salary NOT between 2500 and 4000:
SMITH - 800.0
ANYA - 1600.0
SETH - 1250.0
MOMIN - 1250.0
SHIVANSH - 2450.0
AMIR - 5000.0
KULDEEP - 1500.0

D) Employees who don?t have a manager:
AMIR - PRESIDENT - 5000.0

E) Employees with 'A' as the third letter in name:

F) Employees whose name ends with 'T':
SCOTT
