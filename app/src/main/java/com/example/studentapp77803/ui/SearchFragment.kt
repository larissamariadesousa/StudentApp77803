package com.example.studentapp77803.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.studentapp77803.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StudentViewModel by activityViewModels()

    private var hasSearched = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            val id = binding.inputId.text.toString().trim().toIntOrNull()
            if (id == null) {
                binding.layoutId.error = "Enter a valid numeric ID"
                return@setOnClickListener
            }
            binding.layoutId.error = null
            hasSearched = true
            viewModel.search(id)
        }

        viewModel.searchResult.observe(viewLifecycleOwner) { student ->
            if (!hasSearched) return@observe

            if (student != null) {
                binding.cardResult.visibility = View.VISIBLE
                binding.textError.visibility = View.GONE
                binding.textName.text = "Name: ${student.name}"
                binding.textCourse.text = "Course: ${student.course}"
            } else {
                binding.cardResult.visibility = View.GONE
                binding.textError.visibility = View.VISIBLE
                binding.textError.text = "No student found with ID ${binding.inputId.text}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}