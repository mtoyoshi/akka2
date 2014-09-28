import akka.actor.Actor

class SpecialActor extends Actor with akka.actor.ActorLogging {
  def receive = {
    case msg: String => log.info(msg)
    case _ => log.warning("unexpected message received at SpecialActor.")
  }
}
