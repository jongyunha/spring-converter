package com.jongyun.springconverter.controller

import com.jongyun.springconverter.dto.BookRequest
import com.jongyun.springconverter.service.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService
) {

    @PostMapping("/book")
    fun create(@RequestBody body: BookRequest) {
        bookService.create(body)
    }

}