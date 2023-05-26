package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.components.MailSender
import com.boxes.Service.models.Box
import com.boxes.Service.models.BoxBooking
import com.boxes.Service.models.Client
import com.boxes.Service.services.interfaces.Booking
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.sql.Date
import java.util.NoSuchElementException

@Service
class BookingService : Booking {
    override fun findUnbookedBoxes(booking: com.boxes.Service.models.Booking): List<Box> {
      return  try {
             DatabaseDriver.findUnbookedBoxesBySize(
                when(booking.size){
                    1->"великий" 2->"середній" 3->"малий"
                    else -> {""}
                })
        }catch (e:Exception){
             mutableListOf<Box>()
        }


    }


    override fun bookBox(booking: BoxBooking): String {
        var clientExist: Boolean
        var sqlEndDate :Date
        var localEndDate: LocalDate = LocalDate.now()
        localEndDate=  localEndDate.plusDays(1).plusMonths(booking.period.toLong())

        sqlEndDate=Date.valueOf(localEndDate)

        try {
            DatabaseDriver.findClientByEmail(Client(booking.name, booking.surname, booking.email, booking.phone, false))
            clientExist = true
        } catch (e: NoSuchElementException) {
            println(e.message)
            clientExist = false
        }
        if (clientExist) {
            try {
                DatabaseDriver.newOrder(booking.email, booking.code,sqlEndDate, booking.period)
                DatabaseDriver.updateBoxAsBooked(booking.code)
                MailSender.sendSuccessfullBookingMassage(booking.email,booking.code)
                return "Success"

            } catch (e:Exception){
                println(e.message)
                return ""
            }

        } else {
            try {
               println(DatabaseDriver.insertClient(Client(booking.name, booking.surname, booking.email, booking.phone, false)))

            } catch (e: NoSuchElementException) {
                println("2ndCath > ${e.message}")
                return ""
            }
            DatabaseDriver.newOrder(booking.email, booking.code, sqlEndDate, booking.period)
            DatabaseDriver.updateBoxAsBooked(booking.code)
            MailSender.sendSuccessfullBookingMassage(booking.email,booking.code)
            return "Success"
        }
    }
}