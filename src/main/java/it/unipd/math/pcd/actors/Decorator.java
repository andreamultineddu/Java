public interface Decorator implements ActorRef
{
    protected abstract Actor<T> getUnderlyingActor(ActorSystem system);
}