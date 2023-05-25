package com.boxes.Service.services

import com.boxes.Service.models.EmployeeLogin
import org.springframework.stereotype.Service
import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.components.MailSender
import com.boxes.Service.models.ClientLogin
import com.boxes.Service.services.interfaces.Login
import java.lang.NullPointerException
import kotlin.random.Random

@Service
class LoginService: Login {
    val map = mutableMapOf<String,Int>()
    override fun checkEmlpoyee(login:EmployeeLogin): Boolean {
        return try {
            DatabaseDriver.checkEmployee(login)

        } catch (e:NullPointerException){
            false
        }
    }

    override fun checkClient(email:String): Boolean {
        return try {
            DatabaseDriver.checkClient(email)
            val random = Random(System.currentTimeMillis())
            val code = random.nextInt(100_000, 1_000_000)
            MailSender.sendCode(email,code)
            map[email] = code
            true
        } catch (e:Exception){
            println(e.message)
            false
        }


    }
    override fun loginClient(clientLogin: ClientLogin): Boolean {
      return  clientLogin.code==map[clientLogin.email]
    }
}