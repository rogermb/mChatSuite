package in.mDev.MiracleM4n.mChatSuite.types;

public enum EventType {
    JOIN("join"),
    QUIT("leave"),
    LEAVE("leave"),
    KICK("kick");

    private final String name;

    EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
