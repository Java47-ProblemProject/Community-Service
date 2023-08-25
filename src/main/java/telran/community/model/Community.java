package telran.community.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
@Document(collection = "Communities")
public class Community {
    @Setter
    @Id
    private String name;
    private Set<String> subCommunities;
    @Setter
    private String description;
    private Set<String> problems;
    private Set<String> members;
    private Integer totalMembers;
    private Integer totalProblems;

    public Community() {
        this.subCommunities = new HashSet<>();
        this.problems = new HashSet<>();
        this.members = new HashSet<>();
        this.totalMembers = 0;
        this.totalProblems = 0;
    }

    public void addSubCommunities(Set<String> newCommunities) {
        this.subCommunities.addAll(newCommunities);
    }

    public void removeSubCommunities(String subCommunity) {
        this.subCommunities.remove(subCommunity);
    }

    public void addProblem(String problemId) {
        this.problems.add(problemId);
    }

    public void removeProblem(String problemId) {
        this.problems.remove(problemId);
    }

    public void addMember(String profileId) {
        this.members.add(profileId);
    }

    public void removeMember(String profileId) {
        this.members.remove(profileId);
    }

    public void setTotalMembers() {
        this.totalMembers = members.size();
    }

    public void setTotalProblems() {
        this.totalProblems = problems.size();
    }


}
