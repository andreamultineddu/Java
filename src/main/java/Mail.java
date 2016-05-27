public class LocalActor<T extends Message> extends AbsActor<T extends Message>
{
    Mailbox mailbox;
    Thread t;

    public LocalActor() {mailbox = new Mailbox();}

    public void receive(T message)
    {
        mailbox.AddMessage(message);
    }
}