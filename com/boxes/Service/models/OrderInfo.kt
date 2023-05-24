package com.boxes.Service.models

import java.util.Date

class OrderInfo(val name:String?=null,val surname:String?=null,val email:String?=null,val phone:String?=null,val code:String,val size:String,val startDate:Date,val endDate:Date,val sum:Int,val status:String,val locationAddress:String?=null) {

}