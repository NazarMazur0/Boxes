package com.boxes.Service.models


class BoxBooking(val name: String,val surname: String,val email: String,val phone:String,val period:Int,val size:Int,val check:Boolean,val wishes:String,val code:String) {
    override fun toString(): String {
        return "BoxBooking(name='$name', surname='$surname', email='$email', phone='$phone', period=$period, size=$size, check=$check, wishes='$wishes', code='$code')"
    }
}