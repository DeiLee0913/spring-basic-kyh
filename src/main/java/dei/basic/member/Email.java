package dei.basic.member;

public class Email {
    private final String value;

    public Email(String value) {
        if(!value.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email address!");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        // 자기 자신과 비교하면 true
        if (this == o) return true;
        // 타입이 다르면 fasle
        if (!(o instanceof Email)) return false;
        // 타입 같으면 다운캐스팅
        Email email = (Email) o;
        // 내부 문자열(value) 기준으로 비교
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public String toString() {
        return value;
    }
}
