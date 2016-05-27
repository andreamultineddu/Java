import java.util.concurrent.locks.ReentrantLock;

public class LocalActor<T extends Message> extends AbsActor<T extends Message>
{
    Lock lock = new ReentrantLock();
    Mailbox mailbox;
    Thread t;

    public LocalActor() {mailbox = new Mailbox();}

    public void setSender(ActorRef from)
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

    public synchronized void receive(T message)
    {
        mailbox.AddMessage(sender, message);
        setSender(null);
    }
}