package objects;

import enums.Gender;
import interfaces.WordAgreementable;

import java.util.Objects;

public abstract class BaseObject implements WordAgreementable {
    public String name;
    public Gender gender;

    public BaseObject(String name, Gender gender){
        this.name = name;
        this.gender = gender;

    }

    public BaseObject() {

    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return this.name;
    }


}
