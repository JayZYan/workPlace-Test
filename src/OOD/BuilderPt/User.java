package OOD.BuilderPt;

public class User {
    String userName;
    String psd;
    String FN;
    String LN;
    int age;
    Gender gender;
    String phone;
    String email;

    private User(UserBuilder builder) {
        this.userName = builder.userName;
        this.psd = builder.psd;
        this.FN = builder.FN;
        this.LN = builder.LN;
        this.age = builder.age;
        this.gender = builder.gender;
        this.phone = builder.phone;
        this.email = builder.email;
    }
    @Override
    public String toString() {
        return userName + ", " + psd + ", " + FN
                + ", " + LN + ", " + phone + ", " + gender
                + ", " + email;
    }


    public static class UserBuilder {
        String userName;
        String psd;
        String FN;
        String LN;
        int age;
        Gender gender;
        String phone;
        String email;

        public UserBuilder(String userName, String psd) {
            this.userName = userName;
            this.psd = psd;
        }

        public UserBuilder setFN(String FN) {
            this.FN = FN;
            return this;
        }

        public UserBuilder setLN(String LN) {
            this.LN = LN;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

}
