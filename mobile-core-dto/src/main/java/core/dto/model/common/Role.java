package core.dto.model.common;

/**
 * @author DucBa
 */
public class Role {
    private long id;
    private int role;
    private String description;

    public Role() {
    }

    public Role(long id, int role, String description) {
        this.id = id;
        this.role = role;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
