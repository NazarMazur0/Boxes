package com.boxes.Service.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/booking")
    fun returnBooking() : String {
     return "booking.html"
    }
    @GetMapping("/")
    fun returnIndex() : String {
        return "index.html"
    }
}