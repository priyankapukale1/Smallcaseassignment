package annotation;

public enum TesterName {
    Priyanka("Pukale Priyanka");

    public String authorName;
    TesterName(String authorName)
    {
        this.authorName=authorName;
    }

    public String toString() {
        return this.authorName;
    }
}
