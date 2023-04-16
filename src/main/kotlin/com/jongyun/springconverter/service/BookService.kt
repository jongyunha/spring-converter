package com.jongyun.springconverter.service

import com.jongyun.springconverter.dto.BookRequest
import com.jongyun.springconverter.entity.Book
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service

@Service
class BookService(
    private val conversionService: ConversionService
) {

    fun create(request: BookRequest) {
        val book = conversionService.convert(request, Book::class.java)
        println("Created book id: ${book!!.id}")
    }
}