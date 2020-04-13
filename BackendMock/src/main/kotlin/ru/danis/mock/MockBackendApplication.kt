package ru.danis.mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockBackendApplication

fun main(args: Array<String>) {
	runApplication<MockBackendApplication>(*args)
}
