package sparta.AIBusinessProject.domain.category.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="p_category")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(access= AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(unique=true,nullable=false)
    private String categoryName;

    private Timestamp created_at;
    private String created_by;
    private Timestamp updated_at;
    private String updated_by;
    private Timestamp deleted_at;
    private String deleted_by;

    public static Category create(String name){
        return Category.builder()
                .categoryName(name)
                .build();
    }
}
