package com.boxes.Service.services.interfaces

import com.boxes.Service.models.Booking
import com.boxes.Service.models.Box
import com.boxes.Service.models.BoxBooking

interface Booking {
    fun findUnbookedBoxes(booking: Booking):List<Box>

    fun bookBox(booking: BoxBooking):String
}