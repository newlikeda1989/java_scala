package com.app.service

import java.util
import scala.collection.JavaConversions._

import com.app.model.Book

object BooksProcessor {

  def filterByAuthor(author: String)(implicit books: util.ArrayList[Book]) = {
    books.filter(book => book.getAuthor == author)
  }

}