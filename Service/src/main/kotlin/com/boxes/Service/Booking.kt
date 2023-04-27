package com.boxes.Service

class Booking(val name: String,val surname: String,val email: String,val phone:String,val period:Int,val size:Int,val check:Boolean,val wishes:String) {
    override fun toString(): String {
        return "Booking(name='$name', surname='$surname', email='$email', phone='$phone', period=$period, size=$size, check=$check, wishes='$wishes')"
    }
}