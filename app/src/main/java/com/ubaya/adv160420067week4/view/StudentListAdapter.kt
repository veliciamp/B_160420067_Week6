package com.ubaya.adv160420067week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160420067week4.R
import com.ubaya.adv160420067week4.model.Student
import com.ubaya.adv160420067week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int):StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val txtSID = holder.view.findViewById<TextView>(R.id.txtID)
        val txtSName = holder.view.findViewById<TextView>(R.id.txtSName)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        holder.view.imageView.loadImage(studenList[position].photoUrl, holder.view.progressBar)

        txtSID.text = studenList[position].id
        txtSName.text = studenList[position].name

        btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}