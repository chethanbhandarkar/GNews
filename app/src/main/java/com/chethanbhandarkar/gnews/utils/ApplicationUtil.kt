package com.chethanbhandarkar.gnews.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ApplicationUtil {


    companion object{

        @RequiresApi(Build.VERSION_CODES.O)
        fun convertDate(date:String):String{


            val parsedDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME)
            val formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy   HH:mm"))
            return formattedDate.toString()
        }
    }




}