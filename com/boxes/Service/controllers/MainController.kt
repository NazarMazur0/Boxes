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
    @GetMapping("/employee")
    fun returnWorkpage() : String {
        return "workpage.html"
    }
    @GetMapping("/myorders")
    fun returnUserPage():String{
        return "userpage.html"
    }
}