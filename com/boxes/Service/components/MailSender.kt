package com.boxes.Service.components
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

object MailSender {
   private val host = "smtp.ukr.net"
    private val port = 465
    private val username = "boxeslviv@ukr.net"
    private val password = "               "

    // Властивості для встановлення параметрів поштового сервера
    private val properties = Properties()
   private fun init(){
       properties["mail.smtp.host"] = host
       properties["mail.smtp.port"] = port
       properties["mail.smtp.auth"] = "true"
       properties["mail.smtp.socketFactory.port"] = port
       properties["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
   }
    fun sendCode(userEmail:String,code:Int) {
        init()


        // Створення сесії
        val session = Session.getDefaultInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })

        try {
            // Створення об'єкту повідомлення
            val message = MimeMessage(session)
            message.setFrom(InternetAddress(username))
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail))
            message.subject = "Код пітвердження"
            message.setText("Код підтвердження: ${code}")

            // Відправка повідомлення
            Transport.send(message)
            println("Лист успішно відправлено.")
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }
}