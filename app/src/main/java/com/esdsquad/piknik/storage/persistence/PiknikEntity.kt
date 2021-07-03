package com.esdsquad.piknik.storage.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableExample")
data class PiknikEntity(
    @PrimaryKey(autoGenerate = false)
    val example: String
)