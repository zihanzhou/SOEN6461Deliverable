import padl.kernel.*;

import java.util.Iterator;

abstract class PlantUMLVisitor {
    protected final StringBuffer buffer = new StringBuffer();
    private int indentation = 0;

    public void close(final IAbstractModel anAbstractModel) {
        this.buffer.append("\n");
        this.buffer.append("@enduml");
    }

    public void close(final IClass aClass) {
        this.buffer.append("\n");
        this.buffer.append("}");
        this.buffer.append("\n");

        this.indentation--;
    }

    public void close(final IConstructor aConstructor){}
    public void close(final IDelegatingMethod aDelegatingMethod){}
    public void close(final IGetter aGetter){}
    public void close(final IGhost aGhost){
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        this.buffer.append('\n');
        this.indentation--;
    }

    public void close(final IInterface anInterface){
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        this.buffer.append('\n');

        this.indentation--;
    }
    public void close(final IMemberClass aMemberClass){}
    public void close(final IMemberGhost aMemberGhost){}
    public void close(final IMemberInterface aMemberInterface){}
    public void close(final IMethod aMethod){}
    public void close(final IPackage aPackage){}
    public void close(final IPackageDefault aPackage){}
    public void close(final ISetter aSetter){}
    public String getName(){return buffer.toString();}

    public void open(final IAbstractModel anAbstractModel){
        this.buffer.append("@startuml");
        this.buffer.append("\n");
    }

    public void open(final IClass p){
        this.buffer.append(" class ");
        this.buffer.append(p.getName());
        Iterator iterator = p.getIteratorOnInheritedEntities();
        if (iterator.hasNext()) {
            this.buffer.append(" extends ");
            while (iterator.hasNext()) {
                this.buffer.append(((IFirstClassEntity) (iterator.next()))
                        .getName());
                if (iterator.hasNext())
                    this.buffer.append(", ");
            }
        }
        iterator = p.getIteratorOnImplementedInterfaces();
        if (iterator.hasNext()) {
            this.buffer.append(" implements ");
            while (iterator.hasNext()) {
                this.buffer.append(((IFirstClassEntity) (iterator.next()))
                        .getName());
                if (iterator.hasNext())
                    this.buffer.append(", ");
            }
        }
        this.buffer.append(' ');
        this.buffer.append('{');
        this.buffer.append('\n');

        this.indentation++;
    }
    public void open(final IConstructor aConstructor){}
    public void open(final IDelegatingMethod aDelegatingMethod){}
    public void open(final IGetter aGetter){}

    public void open(final IGhost p){
        this.buffer.append(" ghost ");
        this.buffer.append(p.getName());
        Iterator iterator = p.getIteratorOnInheritedEntities();
        if (iterator.hasNext()) {
            this.buffer.append(" extends ");
            while (iterator.hasNext()) {
                this.buffer.append(((IFirstClassEntity) (iterator.next()))
                        .getName());
                if (iterator.hasNext())
                    this.buffer.append(", ");
            }
        }
        iterator = p.getIteratorOnImplementedInterfaces();
        if (iterator.hasNext()) {
            this.buffer.append(" implements ");
            while (iterator.hasNext()) {
                this.buffer.append(((IFirstClassEntity) (iterator.next()))
                        .getName());
                if (iterator.hasNext())
                    this.buffer.append(", ");
            }
        }
        this.buffer.append(' ');
        this.buffer.append('{');
        this.buffer.append('\n');

        this.indentation++;
    }
    public void open(final IInterface p){

        this.buffer.append(" interface ");
        this.buffer.append(p.getName());
        final Iterator iterator = p.getIteratorOnInheritedEntities();
        if (iterator.hasNext()) {
            this.buffer.append(" extends ");
            while (iterator.hasNext()) {
                this.buffer.append(((IFirstClassEntity) (iterator.next()))
                        .getName());
                if (iterator.hasNext())
                    this.buffer.append(", ");
            }
        }
        this.buffer.append(' ');
        this.buffer.append('{');
        this.buffer.append('\n');

        this.indentation++;
    }
    public void open(final IMemberClass aMemberClass){}
    public void open(final IMemberGhost aMemberGhost){}
    public void open(final IMemberInterface aMemberInterface){}
    public void open(final IMethod aMethod){}
    public void open(final IPackage p){}
    public void open(final IPackageDefault aPackage){}
    public void open(final ISetter aSetter){}
    public void reset(){
        this.buffer.setLength(0);
        this.indentation = 0;
        System.out.println("RESET");
    }
    public void unknownConstituentHandler(
            final String aCalledMethodName,
            final IConstituent aConstituent){}
    public void visit(final IAggregation p){
        this.buffer.append(" o--");
        this.buffer.append(p.getName());
        this.buffer.append(' ');
        this.buffer.append(": aggregation");
        this.buffer.append('\n');
    }
    public void visit(final IAssociation p){
        this.buffer.append(" --");
        this.buffer.append(p.getName());
        this.buffer.append(' ');
    }
    public void visit(final IComposition p){
        this.buffer.append(" *--");
        this.buffer.append(p.getName());
        this.buffer.append(' ');
        this.buffer.append(": aggregation");
        this.buffer.append('\n');
    }
    public void visit(final IContainerAggregation aContainerAggregation){}
    public void visit(final IContainerComposition aContainerComposition){}
    public void visit(final ICreation aCreation){}
    public void visit(final IField aField){}
    public void visit(final IMethodInvocation aMethodInvocation){}
    public void visit(final IParameter aParameter){}
    public void visit(final IPrimitiveEntity aPrimitiveEntity){}
    public void visit(final IUseRelationship aUse) {}
}
