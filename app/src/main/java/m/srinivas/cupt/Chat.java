package m.srinivas.cupt;

public class Chat {

    String profilepic,name,status;

    public Chat(String profilepic, String name, String status) {
        this.profilepic = profilepic;
        this.name = name;
        this.status = status;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
