package com.boxes.Service.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/")
class TokenController {
    @GetMapping("main")
    fun returnToken() : String {
     return "HELLO"
    }
}