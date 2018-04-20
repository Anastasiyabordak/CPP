public class CompareSymbols implements Runnable {
    private char symbolOne;
    private char symbolTwo;
    private boolean compareResult;

    public CompareSymbols(char one, char two)
    {
        this.symbolOne = one;
        this.symbolTwo = two;
        if(symbolOne == symbolTwo)
            this.compareResult = true;
        else this.compareResult = false;
    }

    @Override
    public void run() {

    }
    public boolean returnResult()
    {
        return this.compareResult;
    }
}
