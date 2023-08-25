package telran.community.dto;

import lombok.Getter;

import java.util.Set;
@Getter
public class CreateCommunityDto {
    private String name;
    private Set<String> subCommunities;
    private String description;
}
