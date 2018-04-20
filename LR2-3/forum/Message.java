package forum;
/**
 * Message is a small unit from a forum
 */
public class Message
{
    /**
     * text is a text in a message
     */
    String text;

    /**
     *
     * @param text new messageText
     */
    public Message(String text) {
        this.text = text;
    }
    /**
     *
     * @return text from message
     */
    public String getText() {
        return text;
    }
}
