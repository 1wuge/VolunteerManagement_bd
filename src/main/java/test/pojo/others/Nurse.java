package test.pojo.others;

public class Nurse {
    private String name;
    private int id;
    private String sex;

    private String job;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String produce;

    private String room;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }


    public Nurse(int id,String name,  String sex, String job, String phone, String produce, String room) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.job = job;
        this.phone = phone;
        this.produce = produce;
        this.room = room;
    }
    public Nurse(String name, String sex, String job) {
        this.name = name;
        this.sex = sex;
        this.job = job;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }



    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", produce='" + produce + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
