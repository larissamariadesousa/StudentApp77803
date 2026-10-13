package com.example.studentapp77803.data

import androidx.lifecycle.LiveData

class StudentRepository(private val dao: StudentDao) {

    suspend fun insert(student: Student): Long = dao.insert(student)

    fun getById(id: Int): LiveData<Student?> = dao.getById(id)
}