package converse.messaging.actor

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}
import converse.messaging.actor.ActorCommons.ActorMessage

object CommandActor {

  case class Command(message: String, actorRef: ActorRef[ActorMessage]) extends ActorMessage
  case class CommandResponse(message: String) extends ActorMessage

  def apply(): Behavior[Command] = Behaviors.receive[Command] { (context, greetMessage) =>

    greetMessage match {
      case Command(message, replyTo) =>
        val response = s"message received: $message"
        println(response)
        replyTo ! CommandResponse(response)
      case _ =>
        println("cannot figure command out!")
    }
    Behaviors.same

  }


}
