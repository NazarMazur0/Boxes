package com.boxes.Service.models

class Box(val id : Int, val code : String, val size : String , val booked : Boolean , val price: Int , val location : String ) {
    override fun toString(): String {
        return "Box(id=$id, code='$code', size='$size', booked=$booked, price=$price, location='$location')"
    }
}