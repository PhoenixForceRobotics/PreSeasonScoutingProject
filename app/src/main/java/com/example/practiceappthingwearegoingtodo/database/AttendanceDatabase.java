package com.example.practiceappthingwearegoingtodo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.practiceappthingwearegoingtodo.database.daos.AttendanceDao;
import com.example.practiceappthingwearegoingtodo.database.entities.Attendance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Attendance.class} , version = 2, exportSchema = false)
public abstract class AttendanceDatabase extends RoomDatabase{

    private static volatile AttendanceDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 8;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final String DBNAME = "AttendanceDatabase";



    public abstract AttendanceDao AttendanceDao();

    public static AttendanceDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (AttendanceDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AttendanceDatabase.class,
                            DBNAME)
                            .addCallback(RoomDatabaseCallBack)
                            .allowMainThreadQueries()
                            .build();


                }
            }
        }
        return INSTANCE;
    }



    private static AttendanceDatabase.Callback RoomDatabaseCallBack = new AttendanceDatabase.Callback(){
        @Override
        public void onOpen(/*@NotNull*/ SupportSQLiteDatabase db){
            //ideally fix @NotNull
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {

                AttendanceDao dao2 = INSTANCE.AttendanceDao();



            });
        }
    };


}
