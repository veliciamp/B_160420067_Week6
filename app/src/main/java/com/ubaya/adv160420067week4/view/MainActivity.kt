package com.ubaya.adv160420067week4.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ubaya.adv160420067week4.R
import com.ubaya.adv160420067week4.util.createNotificationChannel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import com.ubaya.adv160420067week4.util.showNotification




class MainActivity : AppCompatActivity() {
    init {
        instance = this
    }

    companion object {
        var instance:MainActivity ?= null

//        fun showNotification(title:String, content:String, icon:Int) {
//            val channelId = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"
//
//            val notificationBuilder = NotificationCompat.Builder(instance!!.applicationContext, channelId).apply {
//                setSmallIcon(icon)
//                setContentTitle(title)
//                setContentText(content)
//                setStyle(NotificationCompat.BigTextStyle())
//                priority = NotificationCompat.PRIORITY_DEFAULT
//                setAutoCancel(true)
//            }
//            val notificationManager = NotificationManagerCompat.from(instance!!.applicationContext.applicationContext!!)
//            notificationManager.notify(1001,notificationBuilder.build() )
//
//
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel(this,
            NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel.")



        val fab= findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("Messages", "five seconds")
                    showNotification("dummy",
                        "A new notification created",
                        R.drawable.ic_baseline_error_24)
                }
        }


//        val observable = Observable.just("a stream of data","hellow","world")

//        val observer= object : Observer<String>{
//            override fun onSubscribe(d: Disposable?) {
//
//                Log.d("Messages", "begin subscribe")
//
//            }
//
//            override fun onNext(t: String) {
//                Log.d("Messages", "data: $t")
//
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e("Messages", "error: ${e!!.message.toString()}")
//            }
//
//            override fun onComplete() {
//                Log.d("Messages", "complete")
//            }
//
//        }

        Observable.just("a stream of data","hellow","world").subscribe(
        { Log.d("Messages", it) },
        { Log.e("Messages", it.message.toString()) },
        { Log.d("Messages", "Completed") }
        )
        Observable.timer(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("Messages", "five seconds")
            }






    }
}