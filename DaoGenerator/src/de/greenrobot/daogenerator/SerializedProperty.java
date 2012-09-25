package de.greenrobot.daogenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * This can be used to auto-generate serialization-deserialization code
 * User: yigit
 */
public class SerializedProperty {
    protected Property property;
    protected String propertyName;
    protected String className;
    protected List<String> imports = new ArrayList<String>();

    private List<Annotation> setterAnnotations = new ArrayList<Annotation>();
    private List<Annotation> getterAnnotations = new ArrayList<Annotation>();

    public SerializedProperty(Property property, String propertyName, String className) {
        this.property = property;
        this.propertyName = propertyName;
        this.className = className;
        property.setSerialized(this);
    }

    public Property getProperty() {
        return property;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getClassName() {
        return className;
    }

    public List<Annotation> getSetterAnnotations() {
        return setterAnnotations;
    }

    public List<Annotation> getGetterAnnotations() {
        return getterAnnotations;
    }

    public SerializedProperty addSetterAnnotation(Annotation annotation) {
        setterAnnotations.add(annotation);
        return this;
    }

    public SerializedProperty addSetterGetterAnnotation(Annotation annotation) {
        setterAnnotations.add(annotation);
        getterAnnotations.add(annotation);
        return this;
    }

    public SerializedProperty addGetterAnnotation(Annotation annotation) {
        getterAnnotations.add(annotation);
        return this;
    }

    public SerializedProperty addImport(String pack) {
        this.imports.add(pack);
        return this;
    }

    public List<String> getImports() {
        return imports;
    }
}
