package forum;

import java.util.ArrayList;

/**
 * Forum is a class, that contains all messages
 */
public class Forum
{
    /**
     * Collection of messages
     */
    ArrayList<Message> items;

    /**
     * default constructour of ArrayList()12
     */
    public Forum()
    {
        this.items = new ArrayList();
    }

    /**
     *
     * @return list of messages
     */
    public ArrayList getItems() {
        return items;
    }

    /**
     *
     * @param newMessage add message to list named forum
     */
    public void addMessageList(Message newMessage)
    {
        items.add(newMessage);
    }

    /**
     *
     * @param removeMessage - index to remove
     */
    public void removeMessageList(int removeMessage)
    {
        items.remove(removeMessage);
    }
}