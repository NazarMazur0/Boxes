package com.boxes.Service.components
import org.springframework.stereotype.Component
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Component
object MailSender {
    private var itsIntit=false
   private const val host = "smtp.ukr.net"
    private const val port = 465
    private const val username = "boxeslviv@ukr.net"
    private const val password = "xJdCFx0DSiTTrTo6"
    private val properties = Properties()
   private fun init(){
       itsIntit=true
       properties["mail.smtp.host"] = host
       properties["mail.smtp.port"] = port
       properties["mail.smtp.auth"] = "true"
       properties["mail.smtp.socketFactory.port"] = port
       properties["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
   }
    fun sendCode(userEmail:String,code:Int) {
        if (!itsIntit)
            init()
        // Створення сесії
        val session = Session.getDefaultInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })

        try {

            val message = MimeMessage(session)
            message.setHeader("Content-Type", "text/plain; charset=UTF-8")
            message.setFrom(InternetAddress(username))
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail))
            message.subject = "Код пітвердження"
            message.setText("Код підтвердження: ${code}")


            Transport.send(message)
            println("Лист успішно відправлено.")
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }
    fun sendSuccessfullBookingMassage(userEmail:String,boxCode:String) {
        if (!itsIntit)
            init()


        val session = Session.getDefaultInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })

        try {

            val message = MimeMessage(session)
            message.setHeader("Content-Type", "text/plain; charset=UTF-8")
            message.setFrom(InternetAddress(username))
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail))
            message.subject = "Оренда складських боксів"
            message.setText("Ви успішно забронювали бокс. Код боксу:${boxCode}")

            // Відправка повідомлення
            Transport.send(message)
            println("Лист успішно відправлено.")
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }
}