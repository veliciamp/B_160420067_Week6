package com.ubaya.adv160420067week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160420067week4.model.Student


class DetailViewModel(application: Application): AndroidViewModel(application){
    val studentsLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    fun fetch(idStudent:String){
//        val student1 =
//            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        studentsLD.value=student1

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id="+idStudent
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Student>() { }.type
                val result = Gson().fromJson<Student>(it, sType)
                studentsLD.value = result

                Log.d("showvoley", result.toString())

//                loadingLD.value = false
//                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
//                studentLoadErrorLD.value = true
//                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)



    }
}