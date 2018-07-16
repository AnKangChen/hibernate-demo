import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author:akchen(helios)
 */
@Data
@Entity
@Table(name = "USER")
public class Employee {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    public String password;
}
