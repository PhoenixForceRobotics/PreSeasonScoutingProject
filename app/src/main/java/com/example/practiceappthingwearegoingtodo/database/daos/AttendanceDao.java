package com.example.practiceappthingwearegoingtodo.database.daos;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.practiceappthingwearegoingtodo.database.entities.Attendance;

import java.util.List;

@Dao
public interface AttendanceDao {
    @Query("SELECT * FROM attendance_table")
    List<Attendance> getAllInfo();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Attendance attendance);


    @Query("DELETE FROM attendance_table")
    void nukeTable();




}
