package com.boxes.Service.controllers.restControllers


import com.boxes.Service.models.Booking
import com.boxes.Service.models.Box
import com.boxes.Service.models.BoxBooking
import com.boxes.Service.services.BookingService
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
@RequestMapping("api/")
class BookingController(private val bookingService:BookingService) {
    @PostMapping("newBooking")
    fun newBooking(@RequestBody booking: Booking):ModelAndView {
        val boxes=bookingService.findUnbookedBoxes(booking)
        val boxesChunked = mutableListOf<List<Box>>()
        for (chunk in boxes.chunked(3)) {
            boxesChunked.add(chunk)
        }
       val model=ModelAndView("boxes")
        model.addObject("boxesChunked",boxesChunked)
        model.addObject("period",booking.period)
        return model
    }
    @PostMapping("newBoxBooking")
    fun newBoxBooking(@RequestBody boxbooking: BoxBooking) {

       bookingService.bookBox(boxbooking)
    }
}
