package ru.samsung.itschool.mdev.roomvsfragment.db;

import android.content.Context;

import androidx.room.Room;

public class DBClient {

    private Context mCtx;
    private static DBClient mInstance;

    private AppDB appDatabase;

    private DBClient(Context mCtx) {
        this.mCtx = mCtx;
        //Создание БД - MyToDos
        appDatabase = Room.databaseBuilder(mCtx, AppDB.class, "MyTasks").build();
    }

    public static DBClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DBClient(mCtx);
        }
        return mInstance;
    }

    public AppDB getAppDatabase() {
        return appDatabase;
    }
}