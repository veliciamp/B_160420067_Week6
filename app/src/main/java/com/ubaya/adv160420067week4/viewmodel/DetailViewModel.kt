package com.ubaya.adv160420067week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.adv160420067week4.model.Student


class DetailViewModel:ViewModel() {
    val studentsLD = MutableLiveData<Student>()
    fun fetch(idStudent:String){
        val student1 =
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentsLD.value=student1


    }
}