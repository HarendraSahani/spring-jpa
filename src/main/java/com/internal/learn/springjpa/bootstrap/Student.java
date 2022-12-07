package com.internal.learn.springjpa.bootstrap;

public class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(String name,double cgpa,int id){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }



}
