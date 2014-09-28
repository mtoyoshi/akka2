import akka.actor.Actor

class SecondActor extends Actor with akka.actor.ActorLogging {
  def receive = {
    case msg: String => log.info(msg)
    case _ => log.warning("unexpected message received at SecondActor.")
  }
}
