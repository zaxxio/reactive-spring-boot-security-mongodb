package org.wsd.app.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String roleId;
    @Indexed
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
