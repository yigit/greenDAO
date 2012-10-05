<#include "*/annotation.ftl">
<#macro print_enum_stub stub>
    <@print_annotations stub.getterAnnotations, "    "/>
    public ${stub.className} get${stub.propertyName?cap_first}() {
        if(${stub.propertyName} == null && ${stub.property.propertyName} != null) {
           try {
               ${stub.propertyName} = ${stub.className}.values()[${stub.property.propertyName}];
           } catch(Throwable t) {
               //silent fail
           }
        }
        return ${stub.propertyName};
    }

    <@print_annotations stub.setterAnnotations, "    "/>
    public void set${stub.propertyName?cap_first}(${stub.className} ${stub.propertyName}) {
        this.${stub.propertyName} = ${stub.propertyName};
        if( this.${stub.propertyName} == null) {
            ${stub.property.propertyName} = null;
        } else {
            ${stub.property.propertyName} = this.${stub.propertyName}.ordinal();
        }
    }
</#macro>