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
        this.day = day;
        this.month =  month;
        this.year = year;
        this.here = here;


    }



        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "Student")
        private String Student;


        @ColumnInfo(name = "day")
        private String day;

        @ColumnInfo(name = "month")
        private String month;

        @ColumnInfo(name = "year")
        private String year;

        @ColumnInfo(name = "here")
        private Boolean here;




    //for some reason having password be PriKey orders the data right.


        public String getStudent() {
            return Student;
        }

        public void setStudent(String User) {
            this.Student = User;
        }


        public String getDay() {return day;}

        public void setDay(String day) {this.day = day;}

        public String getMonth() {return month;}

        public void setMonth(String month) {this.month = month;}

        public String getYear() {return year;}

        public void setYear(String year) {this.year = year;}

        public Boolean getHere() {return here;}

        public void setHere(Boolean here) {this.here = here;}


}
