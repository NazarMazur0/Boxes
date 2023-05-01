package com.boxes.Service.components
import com.boxes.Service.models.Box
import java.sql.DriverManager


object DatabaseDriver {
    const val url = "jdbc:sqlserver://192.168.56.102;databaseName=Boxes;user=Nazar;password=qqw12;"
    fun test() {

        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT * FROM dbo.Department")
        println(resultSet)
        while (resultSet.next()) {
            val name = resultSet.getString("Name")
            val id = resultSet.getInt("ID")
            println("ID : $id\nName : $name")
        }
        connection.close()
    }
    fun findUnbookedBoxesBySize(size:String):List<Box> {
        val result  =  mutableListOf<Box>()
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("   SELECT \n" +
                "    B.ID, B.CODE,B.[SIZE],B.BOOKED,B.Price,L.LOCATION_Address \n" +
                "   FROM [dbo].[Boxes] as B\n" +
                "   JOIN Locations as L \n" +
                "   on B.LocationID=L.ID\n" +
                "   Where \n" +
                "    [SIZE] like '$size' and Booked =0")
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
        connection.close()
        return result
    }
}

