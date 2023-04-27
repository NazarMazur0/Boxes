package com.boxes.Service
import java.sql.DriverManager
import java.sql.Connection

object DatabaseDriver {
    fun test() {
        val url = "jdbc:sqlserver://192.168.56.102;databaseName=Boxes;user=Nazar;password=qqw12;"
        val connection = DriverManager.getConnection(url)
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT * FROM dbo.Department")
        println(resultSet)
        while (resultSet.next()) {
            val name = resultSet.getString("Name")
            val id = resultSet.getInt("ID")
            println("ID : $id\nName : $name")
        }
    }
}

