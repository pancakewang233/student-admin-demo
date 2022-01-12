package student;

public class Students {
    private String name;
    private int age;
    private String sid;

    public Students(String name, int age, String sid){
        this.name = name;
        this.age = age;
        this.sid = sid;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSid(String sid){
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSid(){
        return sid;
    }
}
