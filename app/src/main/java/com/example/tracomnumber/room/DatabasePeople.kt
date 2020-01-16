package com.example.tracomnumber.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tracomnumber.model.people

@Database(entities = [people::class], version = 1)

abstract class DatabasePeople : RoomDatabase() {

    abstract fun daopeople(): DaoPeople


    companion object {
        private var instance: DatabasePeople? = null

        fun getInstance(context: Context): DatabasePeople? {

            if (instance == null) {

                synchronized(DatabasePeople::class) {

                    instance = Room.databaseBuilder(context.applicationContext, DatabasePeople::class.java, "people")
                        .fallbackToDestructiveMigration().addCallback(roomCallback).build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance).execute()
            }
        }

    }
    class PopulateDbAsyncTask(db: DatabasePeople?) : AsyncTask<Unit, Unit, Unit>() {

        private val noteDao = db?.daopeople()

        override fun doInBackground(vararg p0: Unit?) {

            noteDao?.insert(
                    people(
                        "Edins",
                        "1-8-1998",
                        "kibera",
                        "87987906"
                    )
                    )

        }
    }

}