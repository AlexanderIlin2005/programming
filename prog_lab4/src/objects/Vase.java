package objects;

import enums.Gender;

public class Vase extends Place{
    public Vase(String name, Gender gender) {
        super(name, gender);
    }


    public BaseObject getCookie(){
        return new BaseObject() {
            {
                this.name = "Миндальное печенье";
                this.gender = Gender.MIDDlE;
                System.out.println(this.name + " достали из "+Vase.this.name);
            }
        };



    };
}
