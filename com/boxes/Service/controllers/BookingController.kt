package com.boxes.Service.controllers


import com.boxes.Service.models.Booking
import com.boxes.Service.services.BookingService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/")
class BookingController(private val service:BookingService) {
    @PostMapping("newBooking")
    fun newBooking(@RequestBody booking: Booking):String {

        return service.findBoxes(booking);
    }

}
