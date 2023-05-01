package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.models.Box
import org.springframework.stereotype.Service

@Service
class BookingService : Booking {
    override fun findBoxes(booking: com.boxes.Service.models.Booking): String {
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
                result+="<div class=\"boxesInfo col sm-2  m-2  rounded border border-black\">\n" +
                        "            <div class=\"container-sm bg-light rounded m-2\">\n" +
                        "                <div class=\"row\">\n" +
                        "                    <div class=\"col\">\n" +
                        "                        <span class=\"code \">${boxesChunked[i][j].code}</span>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col  \">\n" +
                        "                        <span class=\"size\">${boxesChunked[i][j].size}</span>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col\">\n" +
                        "                        <span class=\"price \">${boxesChunked[i][j].price}</span>\n" +
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
                        "                        <button class=\"btn btn-primary booking_button \">Бронювати</button>\n" +
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
}