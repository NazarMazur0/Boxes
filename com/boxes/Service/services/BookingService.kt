package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.models.Box
import com.boxes.Service.models.BoxBooking
import com.boxes.Service.models.Client
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.sql.Date
import java.util.NoSuchElementException

@Service
class BookingService : Booking {
    override fun findUnbookedBoxes(booking: com.boxes.Service.models.Booking): String {
        var result="<h4>Доступні контейнери</h4>\n" +
                "    <div class=\"row t-5\">\n" +
                "\n" +
                "        <div class=\"col sm-2 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Код</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Розмір</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"price \">Ціна</span>\n" +
                "                    </div><div class=\"col\">\n" +
                "                        <span class=\"price \">Адресса</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col sm-2 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Код</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Розмір</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"price \">Ціна</span>\n" +
                "                    </div>\n <div class=\"col\">\n" +
                "                        <span class=\"price \">Адресса</span>\n" +
                "                    </div>" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col sm-2 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Код</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Розмір</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"price \">Ціна</span>\n" +
                "                    </div><div class=\"col\">\n" +
                "                        <span class=\"price \">Адресса</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </div>"
       val boxes= DatabaseDriver.findUnbookedBoxesBySize(
            when(booking.size){
                1->"великий" 2->"середній" 3->"малий"
                else -> {""}
            }
        )
        println(boxes.size)
        val boxesChunked = mutableListOf<List<Box>>()
        for (chunk in boxes.chunked(3)) {
            boxesChunked.add(chunk)
        }

        for(i in 0 until boxesChunked.size){
            result+="<div class=\"row t-5\">"
            for(j in 0 until boxesChunked[i].size){
                result+="<div class=\"boxesInfo  col sm-2  m-2  rounded border border-black\">\n" +
                        "            <div id=\"box${boxesChunked[i][j].code}Container\" class=\"container-sm bg-light rounded m-2 \">\n" +
                        "                <div class=\"row\">\n" +
                        "                    <div class=\"col\">\n" +
                        "                        <span class=\"code \">${boxesChunked[i][j].code}</span>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col  \">\n" +
                        "                        <span class=\"size\">${boxesChunked[i][j].size}</span>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col\">\n" +
                        "                        <span class=\"price \">${boxesChunked[i][j].price*booking.period}</span>\n" +
                        "                    </div>\n <div class=\"col\">\n" +
                        "                        <span class=\"price \">${boxesChunked[i][j].location}</span>\n" +
                        "                    </div>" +
                        "\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"col sm-2 \">\n" +
                        "                <div class=\"row\">\n" +
                        "                    <div class=\"col\"></div>\n" +
                        "                    <div class=\"col\">\n" +
                        "                        <button id=\"${boxesChunked[i][j].code}Button\" class=\"BoxButton btn btn-primary booking_button \">Бронювати</button>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col\"></div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </div>\n" +
                        "        </div>"
                if(boxesChunked[i].size==2&&j==1) result+="<div class=\"boxesInfo col sm-2  m-2  rounded border border-black\"></div>"
                if(boxesChunked[i].size==1) result+="<div class=\"boxesInfo col sm-2  m-2  rounded border border-black\"></div><div class=\"boxesInfo col sm-2  m-2  rounded border border-black\"></div>"
            }
            result+="</div>"
        }

        return result
    }



    override fun bookBox(booking: BoxBooking): String {
        var clientExist: Boolean
        var sqlEndDate :Date
        var localEndDate: LocalDate = LocalDate.now()
        localEndDate=  localEndDate.plusDays(1).plusMonths(booking.period.toLong())

        sqlEndDate=Date.valueOf(localEndDate)
        println(localEndDate.toString())

        try {
            DatabaseDriver.findClientByEmail(Client(booking.name, booking.surname, booking.email, booking.phone, false))
            clientExist = true
        } catch (e: NoSuchElementException) {
            println(e.message)
            clientExist = false
        }
        if (clientExist) {

            DatabaseDriver.newOrder(booking.email, booking.code,sqlEndDate.time, booking.period)
            DatabaseDriver.updateBoxAsBooked(booking.code)
            return "Success"
        } else {
            println("This is else branch")
            try {
               println(DatabaseDriver.insertClient(Client(booking.name, booking.surname, booking.email, booking.phone, false)))

            } catch (e: NoSuchElementException) {
                println("2ndCath > ${e.message}")
            }
            DatabaseDriver.newOrder(booking.email, booking.code, localEndDate.toEpochDay(), booking.period)
            DatabaseDriver.updateBoxAsBooked(booking.code)
            return "Success"
        }
    }
}