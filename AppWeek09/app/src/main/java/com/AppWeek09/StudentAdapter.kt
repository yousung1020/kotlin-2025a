package com.AppWeek09

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.AppWeek09.data.Student
import com.AppWeek09.databinding.ItemStudentBinding

class StudentAdapter(
    private val studentList: List<Student>,
    // Unit은 자바로 따지면 void 같은 것(해당 람다 함수의 반환 값이 없다)
    private val onItemClick: (Student, Int) -> Unit,
    private val onItemLongClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder(private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(student: Student){
            binding.apply {
                textViewName.text = student.name
                textViewDept.text = student.department
                textViewGrade.text = student.grade
                textViewEmail.text = student.email

                root.setOnClickListener{
                    onItemClick(student, adapterPosition)
                }

                root.setOnLongClickListener{
                    onItemLongClick(adapterPosition)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return StudentViewHolder(binding)
    }


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount(): Int = studentList.size
}