public class ConcreteActroSystem extends AbsActorSystem
{
    private ConcreteActroSystem instance = null;

    private ConcreteActroSystem()
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