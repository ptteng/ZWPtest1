package model;

public class Student {
    private long id;
    private String name;
    private String major;
    private String school_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public Student(String name, String major, String school_id) {
        super();
        this.name = name;
        this.major = major;
        this.school_id = school_id;
    }
    public Student(String name, String major, String school_id,long id) {
        super();
        this.name = name;
        this.major = major;
        this.school_id = school_id;
        this.id=id;

    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", school_id='" + school_id + '\'' +
                '}';
    }
}