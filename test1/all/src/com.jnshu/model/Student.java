package model;

public class Student {
    private long id;
    private long create_time;
    private long update_time;
    private String name;
    private String major;
    private String school_id;

    //    ,long update_time,long create_time,long id
    public Student(long id,long create_time,long update_time,String name, String major) {
        this.id=id;
        this.create_time=create_time;
        this.update_time=update_time;
        this.name = name;
        this.major = major;
    }



    public Student() {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", school_id='" +school_id +'\''+
                '}';
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUpdate_time() {

        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public long getCreate_time() {

        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
