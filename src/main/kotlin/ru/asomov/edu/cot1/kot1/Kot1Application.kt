package ru.asomov.edu.cot1.kot1

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

@SpringBootApplication
class Kot1Application

fun main(args: Array<String>) {
    // runApplication<Kot1Application>(*args)
    // Timestamp.from(ZonedDateTime.now().toInstant() + Duration.ofHours(1))
    val dateForTest = DateForTest()
    val objectMapper = ObjectMapper()
    objectMapper.registerModule(JavaTimeModule())
    objectMapper.registerModule(KotlinModule.Builder().build())
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

    println("map offsetDt: \t\t" + objectMapper.writeValueAsString(dateForTest.offsetDt))
    println("offsetDt: \t\t\t" + dateForTest.offsetDt)

    println("map zonedDateTime: \t" + objectMapper.writeValueAsString(dateForTest.zonedDateTime))
    println("$$$$$$$$$$$")
    println(objectMapper.writeValueAsString(dateForTest.timestamp))
    println("$$$$$$$$$$$")
    System.out.println(objectMapper.writeValueAsString(ZonedDateTime.now(ZoneId.of("Europe/Paris"))))
    System.out.println(objectMapper.writeValueAsString(OffsetDateTime.now(ZoneId.of("Europe/Paris"))))
    System.out.println(objectMapper.writeValueAsString(OffsetDateTime.parse("2022-10-29T21:00:00.000Z")))
    System.out.println(objectMapper.writeValueAsString(OffsetDateTime.parse("2022-10-29T21:00:00+02:00")))

    /**
     * add 1 commit in test2
     */
}
