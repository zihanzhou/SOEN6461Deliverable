import padl.visitor.IGenerator;

public final class PlantUMLGenerator extends PlantUMLVisitor implements IGenerator{
    public String getCode() {
        return this.buffer.toString();
    }
}