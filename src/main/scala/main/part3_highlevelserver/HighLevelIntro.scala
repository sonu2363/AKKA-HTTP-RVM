package main.part3_highlevelserver

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object HighLevelIntro extends App{
     implicit val system=ActorSystem("HighLevelIntro")
  implicit val materializer=ActorMaterializer()
  import system.dispatcher

  val simpleRoute : Route=
    path("home"){
      complete(StatusCodes.OK)
    }
    val pathGetRoute: Route=
      path("home"){
        get{
          complete(StatusCodes.OK)
        }
  }
  val chainedRoute: Route=
    path("myEndPoint"){
      get{
        complete(StatusCodes.OK)
      }
      post{
        complete(StatusCodes.Forbidden)
      }
    }~
      path("home"){
        complete(
          HttpEntity(
            ContentTypes.`text/html(UTF-8)`,
            """
              |<html>
              |<body>
              |Hello from Akka HTTP
              |</body>
              |</html>
              |""".stripMargin
          )
        )
      }//Routing Tree

         Http().bindAndHandle(chainedRoute,"localhost",8080)
}
