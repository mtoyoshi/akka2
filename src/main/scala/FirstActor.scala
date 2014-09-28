import akka.actor.Actor
import akka.actor.Props

class FirstActor extends Actor with akka.actor.ActorLogging {
  val secondActor = context.actorOf(Props[SecondActor], "secondActor")
  val specialActor = context.actorOf(Props[SpecialActor], "specialActor")

  def receive = {
    case msg: String => log.info(msg); secondActor ! msg
    case _ => log.warning("unexpected message received at FirstActor.")
  }
}
