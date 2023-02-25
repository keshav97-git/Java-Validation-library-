public class Validator {
    boolean isOpen = false;
    void open(){
           isOpen = true;
    }
    void validate(String input){
           if(!isOpen){
               throw new IllegalStateException("Validator is not open");
           }
        String[] parts = input.split(",");
           if(parts.length != 4){
               throw new IllegalArgumentException("Invalid input format" + input);
           }
           String name = parts[0].trim();
           if(name.isEmpty()){
               throw new IllegalArgumentException("Name is empty");
           }
           // valid gender
        String gender = parts[1].trim().toLowerCase();
           if(!gender.equals("male") && !gender.equals("female")){
               throw new IllegalArgumentException("Invalid gender" + gender);
           }
           // validate age
       try {
            int age = Integer.parseInt(parts[2].trim());
            if (age < 18 || age > 60 ) {
                throw new IllegalArgumentException("Age is negative" + age);
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid age" + parts[2]);
       }
        String position = parts[3].trim();
        if (position.isEmpty()) {
            throw new IllegalArgumentException("Position is empty");
        } else if (!position.equals(("Engineer"))&& !position.equals("Manager") && !position.equals("Scientist")) {
            throw new IllegalArgumentException("Invalid Position" + position);
            
        }

    }
    void close(){
        if(!isOpen){
            throw new IllegalStateException("Validator is not open");
        }
        isOpen = false;


    }
}
