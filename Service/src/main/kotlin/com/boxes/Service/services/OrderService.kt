package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.models.ProcessedOrder
import com.boxes.Service.services.interfaces.Order
import org.springframework.stereotype.Service

@Service
class OrderService : Order {
    override fun findNewOrders(): String {
        val orders = DatabaseDriver.findNewOrders()
        var res = "<div class=\"row t-5\">\n" +
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
                "                   </div>\n" +
                "                    <div class=\"row\">\n" +
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
        orders.forEach {
            res += "<div id=\"${it.code}Container\" style=\"background:#35455e\" class=\"container  t-5 border border-1 border-info rounded\"> " +
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
                    "</div>\n" +
                    "<div class=\"row\">\n" +
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
                    "                        <span class=\"code \">${it.startDate.month + 1}/${it.startDate.date}/${it.startDate.year + 1900} <br> ${it.endDate.month + 1}/${it.endDate.date}/${it.endDate.year + 1900}</span>\n" +
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
                    "            <button id=\"${it.code}Deny\" class=\"DenyButton btn btn-danger\">Скасувати</button>\n" +
                    "        </div>\n" +
                    "        <div class=\"col col-lg-3\">\n" +
                    "            <button id=\"${it.code}Accept\" class=\"AcceptButton btn btn-success\">Прийняти</button>\n" +
                    "        </div>\n" +
                    "        <div class=\"col col-lg-3\"></div>\n" +
                    "    </div> \n" +
                    "    </div>"
        }
        return res
    }

    override fun acceptOrder(processedOrder: ProcessedOrder): Boolean {
        return DatabaseDriver.acceptOrder(processedOrder)
    }

    override fun denyOrder(processedOrder: ProcessedOrder): Boolean {
        return DatabaseDriver.denyOrder(processedOrder)
    }

    override fun getClientOrders(email: String): String {
        var res = "<div   class=\"container bg-primary  t-5 border border-1 border-primary rounded\">\n" +
                "    <div class=\"row t-5 \" >\n" +
                "\n" +
                "      <div class=\"col col-lg-6 \">\n" +
                "        <div class=\"container-sm  text-light rounded m-2\">\n" +
                "          <div class=\"row\">\n" +
                "            <div class=\"col\">\n" +
                "              <span class=\"code \">Код</span>\n" +
                "            </div>\n" +
                "            <div class=\"col  \">\n" +
                "              <span class=\"size\">Розімр</span>\n" +
                "            </div>\n" +
                "            <div class=\"col\">\n" +
                "              <span class=\"price \">Сума</span>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"col col-lg-6 \">\n" +
                "        <div class=\"container-sm  text-light rounded m-2\">\n" +
                "          <div class=\"row\">\n" +
                "            <div class=\"col\">\n" +
                "              <span class=\"period\">Період бронювання</span>\n" +
                "            </div>\n" +
                "            <div class=\"col  \">\n" +
                "              <span class=\"status\">Статус</span>\n" +
                "            </div>\n" +
                "            <div class=\"col  \">\n" +
                "              <span class=\"aвdress\">Адресса</span>\n" +
                "            </div>\n" +
                "\n" +
                "          </div>\n" +
                "\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </div>\n" +
                "  </div>"
//        try{
            val clientOrders= DatabaseDriver.getClientOrders(email)
            clientOrders.forEach{
                res+="  <div id=\"${it.code}Container\" style=\"background:#35455e\" class=\"container  t-5 border border-1 border-info rounded\">\n" +
                        "    <div class=\"row t-5 \" >\n" +
                        "\n" +
                        "    <div class=\"col lg-4 \">\n" +
                        "      <div class=\"container-sm  text-light rounded m-2\">\n" +
                        "        <div class=\"row\">\n" +
                        "          <div class=\"col\">\n" +
                        "            <span class=\"code \"> ${it.code}</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"col  \">\n" +
                        "            <span class=\"size\"> ${it.size}</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"col\">\n" +
                        "            <span class=\"price \"> ${it.sum} </span>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "    <div class=\"col lg-4 \">\n" +
                        "      <div class=\"container-sm  text-light rounded m-2\">\n" +
                        "        <div class=\"row\">\n" +
                        "          <div class=\"col\">\n" +
                        "            <span class=\"period\">${it.startDate.month + 1}/${it.startDate.date}/${it.startDate.year + 1900} <br> ${it.endDate.month + 1}/${it.endDate.date}/${it.endDate.year + 1900}</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"col  \">\n" +
                        "            <span class=\"status\">${it.status}</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"col  \">\n" +
                        "            <span class=\"address\">${it.locationAddress!!}</span>\n" +
                        "          </div>\n" +
                        "\n" +
                        "\n" +
                        "        </div>\n" +
                        "\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "  </div>\n" +
                        "  </div>"
            }
            return res
//        }
//        catch (e:Exception){
//            println(e.message)
//            return res
//        }

    }
}