package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import org.springframework.stereotype.Service

@Service
class OrderService : Order {
    override  fun findNewOrders():String {
        val orders = DatabaseDriver.findNewOrders()
        var res="<div class=\"row t-5\">\n" +
                "\n" +
                "        <div class=\"col lg-4 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Ім'я</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Прізвище</span>\n" +
                "                    </div>\n" +
                "                   </div>\n"+
                "                    <div class=\"row\">\n"+
                "                    <div class=\"col\">\n" +
                "                        <span class=\"price \">Email</span>\n" +
                "                    </div><div class=\"col\">\n" +
                "                    <span class=\"price \">Телфеон</span>\n" +
                "                </div>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col lg-4 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Код</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Розмір</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"price \">Cума</span>\n" +
                "                    </div>\n" +
                "                                 </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col lg-4 \">\n" +
                "            <div class=\"container-sm bg-primary text-light rounded m-2\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col\">\n" +
                "                        <span class=\"code \">Період бронювання</span>\n" +
                "                    </div>\n" +
                "                    <div class=\"col  \">\n" +
                "                        <span class=\"size\">Статус</span>\n" +
                "                    </div>\n" +
                "\n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </div>"
         orders.forEach{
             res+="<div style=\"background:#35455e\" class=\"container  t-5 border border-1 border-info rounded\"> "+
                    "<div class=\"row t-5\">\n" +

                     "\n" +
                     "        <div class=\"col lg-4 \">\n" +
                     "            <div class=\"container-sm  text-light rounded m-2\">\n" +
                     "                <div class=\"row\">\n" +
                     "                    <div class=\"col\">\n" +
                     "                        <span class=\"code \">${it.name}</span>\n" +
                     "                    </div>\n" +
                     "                    <div class=\"col  \">\n" +
                     "                        <span class=\"size\">${it.surname}</span>\n" +
                     "                    </div>\n" +
                                            "</div>\n"+
                                            "<div class=\"row\">\n"+
                     "                    <div class=\"col\">\n" +
                     "                        <span class=\"price \">${it.email}</span>\n" +
                     "                    </div>" +
                     "                  <div class=\"col\">\n" +
                     "                    <span class=\"price \">${it.phone}</span>\n" +
                     "                </div>\n" +
                     "                </div>\n" +
                     "\n" +
                     "            </div>\n" +
                     "        </div>\n" +
                     "        <div class=\"col lg-4 \">\n" +
                     "            <div class=\"container-sm  text-light rounded m-2\">\n" +
                     "                <div class=\"row\">\n" +
                     "                    <div class=\"col\">\n" +
                     "                        <span class=\"code \">${it.code}</span>\n" +
                     "                    </div>\n" +
                     "                    <div class=\"col  \">\n" +
                     "                        <span class=\"size\">${it.size}</span>\n" +
                     "                    </div>\n" +
                     "                    <div class=\"col\">\n" +
                     "                        <span class=\"price \">${it.sum}</span>\n" +
                     "                    </div>\n" +
                     "                                 </div>\n" +
                     "\n" +
                     "            </div>\n" +
                     "        </div>\n" +
                     "        <div class=\"col lg-4 \">\n" +
                     "            <div class=\"container-sm  text-light rounded m-2\">\n" +
                     "                <div class=\"row\">\n" +
                     "                    <div class=\"col\">\n" +
                     "                        <span class=\"code \">${it.startDate.month+1}/${it.startDate.date}/${it.startDate.year+1900} | ${it.endDate.month+1}/${it.endDate.date}/${it.endDate.year+1900}</span>\n" +
                     "                    </div>\n" +
                     "                    <div class=\"col  \">\n" +
                     "                        <span class=\"size\">${it.status}</span>\n" +
                     "                    </div>\n" +
                     "\n" +
                     "                </div>\n" +
                     "\n" +
                     "            </div>\n" +
                     "        </div>\n" +
                     "\n" +
                     "\n" +
                     "\n" +
                     "</div\n> " +
                     "<div class=\"row t-5\">\n" +
                     "        <div class=\"col col-lg-3\"></div>\n" +
                     "        <div class=\"col col-lg-3\">\n" +
                     "            <button class=\"btn btn-danger\">Скасувати</button>\n" +
                     "        </div>\n" +
                     "        <div class=\"col col-lg-3\">\n" +
                     "            <button class=\"btn btn-success\">Прийняти</button>\n" +
                     "        </div>\n" +
                     "        <div class=\"col col-lg-3\"></div>\n" +
                     "    </div> \n"+
                     "    </div>"
         }
        return res
    }
}