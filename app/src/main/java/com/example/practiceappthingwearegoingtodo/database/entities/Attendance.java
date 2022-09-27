package com.example.practiceappthingwearegoingtodo.database.entities;


import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;

@Entity (tableName = "attendance_table")
public class Attendance {
    public Attendance(@NonNull String Student, String day, String month, String year, Boolean here) {

        this.Student = Student;
        this.PassWord = PassWord;


    }



        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "Student")
        private String Student;


        @ColumnInfo(name = "PassWord")
        private String PassWord;

        //for some reason having password be PriKey orders the data right.


        public String getStudent() {
            return Student;
        }

        public void setStudent(String User) {
            this.Student = User;
        }


        public String getPassWord() {return PassWord;}

        public void setPassWord(String User) {this.PassWord = PassWord;}




}
