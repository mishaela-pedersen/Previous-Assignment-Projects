public class Character {

    static String name;
    static int age;
    static String gender;
    static String description;
    static String creator;
    static boolean fanmade;


    public Character(String n, int a, String g, String c, boolean f, String d){
        super();
        name = n;
        age = a;
        gender = g;
        creator = c;
        fanmade = f;
        description = d;

    }
    public Character(){
        super();
        name = "Unknown";
        age = 0;
        gender = "Not Specified";
        creator = "Unknown";
        description = "N/A";
        fanmade = false;


    }

    public static String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public static String getGender() {
        return gender;
    }

    public static String getCreator() {
        return creator;
    }

    public static String getDescription() {
        return description;
    }

    public static boolean isFanmade() {
        return fanmade;
    }

    public static void setName(String n) {
        if(n.trim().equals(""))
            throw new RuntimeException("Invalid name, shouldn't be blank.");
        if (n.trim().length()>100)
            throw new RuntimeException("Invalid name, length is too long.");
        name = n.trim();
    }

    public static void setAge(int a) {
        if(a < 0)
            throw new RuntimeException("Invalid age; cannot be negative.");
        age = a;
    }

    public static void setGender(String g) {

        if(g.equals("female") || g.equals("Female") || g.equals("male") || g.equals("Male")){
            if(g.equals("male") || g.equals("Male")){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
        }
        else{
            gender = "Not Specified";
        }


    }

    public static void setCreator(String c) {
        if(c.length() > 20){
            throw new RuntimeException("Invalid Creator Name; must be 20 characters or less");
        }
        else {
            creator = c;
        }
    }

    public static void setFanmade(boolean fanmade) {
        Character.fanmade = fanmade;

    }

    public static void setDescription(String description) {
        Character.description = description;
    }




    @Override
    public String toString() {
        String f;
        if(fanmade){
            f = "Yes";
        }
        else{
            f = "No";
        }
        return("\nPROFILE:\n"+"Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nCreator: " + creator + "\nDescription: '" + description + "'" + "\nFanmade?: " + f);

    }
}


