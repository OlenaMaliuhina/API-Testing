package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Data
{
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}