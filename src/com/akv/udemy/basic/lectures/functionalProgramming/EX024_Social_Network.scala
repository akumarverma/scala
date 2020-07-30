package com.akv.udemy.basic.lectures.functionalProgramming
import scala.collection.mutable.Map

object EX024_Social_Network extends App {

  val network = new SocialNetwork

  network.add("Amit")
  network.friend("Amit","Shubh")
  network.friend("Amit","Prisha")
  network.friend("Amit","Swati")
  println(network)

}

sealed class SocialNetwork() {

  private var network: Map[String, Set[String]] = Map()

  def add(person: String) = {
    if (network.contains(person.toLowerCase)) {
      println("Person already in network")
      network
    }
    else {network = network + (person -> Set())}
  }

  def friend( a: String, b: String): Unit = {

    if (network.contains(a)) {
      val friendOfa: Set[String] = network(a)
      if (!network.contains(b)) {
        add(b)
      }
      val friendOfb: Set[String] = network(b)
      network + (a-> friendOfa + b)
      network +(b-> friendOfb + a)
    }
  }

  override def toString: String = {

    network.toString()
  }
}