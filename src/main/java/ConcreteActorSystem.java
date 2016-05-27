public class ConcreteActroSystem extends AbsActorSystem
{
    private ConcreteActroSystem instance = null;

    private ConcreteActorSystem()
    {
        actors = new Map();
    }

    public synchronized ConcreteActroSystem GetInstance()
    {
        if(instance == null)
            instance = new ConcreteActroSystem()();
        return instance;
    }
}
