package BaseModel;

import utility.Validatable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"age"})
public class Human implements Validatable {
    private Integer age; //Значение поля должно быть больше 0
    public Human(){}
    public Human(Integer age){
            this.age = age;
        }
    @XmlElement
    public Integer getAge(){
            return this.age;
        }

    public void setAge(Integer newAge){
            this.age = newAge;
        }

    @Override
    public boolean validate() {
            return this.age > 0;
        }

    @Override
    public String toString(){
        return "age="+age;
    }



}

