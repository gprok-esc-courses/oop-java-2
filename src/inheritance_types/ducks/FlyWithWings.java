package inheritance_types.ducks;

public class FlyWithWings implements FlyBehaviour {
    @Override
    public String fly() {
        return "flies with wings";
    }
}
