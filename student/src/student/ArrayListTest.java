package student;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    ArrayList<Students> array = new ArrayList<>();
    String[] Menu = new String[]{"1.添加学生", "2.删除学生", "3.修改学生", "4.查看所有学生", "5.退出"};
    Scanner sc = new Scanner(System.in);
    int choice;
    int index = -1;
    boolean canUsed = true;

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();

        arrayListTest.inMenu();
    }

    public void inMenu() {
        System.out.println("------欢迎来到学生管理系统------");

        for (int i = 0; i < Menu.length; i++) {
            System.out.println(Menu[i]);
        }

        Students s1 = new Students("风清扬", 66, "ali001");
        Students s2 = new Students("逍遥子", 55, "ali002");
        Students s3 = new Students("令狐冲", 22, "ali006");
        if (array.size() == 0) {
            array.add(s1);
            array.add(s2);
            array.add(s3);
        }
        System.out.println("请输入你的选择：");
        choice = sc.nextInt();

        if (choice == 1) {
            addStudent();
        } else if (choice == 2) {
            deleteStudent();
        } else if (choice == 3) {
            updateStudent();
        } else if (choice == 4) {
            printCircle();
        } else if (choice == 5) {
            return;
        } else {
            System.out.println("输入有误，请输入1-5的整数。");
        }
    }

    public void addStudent() {
        String sid;
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.next();
            searchStudent(sid);
            System.out.println("what the fuck" + canUsed);
            if (canUsed) {
                break;
            } else {
                System.out.println("该学号已存在，请重新输入");
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();

        Students s = new Students(name, age, sid);
        array.add(s);
        System.out.println("添加成功");

        inMenu();
    }

    public void deleteStudent() {
        while(true){
            System.out.println("请输入要删除学生的学号");
            String sidIndex = sc.next();
            searchStudent(sidIndex);
            if(canUsed){
                System.out.println("该信息不存在，请重新输入");
            }else{
                array.remove(index);
                System.out.println("删除成功");
                break;
            }
        }

        inMenu();
    }

    public void updateStudent() {

        System.out.println("请输入修改后学生的姓名");
        String name = sc.next();
        System.out.println("请输入修改后学生的年龄");
        int age = sc.nextInt();
        System.out.println("请输入修改后学生的学号");
        String sid = sc.next();
        array.get(index).setName(name);
        array.get(index).setAge(age);
        array.get(index).setSid(sid);
        System.out.println("修改成功");
        inMenu();
    }

    public void printCircle() {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).getName() + ", " + array.get(i).getAge() + "," + array.get(i).getSid());
        }
        inMenu();
    }

    public void searchStudent(String sid) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getSid().equals(sid)) {
                index = i;
                canUsed = false;
                break;
            }else{
                canUsed = true;
                index = -1;
            }
        }
    }
}
