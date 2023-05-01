package com.boxes.Service.services

import com.boxes.Service.models.Booking

interface Booking {
    fun findBoxes(booking: Booking):String
}