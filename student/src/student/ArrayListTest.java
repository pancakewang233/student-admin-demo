package student;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    ArrayList<Students> array = new ArrayList<Students>();
    String[] Menu = new String[]{"1.添加学生", "2.删除学生", "3.修改学生", "4.查看所有学生", "5.退出"};
    Scanner sc = new Scanner(System.in);
    int choice;

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();

        arrayListTest.inMenu();
    }

    public void inMenu() {
        System.out.println("------欢迎来到学生管理系统------");

        for (int i = 0; i < Menu.length; i++) {
            System.out.println(Menu[i]);
        }

        Students s1 = new Students("风清扬", 66);
        Students s2 = new Students("逍遥子", 55);
        Students s3 = new Students("令狐冲", 22);
        array.add(s1);
        array.add(s2);
        array.add(s3);
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
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();

        Students s = new Students(name, age);
        array.add(s);
        printCircle();
    }

    public void deleteStudent() {
        printCircle();
        System.out.println("请输入要删除学生的序号");
        int index = sc.nextInt();
        array.remove(index);
        printCircle();
    }

    public void updateStudent(){
        printCircle();
        System.out.println("请输入要修改学生的序号");
        int index = sc.nextInt();
        System.out.println("请输入修改后学生的姓名");
        String name = sc.next();
        System.out.println("请输入修改后学生的年龄");
        int age = sc.nextInt();
        array.get(index).setName(name);
        array.get(index).setAge(age);
        printCircle();
    }

    public void printCircle() {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(i + "." + array.get(i).getName() + ", " + array.get(i).getAge());
        }
    }
}
