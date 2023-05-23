package com.boxes.Service.models

import java.util.Date
import java.util.GregorianCalendar

class OrderInfo(val name:String,val surname:String,val email:String,val phone:String,val code:String,val size:String,val startDate:Date,val endDate:Date,val sum:Int,val status:String) {
}