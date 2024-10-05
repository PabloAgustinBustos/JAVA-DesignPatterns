import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

}

class Subscriber {
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("New video uploaded");
    }

    public void subscribeChannel(Channel c) {
        this.channel = c;
    }
}

class Channel {
    List<Subscriber> subs = new ArrayList<>();
    private String title;

    public void subscribe(Subscriber s) {
        this.subs.add(s);
    }

    public void unsubscribe(Subscriber s) {
        this.subs.remove(s);
    }

    private void notifySubs() {
        for (Subscriber s : this.subs) {
            s.update();
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubs();
    }
}