package com.boxes.Service.services.interfaces

import com.boxes.Service.models.Booking
import com.boxes.Service.models.BoxBooking

interface Booking {
    fun findUnbookedBoxes(booking: Booking):String

    fun bookBox(booking: BoxBooking):String
}