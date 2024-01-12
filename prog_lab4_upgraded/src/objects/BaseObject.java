package objects;

import enums.Gender;
import interfaces.WordAgreementable;

import java.util.Objects;

public abstract class BaseObject implements WordAgreementable {
    private String name;
    private Gender gender;

    public BaseObject(String name, Gender gender){
        this.name = name;
        this.gender = gender;

    }

    public BaseObject() {

    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public Gender getGender(){
        return this.gender;
    }

    public void setGender(Gender newGender){
        this.gender = newGender;
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
