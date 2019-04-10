package OOD.BuilderPt;

public class BuilderPattern {
    public static void main(String[] args) {

        User user = new User.UserBuilder("David", "12345")
                .setFN("First Name")
                .setLN("Last Name")
                .setPhone("123456789")
                .setGender(Gender.Male)
                .setEmail("David@gmail.com")
                .build();
        System.out.println(user);
    }

}
