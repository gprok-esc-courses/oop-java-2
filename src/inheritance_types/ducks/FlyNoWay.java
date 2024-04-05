package inheritance_types.ducks;

public class FlyNoWay implements FlyBehaviour {
    @Override
    public String fly() {
        return "does not fly";
    }
}
