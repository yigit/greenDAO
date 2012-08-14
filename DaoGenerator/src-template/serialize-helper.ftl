<#include "*/annotation.ftl">
<#macro print_serialization_stub stub>
    <@print_annotations stub.getterAnnotations, "    "/>
    public ${stub.className} get${stub.propertyName?cap_first}() {
        if(${stub.propertyName} == null && ${stub.property.propertyName} != null) {
           ${stub.propertyName}  = (${stub.className}) DbUtils.deserializeObject(${stub.property.propertyName});
           ${stub.property.propertyName} = null; //clear memory, before save, we'll re-serialize anyways if needed
        }
        return ${stub.propertyName};
    }

    <@print_annotations stub.setterAnnotations, "    "/>
    public void set${stub.propertyName?cap_first}(${stub.className} ${stub.propertyName}) {
        this.${stub.propertyName} = ${stub.propertyName};
        ${stub.property.propertyName} = null; //onBeforeSave will do serialization
    }
</#macro>