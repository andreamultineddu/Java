public class TestActorRef implements Decorator
{
    protected abstract Actor<T> getUnderlyingActor(ActorSystem system)
    {

    }
}