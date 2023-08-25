package telran.community.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class CommunityDto {
    private String name;
    private Set<String> subCommunities;
    private String description;
    private Set<String> problems;
    private Set<String> members;
    private Integer totalMembers;
    private Integer totalProblems;
}
