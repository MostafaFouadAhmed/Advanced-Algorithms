package designpatterns.creationalpatterns.singleton;

public class SingletonStaticBlock {

    private static final SingletonStaticBlock STATIC_BLOCK;
    private final int ID;
    private final String NAME;

    static {

        STATIC_BLOCK = new SingletonStaticBlock(12, "SingletonStaticBlock");

    }

    private SingletonStaticBlock(int ID, String NAME) {

        this.ID = ID;
        this.NAME = NAME;

    }

    public static SingletonStaticBlock getInstance() {
        return STATIC_BLOCK;
    }

    @Override
    public String toString() {

        return "SingletonStaticBlock{" +
            "ID=" + ID +
            ", NAME='" + NAME + '\'' +
            '}';
    }

}
