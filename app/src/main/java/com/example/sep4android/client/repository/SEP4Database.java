package com.example.sep4android.client.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sep4android.client.model.AlertValue;
import com.example.sep4android.client.model.Measurements;
import com.example.sep4android.client.model.User;

@Database(entities = {User.class, Measurements.class, AlertValue.class}, version = 3, exportSchema = false)
public abstract class SEP4Database extends RoomDatabase {
    private static SEP4Database instance;
    public static synchronized SEP4Database getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), SEP4Database.class, "sep4_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
    public abstract MeasurementsDao measurementsDao();

    public abstract AlertValueDao alertValueDao();
}
