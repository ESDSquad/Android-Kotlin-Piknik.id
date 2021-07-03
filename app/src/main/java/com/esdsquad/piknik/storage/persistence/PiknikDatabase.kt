package com.esdsquad.piknik.storage.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PiknikEntity::class],
    exportSchema = false,
    version = 1
)
abstract class PiknikDatabase : RoomDatabase() {
    abstract fun exampleDao(): PiknikDao

    companion object {
        @Volatile
        private var instance: PiknikDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PiknikDatabase::class.java, "ExampleDatabase.db"
            )
                .allowMainThreadQueries()
                .build()
    }
}