package com.boxes.Service.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/booking")
    fun returnBooking() : String {
     return "booking"
    }
    @GetMapping("/")
    fun returnIndex() : String {
        return "index"
    }

    @GetMapping("/employee")
    fun returnWorkpage() : String {
        return "workpage"
    }
    @GetMapping("/myorders")
    fun returnUserPage():String{
        return "userpage"
    }
}