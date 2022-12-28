package converse

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior, Terminated}
import converse.messaging.actor.ActorCommons.ActorMessage
import converse.messaging.actor.CommandActor
import converse.messaging.actor.CommandActor.Command

object ConverseApp {

  def apply(): Behavior[ActorMessage] =
    Behaviors.setup { context =>
      val commandActor = context.spawn(CommandActor(), "commandActor")
      context.watch(commandActor)
      commandActor ! Command("whats up", context.self)
      commandActor ! Command("get files", context.self)
      commandActor ! Command("post request", context.self)
      Behaviors.receiveSignal {
        case (_, Terminated(_)) => Behaviors.stopped
      }
    }

  def main(args: Array[String]): Unit = {
    ActorSystem(ConverseApp(), "ConverseApp")
  }

}
