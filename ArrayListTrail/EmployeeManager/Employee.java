package EmployeeManager;

public class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;
    private int experiance;

    public Employee() {
    }

    public Employee(String id, String name, String position, double salary, int experiance) {
        setExperiance(experiance);
        setId(id);
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    // Intern, Developer, Tester, Manager, HR(Human resources)
    public void setPosition(String position) {
        if (position == null || position.isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty.");
        }
        position = position.trim();
        if (!position.equalsIgnoreCase("Intern")
                && !position.equalsIgnoreCase("Developer")
                && !position.equalsIgnoreCase("Tester")
                && !position.equalsIgnoreCase("Manager")
                && !position.equalsIgnoreCase("HR (Human resources)")) {
            throw new IllegalArgumentException(
                    "Invalid position. Allowed values: Intern, Developer, Tester, Manager, HR(Human resources)");
        }
        if (position.equalsIgnoreCase("Intern")) {
            this.position = "Intern";
        } else if (position.equalsIgnoreCase("Developer")) {
            this.position = "Developer";
        } else if (position.equalsIgnoreCase("Tester")) {
            this.position = "Tester";
        } else if (position.equalsIgnoreCase("Manager")) {
            this.position = "Manager";
        } else {
            this.position = "HR (Human resources)";
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must >= 0");
        }
        this.salary = salary;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        if (experiance < 0) {
            throw new IllegalArgumentException("Experiance must >= 0");
        }
        this.experiance = experiance;
    }

    @Override
    public String toString() {
        return "Employee [id = " + id + ", name = " + name + ", position = " + position + ", salary = " + salary
                + ", experiance (year) = " + experiance + "]";
    }
}
