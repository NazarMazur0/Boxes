package com.boxes.Service.components
import com.boxes.Service.models.*
import java.lang.NullPointerException
import java.sql.Date
import java.sql.DriverManager
import java.util.Date as utilDate
import java.util.NoSuchElementException
import java.sql.Date as sqlDate


object DatabaseDriver {
    private const val url = "jdbc:sqlserver://192.168.56.102;databaseName=Boxes;user=Nazar;password=qqw12;"

    fun findUnbookedBoxesBySize(size:String):List<Box> {
        val result  =  mutableListOf<Box>()
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "   SELECT \n" +
                "    B.ID, B.CODE,B.[SIZE],B.BOOKED,B.Price,L.LOCATION_Address \n" +
                "   FROM [dbo].[Boxes] as B\n" +
                "   JOIN Locations as L \n" +
                "   on B.LocationID=L.ID\n" +
                "   Where \n" +
                "    [SIZE] like '$size' and Booked =0"
        val resultSet = statement.executeQuery(query)
        println(resultSet)
        while (resultSet.next()) {
            val id = resultSet.getInt("ID")
            val code = resultSet.getString("CODE")
            val size = resultSet.getString("SIZE")
            val booked  = resultSet.getBytes("BOOKED").joinToString("") { "%02x".format(it) }.isEmpty()
            val price = resultSet.getInt("Price")
            val location = resultSet.getString("LOCATION_Address")
            result.add(Box(id,code,size,booked,price,location))

        }
        statement.close()
        connection.close()
        return result
    }
    fun findClientByEmail(client:Client) : Client{
        var resClient:Client
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "SELECT * FROM dbo.CLIENTS WHERE EMAIL = '${client.email}'"
        val resultSet = statement.executeQuery(query)
        println(resultSet)
        if (resultSet.next()) {
         resClient= Client(resultSet.getString("NAME"),resultSet.getString("SURNAME"),resultSet.getString("EMAIL"),resultSet.getString("PHONE"),resultSet.getBytes("REGULAR").joinToString("") { "%02x".format(it) }.isEmpty())

        } else {
            statement.close()
            connection.close()
            throw NoSuchElementException("Клієнта не знайдено")
        }
        statement.close()
        connection.close()

       return resClient
    }
    fun findClientByPhone(client:Client) : Client{
        var resClient:Client
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "SELECT * FROM dbo.CLIENTS WHERE PHONE = '${client.phone}'"
        val resultSet = statement.executeQuery(query)
        println(resultSet)
        if (resultSet.next()) {
            resClient= Client(resultSet.getString("NAME"),resultSet.getString("SURNAME"),resultSet.getString("EMAIL"),resultSet.getString("PHONE"),resultSet.getBytes("REGULAR").joinToString("") { "%02x".format(it) }.isEmpty())

        } else {
            statement.close()
            connection.close()
            throw NoSuchElementException("Клієнта не знайдено")
        }
        statement.close()
        connection.close()
        return resClient
    }
    fun insertClient(client:Client) : Client{


        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "INSERT INTO dbo.CLIENTS \n" +
                "VALUES (\n" +
                "    (SELECT MAX(ID) + 1 FROM dbo.CLIENTS), \n" +
                "    '${client.name}',\n" +
                "    '${client.surname}',\n" +
                "    '${client.phone}',\n" +
                "    0,\n" +
                "    '${client.email}'\n" +
                ");\n"
        val resultSet = statement.executeUpdate(query)
        println(resultSet)
        if (resultSet>0) {
            println("Client ADDED")

        } else {
            statement.close()
            connection.close()
            throw NoSuchElementException("Клієнта не додано")
        }
        statement.close()
        connection.close()
        return client
    }
    fun newOrder(clientEmail:String, boxCode:String, endDate: Date, Period:Int){
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query =
            "INSERT into dbo.ORDERS VALUES ( ((SELECT MAX(ID) FROM dbo.ORDERS)+1) ,(SELECT ID FROM dbo.CLIENTS WHERE EMAIL='${clientEmail}'),0,(SELECT ID FROM dbo.BOXES WHERE CODE='${boxCode}'),GETDATE(),'${
                endDate
            }', ((SELECT Price FROM dbo.BOXES WHERE CODE='${boxCode}')*${Period}),'Нове')"
        val resultSet = statement.executeUpdate(query)
        println(resultSet)
        if (resultSet>0) {
            println(  "order added" )
        } else {
            statement.close()
            connection.close()
            throw NoSuchElementException("Замовлення не додано")
        }
        statement.close()
        connection.close()

    }
    fun updateBoxAsBooked(boxCode: String){
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "UPDATE BOXES" +
                "  SET BOOKED = 1 " +
                "WHERE CODE='${boxCode}'"
        val resultSet = statement.executeUpdate(query)
        println(resultSet)
        if (resultSet>0) {
            println(  "boxes booked " )
        } else {
            statement.close()
            connection.close()
            throw NoSuchElementException("Бронювання боксу не зміненено")
        }
        statement.close()
        connection.close()

    }
    fun checkEmployee(login:EmployeeLogin):Boolean{
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "SELECT PHONE,PASSWORD" +
                " FROM EMPLOYEE" +
                " WHERE PHONE='${login.phone}' and PASSWORD='${login.password}'"
        val resultSet = statement.executeQuery(query)
        if (resultSet.next()) {
            return resultSet.getString("PHONE")==login.phone&&resultSet.getString("PASSWORD")==login.password
        } else  {
            throw NullPointerException("Немає данних")
        }

    }
    fun findNewOrders():List<OrderInfo>{
        val resList= mutableListOf<OrderInfo>()
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "SELECT *  " +
                "FROM ORDERS O " +
                "JOIN CLIENTS C on O.CLIENTID=C.ID " +
                "JOIN BOXES B on O.BOXID=B.ID  " +
                "WHERE STATUS='Нове'"
        val resultSet = statement.executeQuery(query)
        while (resultSet.next()) {
            val name = resultSet.getString("NAME")
            val surname = resultSet.getString("SURNAME")
            val email = resultSet.getString("EMAIL")
            val phone = resultSet.getString("PHONE")
            val code = resultSet.getString("CODE")
            val size = resultSet.getString("SIZE")
            val startDate = utilDate(resultSet.getDate("START_DATE").time)
            val endDate = utilDate(resultSet.getDate("END_DATE").time)
            val sum = resultSet.getInt("SUM")
            val status = resultSet.getString("STATUS")

            resList.add(OrderInfo(name, surname, email, phone, code, size, startDate, endDate, sum, status))

        }
        statement.close()
        connection.close()
        return resList
    }
    fun acceptOrder(processedOrder: ProcessedOrder):Boolean{
        val resList= mutableListOf<OrderInfo>()
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "UPDATE ORDERS SET STATUS='Активне'," +
                "EMLOYEEID =( SELECT ID" +
                " FROM EMPLOYEE " +
                "WHERE " +
                "PHONE='${processedOrder.employeePhone}' and PASSWORD='${processedOrder.employeePassword}')"+
                "WHERE BOXID=(SELECT ID FROM BOXES WHERE CODE='${processedOrder.boxCode}')"
        val resultSet = statement.executeUpdate(query)
        return if (resultSet>0) {
            statement.close()
            connection.close()
            true
        } else {
            statement.close()
            connection.close()
            false
        }


    }
    fun denyOrder(processedOrder: ProcessedOrder):Boolean{
        val resList= mutableListOf<OrderInfo>()
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val query = "UPDATE ORDERS SET STATUS='Скасоване'," +
                "EMLOYEEID =( SELECT ID" +
                " FROM EMPLOYEE " +
                "WHERE " +
                "PHONE=${processedOrder.employeePhone} and PASSWORD='${processedOrder.employeePassword}')" +
                "WHERE BOXID=(SELECT ID FROM BOXES WHERE CODE='${processedOrder.boxCode}')"
        val resultSet = statement.executeUpdate(query)
        return if (resultSet>0) {
            statement.executeUpdate("UPDATE BOXES SET BOOKED=0 WHERE CODE='${processedOrder.boxCode}'")
            statement.close()
            connection.close()
            true
        } else {
            statement.close()
            connection.close()
            false
        }


    }

}


