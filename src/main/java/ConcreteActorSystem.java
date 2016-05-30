import java.util.concurrent.locks.ReentrantLock;
import it.unipd.math.pcd.actors;

//uno usa i lock; l;altro la concurrency map

public class ConcreteActorSystem extends AbsActorSystem
{
    private ConcreteActorSystem instance = null;
    private Lock lock = new ReentrantLock();

    private ConcreteActorSystem()
    {
        actors = new Map();
    }

    public static synchronized ConcreteActorSystem GetInstance()
    {
        if(instance == null)
            instance = new ConcreteActorSystem()();
        return instance;
    }

    public Actor RetrieveActor(ActorRef ar)
    {
        lock.lock();
        Actor a = null;
        try
        {
            if (actors.containsKey(ar))
                a = actors.get(ar);
        }
        finally
        {
            lock.unlock();
            return a;
        }
    }

    protected ActorRef createActorReference(ActorMode mode)
    {
        if(mode==ActorMode.LOCAL)
            return new LocalActorRef();
        else
            throw new IllegalArgumentException();
    }

    public void stop(ActorRef<?> actor)
    {
        actors.
    }

    public void stop()
    {

    }
}
