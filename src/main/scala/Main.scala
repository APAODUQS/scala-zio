/*
@main def hello: Unit =
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"
 */

import zio.*
import zhttp.http.*
import zhttp.service.Server

object Main extends ZIOAppDefault {

  def run = myAppLogic

  val app: Http[Any, Nothing, Request, Response] =
    Http.collect[Request] {
      case Method.GET -> !! / "greet" / name =>
        Response.text(s"Hello $name!")
    }

  val myAppLogic =
    for {
      _    <- Console.printLine("Hello! What is your name?")
      name <- Console.readLine
      _    <- Console.printLine(s"Hello, ${name}, welcome to ZIO!")
      _    <- Server.start(port = 8085, app)
    } yield ()
}

