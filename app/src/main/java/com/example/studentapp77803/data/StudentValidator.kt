package com.example.studentapp77803.data

object StudentValidator {

    const val MIN_YEAR = 1
    const val MAX_YEAR = 4

    data class Result(
        val nameError: String? = null,
        val courseError: String? = null,
        val yearError: String? = null
    ) {
        val isValid get() = nameError == null && courseError == null && yearError == null
    }

    fun validate(name: String, course: String, yearText: String): Result {
        val year = yearText.toIntOrNull()
// AI-ASSISTED:YEAR MUST BE 1-4
        return Result(
            nameError = if (name.isBlank()) "Enter the student's name" else null,
            courseError = if (course.isBlank()) "Enter the course" else null,
            yearError = if (year == null || year !in MIN_YEAR..MAX_YEAR)
                "Year must be between $MIN_YEAR and $MAX_YEAR" else null
        )
    }
}