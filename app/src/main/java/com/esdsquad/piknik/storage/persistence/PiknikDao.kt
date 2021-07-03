package com.esdsquad.piknik.storage.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PiknikDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PiknikEntity)

    @Update
    suspend fun update(entity: PiknikEntity)

    @Delete
    suspend fun delete(entity: PiknikEntity)

    @Query("DELETE FROM tableExample")
    suspend fun deleteAll()

    @Query("SELECT * FROM tableExample")
    fun select(): LiveData<List<PiknikEntity>>
}