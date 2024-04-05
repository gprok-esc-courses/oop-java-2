package inheritance_types.ducks;

public class FlyAsDrone implements FlyBehaviour {
    @Override
    public String fly() {
        return "flying as drone";
    }
}
