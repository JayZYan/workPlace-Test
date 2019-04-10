package OOD.Storage;

public class User {
    private String username;
    private String password;
    private String email;

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
    }
    private static class UserBuilder {
        private String username;
        private String password;
        private String email;

		private UserBuilder(String username, String password) {
            this.username = username; //required
            this.password = password;
        }
//        public UserBuilder setEmail(String email) {
//            this.email = email;	//optional
//            return this;
//        }
        private void setEmail(String email) {
		    this.email = email;
        }
        private User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        String emailAddress = "dsaf@gmail.com";
        User.UserBuilder builder = new User.UserBuilder("name", "password");
        builder.setEmail(emailAddress);
        User user = builder.build();

        //User user = new User.UserBuilder("name", "password").setEmail("..").build();

        System.out.println(user.email);
        System.out.println(user.username);
        System.out.println(user.password);
    }
}



