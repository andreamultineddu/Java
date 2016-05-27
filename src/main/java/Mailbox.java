public class Mailbox
{
    //no arraylist -> cosa, vector, list
    private ArrayList<Mail> mails;
    private Lock lock = new ReentrantLock();

    public  Mailbox()
    {
        mails = new ArrayList();
    }

    public synchronized void AddMessage(ActorRef s, Message m)
    {
        lock.lock();
        try
        {
            mails.Add(new Mail(s, m));
        }
        finally
        {
            lock.unlock();
        }
    }

    public synchronized Mail RemoveMessage()
    {
        lock.lock();
        Mail m;
        try
        {
            m = mails.RemoveFirst();
        }
        finally
        {
            lock.unlock();
        }
        return m;
    }

    public boolean isEmpty()
    {
        lock.lock();
        boolean empty = false;
        try
        {
            empty = mails.Empty();
        }
        finally
        {
            lock.unlock();
            return empty;
        }
    }
}