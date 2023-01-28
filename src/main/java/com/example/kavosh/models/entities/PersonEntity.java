package com.example.kavosh.models.entities;

import com.example.kavosh.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
@DynamicUpdate
public class PersonEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String fname;
    @Column(name = "last_name", nullable = false)
    private String lname;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<ProjectEntity> projects;

}
