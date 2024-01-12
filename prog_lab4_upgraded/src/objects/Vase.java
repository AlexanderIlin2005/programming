package objects;

import enums.Gender;

public class Vase extends Place{
    public Vase(String name, Gender gender) {
        super(name, gender);
    }


    public BaseObject getCookie(){
        return new BaseObject() {
            {
                this.setName("Миндальное печенье");
                this.setGender(Gender.MIDDlE);
                System.out.println(this.getName() + " достали из "+ Vase.this.getName());
            }
        };



    };
}
