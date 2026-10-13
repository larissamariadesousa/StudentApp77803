package com.example.studentapp77803.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(student: Student): Long

    @Query("SELECT * FROM students WHERE id = :studentId LIMIT 1")
    fun getById(studentId: Int): LiveData<Student?>
}