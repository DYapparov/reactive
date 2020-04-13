package ru.danis.mock

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

@RestController
class Controller {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?):Greeting {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextLong(2))
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

    @GetMapping("/hooiting")
    fun hooiting(@RequestParam(value = "name", defaultValue = "World") name: String?):Greeting {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextLong(10, 15))
        return Greeting(counter.incrementAndGet(), "Hello, hui$name")
    }
    data class Greeting(val id: Long, val content: String)
}