public class LocalActorRef<T extends Message> extends ActorRef<T extends Message>
{
    public synchronized void send(T message, ActorRef to)
    {
        LocalActor a = ConcreteActorSystem.getInstance().RetrieveActor(to);
        a.setSender(to);
        a.receive(message);
    }
}