public class Mail
{
    private ActorRef s;
    private Message m;

    public Mail(ActorRef a, Message m)
    {
        s = a;
        this.m = m;
    }

    public ActorRef GetS() {return s;}
    public Message GetM() {return m;}
}