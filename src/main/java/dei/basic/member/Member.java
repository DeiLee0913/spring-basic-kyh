package dei.basic.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;
    private Email email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Email getEmail() {  return email;   }

    public void setEmail(Email email) {   this.email = email; }

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Member(Long id, String name, Grade grade, Email email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }
}
