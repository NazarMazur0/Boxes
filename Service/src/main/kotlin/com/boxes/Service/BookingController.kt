package com.boxes.Service

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/")
class BookingController {
    @PostMapping("newBooking")
    fun newBooking(@RequestBody booking: Booking):Int {
        println(booking)
        DatabaseDriver.test()
        return 1;
    }

}
