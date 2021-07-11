/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marks;

/**
 *
 * @author Fares Abu Ali
 */
public class Student {

    String name;
    int age;
    Marks mark;
public Student(){
    
}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        //this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMark() {
        return "first= " + mark.getFirst() + ",second= " + mark.getSecond() + ",final= " + mark.getFinali() + ",avg= "
                + mark.getAvgGrade();
    }

//    public void setMark(Marks mark,double firstMark,double secondMark,double finalMark) {
//        mark.setFirst(firstMark);
//        mark.setSecond(secondMark);
//        mark.setFinali(finalMark);
//    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", mark=" + getMark() + '}';
    }

    
}
