package BaseModel;

import utility.Validatable;

public class Human implements Validatable {
        private Integer age; //Значение поля должно быть больше 0

        public Human(Integer age){
            this.age = age;
        }

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


}

