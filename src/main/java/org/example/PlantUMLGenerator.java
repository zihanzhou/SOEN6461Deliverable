package org.example;

import padl.kernel.*;
import padl.util.Util;
import padl.visitor.IGenerator;

import java.util.Iterator;
import java.util.Stack;

public class PlantUMLGenerator implements IGenerator {
    private final StringBuffer buffer = new StringBuffer();
    private final StringBuffer relationship = new StringBuffer();
    private Stack<String> className = new Stack();
    
    
    private int indentation = 0;
    public void close(final IAbstractLevelModel p) {
    }

    public void close(IAbstractModel anAbstractModel) {
    	 this.buffer.append(relationship.toString());
    	 this.buffer.append("\n");
         this.buffer.append("@enduml\n");
    }
    public void close(final IClass p) {
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        className.pop();

        this.indentation--;
    }
    public void close(final IConstructor aConstructor) {
    }
    public void close(final IDelegatingMethod aDelegatingMethod) {
    }
    public void close(final IGetter aGetter) {
    }
    public void close(final IGhost p) {
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        this.buffer.append('\n');
        className.pop();

        this.indentation--;
    }
    public void close(final IInterface p) {
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        this.buffer.append('\n');
        className.pop();

        this.indentation--;
    }
    public void close(final IMemberClass aMemberClass) {
    }
    public void close(final IMemberGhost aMemberGhost) {
    }
    public void close(final IMemberInterface aMemberInterface) {
    }
    public void close(final IMethod aMethod) {
    }
    public void close(final IPackage aPackage) {
        this.buffer.append('\n');
        this.buffer.append('}');
        this.buffer.append('\n');
        this.buffer.append('\n');

        this.indentation--;
    }
    public void close(final IPackageDefault aPackage) {
    }
    public void close(final ISetter aSetter) {
    }
    private void commentsAndVisibility(final IConstituent p) {
    }
    public String getCode() {
        return this.buffer.toString();
    }
    public String getName() {
        return "PlantUML";
    }
    public Object getResult() {
        return this.buffer.toString();
    }
    private void nameAndParameters(final IOperation p) {

    }
    public void open(final IAbstractLevelModel p) {
    	
    }
    public void open(IAbstractModel anAbstractModel) {
    	this.buffer.append("@startuml");
        this.buffer.append("\n");
    }
    public void open(final IClass p) {
        //this.commentsAndVisibility(p);
        this.buffer.append("class ");
        this.buffer.append(p.getName());
        className.push(String.valueOf(p.getName()));
        
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
        this.buffer.append('\n');

        this.indentation++;
    }
    public void open(final IConstructor p) {
    }
    public void open(final IDelegatingMethod p) {

    }
    public void open(final IGetter p) {

    }
    public void open(final IGhost p) {
        this.buffer.append("class \"");
        this.buffer.append(p.getName());
        this.buffer.append("\"");
        className.push(String.valueOf(p.getName()));
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
    public void open(final IInterface p) {
        this.buffer.append("interface ");
        this.buffer.append(p.getName());
        className.push(String.valueOf(p.getName()));
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
    public void open(final IMemberClass aMemberClass) {
    }
    public void open(final IMemberGhost aMemberGhost) {
    }
    public void open(final IMemberInterface aMemberInterface) {
    }
    public void open(final IMethod p) {

    }
    public void open(final IPackage p) {
        this.buffer.append("package ");
        this.buffer.append(p.getName());

        this.buffer.append(' ');
        this.buffer.append('{');
        this.buffer.append('\n');

        this.indentation++;
    }
    public void open(final IPackageDefault aPackage) {

    }
    public void open(final ISetter p) {

    }
    public void reset() {
        this.buffer.setLength(0);
        this.indentation = 0;
    }
    public final void unknownConstituentHandler(
            final String aCalledMethodName,
            final IConstituent aConstituent) {

    }
    public void visit(final IAggregation p) {
    	 this.relationship.append(className.peek() + " o-- " + extractClassName(String.valueOf(p.getName())));
         this.relationship.append("\n");
    }
    public void visit(final IAssociation p) {
        this.relationship.append(className.peek() + " -- " + extractClassName(String.valueOf(p.getName())));
        this.relationship.append("\n");
    }
    public void visit(final IComposition p) {
    	 this.relationship.append(className.peek() + " *-- " + extractClassName(String.valueOf(p.getName())));
         this.relationship.append("\n");
    }
    public void visit(final IContainerAggregation p) {
    }
    public void visit(final IContainerComposition p) {

    }
    public void visit(final ICreation p) {
    }
    public void visit(final IField p) {

    }
    public void visit(final IMethodInvocation aMethodInvocation) {
    }
    public void visit(final IParameter p) {

    }
    public void visit(final IPrimitiveEntity aPrimitiveEntity) {
    }
    public void visit(final IUseRelationship p) {
    }
    public static String extractClassName(String input) {
        String[] parts = input.split(":");
        String fullClassName = parts[1]; // Extracting the part containing the full class name
        String[] classNameParts = fullClassName.split("\\."); // Splitting by dot
        return classNameParts[classNameParts.length - 1]; // Returning the last part (class name)
    }
}
