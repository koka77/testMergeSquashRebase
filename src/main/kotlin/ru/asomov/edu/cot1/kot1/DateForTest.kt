package ru.asomov.edu.cot1.kot1

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZonedDateTime

data class DateForTest(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy MMM dd HH:mm:ss.SSS*zzz", timezone = "GMT+8")
    val offsetDt: OffsetDateTime = OffsetDateTime.parse("2022-10-29T21:00:00.000Z"),

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.ssxxx", timezone = "GMT+8")
    val zonedDateTime: ZonedDateTime = ZonedDateTime.parse("2022-10-29T21:00:00.000Z"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    val timestamp: Timestamp = Timestamp.valueOf(LocalDateTime.parse("2019-07-18T13:50:35.0"))
)
