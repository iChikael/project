package com.cg.domain.dto.staff;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaffAvatarResDTO {
    private String id;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
}
