class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null){
            this.firstName = firstName;
        } else this.firstName = "";
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null){
            this.lastName = lastName;
        } else this.lastName = "";
    }

    public String getFullName() {
        if (firstName.length() > 0 && lastName.length() > 0){
            return firstName + " " + lastName;
        }else if (firstName.length() > 0) return firstName;
        else if (lastName.length() > 0) return lastName;
        return "Unknown"; // write your code here
    }
}