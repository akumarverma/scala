package com.akv.basic

import java.io.File

object EX009_01_Control_Abstraction extends App{

  // File Matching Option1
  object FileMatcherOp1 {

    private val listFiles: Array[File] = new java.io.File("./src/com/akv/basic").listFiles()

    def endsWith(query: String): Array[File] ={
      for(file <-listFiles
          if file.getName().endsWith(query)
          ) yield file
    }

    def contains(query: String): Array[File] ={
      for(file <-listFiles
          if file.getName().contains(query)
          ) yield file
    }

    def startsWith(query: String): Array[File] ={
      for(file <-listFiles
          if file.getName().startsWith(query)
          ) yield file
    }
  }

  println(FileMatcherOp1.endsWith("scala").toList)
  println(FileMatcherOp1.contains("read").toList)
  println(FileMatcherOp1.startsWith("EX013").toList)

  // File Matching Option2, much Concise
  object FileMatcherOp2 {

    private val listFiles: Array[File] = new java.io.File("./src/com/akv/basic").listFiles()

    private def fileMatcher(matcher :(String)=> Boolean): Array[File] ={
      for(file <-listFiles
          if matcher(file.getName())
          ) yield file
    }

    def fileEnds(query: String) ={
      fileMatcher(_.endsWith(query))
    }
    def fileContains(query: String) ={
      fileMatcher(_.contains(query))
    }
  }
  println(FileMatcherOp2.fileEnds("scala").toList)
  println(FileMatcherOp2.fileContains("EX013").toList)

}
