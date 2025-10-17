package com.appweek06

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appweek06.R

class MainActivity : AppCompatActivity() {
    // UI component
    private lateinit var buttonAdd: Button
    private lateinit var buttonClear: Button
    private lateinit var listView: ListView
    private lateinit var editTextStudent: EditText
    private lateinit var textViewCount: TextView

    // Collection
    private lateinit var studentList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    companion object{
        private const val TAG = "KotlinWeek06App"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: AppWeek06 started")

        setupViews()
        setupListView()
        setupListeners()

        addInitialData()
    }

    private fun setupViews(){
        listView = findViewById(R.id.listViewStudents)
        editTextStudent = findViewById(R.id.editTextStudent)
        buttonClear = findViewById(R.id.buttonClear)
        buttonAdd = findViewById(R.id.buttonAdd)
        textViewCount = findViewById(R.id.textViewCount)

        studentList = ArrayList()
        Log.d(TAG, "Views initialized")
    }

    private fun setupListView(){
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList)
        listView.adapter = adapter

        Log.d(TAG, "ListViews and Adapter setup complete")
    }

    private fun setupListeners(){
        buttonAdd.setOnClickListener{
            addStudent()
        }

        buttonClear.setOnClickListener{
            clearAllStudents()
        }

        listView.setOnItemLongClickListener{
            _, _, position, _ -> removeStudent(position)
            true
        }

        listView.setOnItemClickListener{
            _, _, position, _ ->
            val studentName = studentList[position]
            Toast.makeText(
                this,
                "Selected $studentName (Position: ${position + 1})",
                Toast.LENGTH_SHORT // 토스트(팝업) 창이 빠르게 사라지게끔
            ).show()

            Log.d(TAG, "Selected $studentName (Position: ${position + 1})")
        }

        Log.d(TAG, "Event listener setup completed")
    }

    private fun addStudent(){
        val studentName = editTextStudent.text.toString().trim()

        // 비어있을 시
        if(studentName.isEmpty()){
            Toast.makeText(this, "Please enter a student name", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Attempted to add empty student name")

            return
        }

        // 이름 중복 시
        if(studentList.contains(studentName)){
            Toast.makeText(this, "Student '${studentName} already exists'", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Attempted to add duplicated student ${studentName}")

            return
        }

        studentList.add(studentName)

        adapter.notifyDataSetChanged()
        editTextStudent.text.clear()

        updateStudentCount()

        Toast.makeText(this, "Added: ${studentName}", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Added student: ${studentName} (Total: ${studentList.size})")
    }

    private fun clearAllStudents(){
        if(studentList.isEmpty()){
            Toast.makeText(this, "List is already empty", Toast.LENGTH_SHORT).show()
            return
        }

        val count = studentList.size

        studentList.clear()

        adapter.notifyDataSetChanged()
        updateStudentCount()

        Toast.makeText(this, "Cleared all ${count} students", Toast.LENGTH_SHORT).show()

        Log.d(TAG, "Cleared all students (Total cleared: ${count})")
    }

    private fun removeStudent(position: Int){
        if(position >= 0 && position < studentList.size){
            // 특정 인덱스에 있는 요소를 지우는 함수: removeAt(index)
            val removedStudent = studentList.removeAt(position)

            adapter.notifyDataSetChanged()
            updateStudentCount()

            Toast.makeText(this, "Removed: ${removedStudent}", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Removed student: ${removedStudent} (Remaining: ${studentList.size})")
        }
    }

    private fun updateStudentCount(){
        textViewCount.text = "Total Students: ${studentList.size}"
    }

    private fun addInitialData(){
        val initialStudents = listOf("Kim", "Lee", "Park")
        studentList.addAll(initialStudents)
        adapter.notifyDataSetChanged()

        updateStudentCount()

        Log.d(TAG, "Added initial data: ${initialStudents}")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "OnResume: Current student count: ${studentList.size}")
    }

    override fun onPause(){
        super.onPause()

        Log.d(TAG, "onPause: Saving state with ${studentList.size}")
    }
}