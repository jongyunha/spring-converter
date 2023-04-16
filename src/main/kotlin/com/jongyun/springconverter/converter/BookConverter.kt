package com.jongyun.springconverter.converter

import com.jongyun.springconverter.dto.BookRequest
import com.jongyun.springconverter.entity.Book
import com.jongyun.springconverter.isNumber
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class BookConverter : Converter<BookRequest, Book> {
    override fun convert(source: BookRequest): Book {
        validate(source)
        return Book(
            id = source.id.toLong(),
            name = source.name,
            price = source.price.toDouble()
        )
    }

    private fun validate(source: BookRequest) {
        if (!source.id.isNumber()) {
            throw IllegalArgumentException("id must be number")
        }

        if (!source.price.isNumber()) {
            throw IllegalArgumentException("price must be number")
        }

        if (source.name.isBlank()) {
            throw IllegalArgumentException("name must not be blank")
        }
    }
}