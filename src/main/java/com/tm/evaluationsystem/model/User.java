package com.tm.evaluationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String uniqueId;
    private String name;
    private String regNo;
    private String email;
}
