package com.example.studentapp77803.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.studentapp77803.data.AppDatabase
import com.example.studentapp77803.data.Student
import com.example.studentapp77803.data.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        StudentRepository(AppDatabase.getDatabase(application).studentDao())

    fun insert(student: Student, onSaved: (Long) -> Unit) {
        viewModelScope.launch {
            val newId = repository.insert(student)
            onSaved(newId)
        }
    }

    private val searchId = MutableLiveData<Int>()

    val searchResult: LiveData<Student?> = searchId.switchMap { id ->
        repository.getById(id)
    }

    fun search(id: Int) {
        searchId.value = id
    }
}