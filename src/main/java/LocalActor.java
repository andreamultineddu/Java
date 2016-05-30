import java.util.concurrent.locks.ReentrantLock;

public class LocalActor<T extends Message> extends AbsActor<T extends Message> 
{
    boolean stopped;
    Lock lock = new ReentrantLock();
    Mailbox mailbox;
    Thread t;

    public LocalActor()
    {
        mailbox = new Mailbox();
        stopped = false;
        t = new Thread(
                new Runnable()
                {
                    LocalActor a = this;
                    while(!a.isStopped())
                }
            );
        t.start();
    }

    public void setSender(ActorRef from)
    {
        if(!stopped)
        {
            lock.lock();
            try
            {
                if (sender == null) {
                    sender = from;
                }
            }
            finally {
                lock.unlock();
                if(sender == from) return;
                else setSender(from);
            }
        }
        else
            throw new NoSuchActorException();
    }

    public synchronized void receive(T message)
    {
        if(!stopped)
        {
            mailbox.AddMessage(sender, message);
            setSender(null);
        }
        else
            throw new NoScuhActorException();
    }
    
    public void stop()
    {
        if(!stopped)
            stopped = true;
        else
            throw new NoSuchActorException();
    }
    
    public void ProcessMessage()
    {
        if(!stopped)
            mailbox.removeFirst();
        else
            throw new NoSuchActorException();
    }
}
