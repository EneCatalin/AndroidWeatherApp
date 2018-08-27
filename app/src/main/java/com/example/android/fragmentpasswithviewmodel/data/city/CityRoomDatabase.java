package com.example.android.fragmentpasswithviewmodel.data.city;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.android.fragmentpasswithviewmodel.model.city.City;
import com.example.android.fragmentpasswithviewmodel.service.CityDao;


@Database(entities = {City.class}, version = 1)
public abstract class CityRoomDatabase extends RoomDatabase {


    public abstract CityDao cityDao();

    private static CityRoomDatabase INSTANCE;

    public static CityRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CityRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CityRoomDatabase.class, "city_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };


}
