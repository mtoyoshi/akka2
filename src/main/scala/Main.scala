import akka.actor.ActorSystem
import akka.actor.Props

object Main extends App {
  implicit val akkaSystem = ActorSystem("toyoshimaAkka")
  val firstActor = akkaSystem.actorOf(Props[FirstActor], "first")
  val specialActor = akkaSystem.actorSelection("/user/first/specialActor")

  akkaSystem.settings.toString.lines.filter(_.trim.head != '#').foreach(println)

  (1 to 12000).par.map(_ => Thread.currentThread.getId).groupBy(id => id).foreach {
    case (k, v) => println(s"$k : ${v.size}")
  }

  (1 to 10).foreach { i=>
    if(i % 5 == 0) specialActor ! "special " + i
    else firstActor ! "test" + i
  }

  Thread.sleep(5000)

  akkaSystem.shutdown()
}
