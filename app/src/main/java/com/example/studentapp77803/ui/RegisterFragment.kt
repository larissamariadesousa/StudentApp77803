package com.example.studentapp77803.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.studentapp77803.data.Student
import com.example.studentapp77803.data.StudentValidator
import com.example.studentapp77803.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StudentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener { saveStudent() }
    }

    private fun saveStudent() {
        val name = binding.inputName.text.toString().trim()
        val course = binding.inputCourse.text.toString().trim()
        val yearText = binding.inputYear.text.toString().trim()

        val result = StudentValidator.validate(name, course, yearText)
        binding.layoutName.error = result.nameError
        binding.layoutCourse.error = result.courseError
        binding.layoutYear.error = result.yearError
        if (!result.isValid) return

        val student = Student(name = name, course = course, year = yearText.toInt())
        viewModel.insert(student) { newId ->
            val b = _binding ?: return@insert
            Snackbar.make(b.root, "Student saved! ID: $newId", Snackbar.LENGTH_LONG).show()
            b.textLastId.text = "Last registered ID: $newId"
            b.inputName.text?.clear()
            b.inputCourse.text?.clear()
            b.inputYear.text?.clear()
            b.inputName.requestFocus()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}